`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    11:27:31 10/31/2023 
// Design Name: 
// Module Name:    Controller 
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
`define R 6'b000000
`define ADD 6'b100000
`define SUB 6'b100010
`define ORI 6'b001101
`define LW 6'b100011
`define SW 6'b101011
`define BEQ 6'b000100
`define LUI 6'b001111
`define JAL 6'b000011
`define JR 6'b001000

module Controller(
    input [5:0] opcode,
    input [5:0] funct,
    output [1:0] NPCOp,
    output [1:0] EXTOp,
    output [1:0] ALUOp,
    output GRFWr,
    output DMWr,
    output [1:0] M1Sel,
    output [1:0] M2Sel,
    output M3Sel
    );

    wire add, sub, ori, lw, sw, beq, lui, jal, jr, R;

    assign R = (opcode == `R);
    assign add = R & (funct == `ADD);
    assign sub = R & (funct == `SUB);
    assign ori = (opcode == `ORI);
    assign lw = (opcode == `LW);
    assign sw = (opcode == `SW);
    assign beq = (opcode == `BEQ);
    assign lui = (opcode == `LUI);
    assign jal = (opcode == `JAL);
    assign jr = R & (funct == `JR);

    assign NPCOp = {jal | jr, beq | jr};
    assign EXTOp = {lui, lw | sw};
    assign ALUOp = {ori, sub};
    assign GRFWr = ~(sw | beq | jr);
    assign DMWr = sw;
    assign M1Sel = {jal, add | sub};
    assign M2Sel = {lui | jal, lw | jal};
    assign M3Sel = ori | lw | sw;

endmodule
