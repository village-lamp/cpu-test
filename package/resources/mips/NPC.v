`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    11:02:17 10/31/2023 
// Design Name: 
// Module Name:    NPC 
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
`define PCADD4 2'b00
`define PC16 2'b01
`define PC26 2'b10
`define PCRA 2'b11

module NPC(
    input [31:0] Pc,
    input [15:0] imm,
    input [25:0] instr_index,
    input [31:0] Ra,
    input zero,
    input [1:0] NPCOp,
    output [31:0] Pc4,
    output [31:0] Npc
    );
    
    wire [31:0] immPc, indexPc;

    assign Pc4 = Pc + 4;
    assign immPc = Pc4 + {{14{imm[15]}}, imm, 2'b00};
    assign indexPc = {Pc[31:28], instr_index, 2'b00};
    assign Npc = (NPCOp == `PCADD4)? Pc4:
                 (NPCOp == `PC16 & zero)? immPc:
                 (NPCOp == `PC26)? indexPc:
                 (NPCOp == `PCRA)? Ra:
                 Pc4;

endmodule
