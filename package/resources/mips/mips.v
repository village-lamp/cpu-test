`include "ALU.v"
`include "Controller.v"
`include "DM.v"
`include "EXT.v"
`include "GRF.v"
`include "IM.v"
`include "NPC.v"
`include "PC.v"
`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    11:37:01 10/31/2023 
// Design Name: 
// Module Name:    mips 
// Project Name: 
// Target Devices: 
// Tool versions: 
// Description: 
//
// Dependencies: 
//
// Revision: 
// Revision 0.01 - File Created
// Additional Comments: 
//
//////////////////////////////////////////////////////////////////////////////////
//M1
`define M1RT 2'b00
`define M1RD 2'b01
`define M1RA 2'b10
//M2
`define M2ALU 2'b00 
`define M2DM 2'b01
`define M2EXT 2'b10
`define M2PC4 2'b11
//M3
`define M3RT 1'b0
`define M3EXT 1'b1

module mips(
    input clk,
    input reset
    );
    
    wire [31:0] Pc, Npc;

    PC _PC(
        .Npc  (Npc),
        .Pc   (Pc),
        .Clk  (clk),
        .Reset(reset)
        );

    wire zero;
    wire [15:0] imm;
    wire [25:0] instr_index;
    wire [31:0] Ra, Pc4;
    wire [1:0] NPCOp;

    NPC _NPC(
        .Npc         (Npc),
        .Pc          (Pc),
        .zero        (zero),
        .imm         (imm),
        .instr_index (instr_index),
        .Ra          (Ra),
        .NPCOp       (NPCOp),
        .Pc4         (Pc4)
        );

    wire [12:0] IMA;
    wire [31:0] IMD;

    assign IMA = Pc[14:2];
    assign instr_index = IMD[25:0];
    assign imm = IMD[15:0];

    IM _IM(
        .A(IMA),
        .D(IMD)
        );

    wire [4:0] Rs, Rt, Wt;
    wire [31:0] GRFWd, Rd1, Rd2;
    wire GRFWr;

    assign Rs = IMD[25:21];
    assign Rt = IMD[20:16];
    assign Ra = Rd1;

    GRF _GRF(
        .Clk  (clk),
        .Reset(reset),
        .Rs   (Rs),
        .Rt   (Rt),
        .Wt   (Wt),
        .Wd   (GRFWd),
        .Wr   (GRFWr),
        .Rd1  (Rd1),
        .Rd2  (Rd2),
        .Pc   (Pc)
        );

    wire [31:0] ALUA, ALUB, ALUC;
    wire [1:0] ALUOp;

    assign ALUA = Rd1;

    ALU _ALU(
        .zero (zero),
        .A    (ALUA),
        .B    (ALUB),
        .ALUOp(ALUOp),
        .C    (ALUC)
        );

    wire [31:0] DMWd, DMAd, DMRd;
    wire DMWr;

    assign DMWd = Rd2;
    assign DMAd = ALUC;

    DM _DM(
        .Clk  (clk),
        .Reset(reset),
        .Wd   (DMWd),
        .Wr   (DMWr),
        .Ad   (DMAd),
        .Rd   (DMRd),
        .Pc   (Pc)
        );

    wire [1:0] EXTOp;
    wire [31:0] EXTout;

    EXT _EXT(
        .imm  (imm),
        .EXTOp(EXTOp),
        .out  (EXTout)
        );

    //M1
    wire [4:0] M1, Rd;
    wire [1:0] M1Sel;

    assign Rd = IMD[15:11];
    assign Wt = M1;
    assign M1 = (M1Sel == `M1RT)? Rt:
                (M1Sel == `M1RD)? Rd:
                (M1Sel == `M1RA)? 5'd31:
                5'b0;

    //M2
    wire [31:0] M2;
    wire [1:0] M2Sel;

    assign GRFWd = M2;
    assign M2 = (M2Sel == `M2ALU)? ALUC:
                (M2Sel == `M2DM)? DMRd:
                (M2Sel == `M2EXT)? EXTout:
                (M2Sel == `M2PC4)? Pc4:
                31'b0;

    //M3
    wire [31:0] M3;
    wire M3Sel;

    assign ALUB = M3;
    assign M3 = (M3Sel == `M3RT)? Rd2:
                (M3Sel == `M3EXT)? EXTout:
                1'b0; 

    wire [5:0] opcode, funct;

    assign opcode = IMD[31:26];
    assign funct = IMD[5:0];

    Controller CLT(
        .ALUOp (ALUOp),
        .EXTOp (EXTOp),
        .NPCOp (NPCOp),
        .M3Sel (M3Sel),
        .M2Sel (M2Sel),
        .M1Sel (M1Sel),
        .DMWr  (DMWr),
        .GRFWr (GRFWr),
        .opcode(opcode),
        .funct (funct)
        );

endmodule
