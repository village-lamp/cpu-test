`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    11:09:32 10/31/2023 
// Design Name: 
// Module Name:    ALU 
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
`define OADD 2'b00
`define OSUB 2'b01
`define OOR 2'b10

module ALU(
    input [31:0] A,
    input [31:0] B,
    input [1:0] ALUOp,
    output [31:0] C,
    output zero
    );
    
    assign zero = (A == B);
    assign C = (ALUOp == `OADD)? A + B:
               (ALUOp == `OSUB)? A - B:
               (ALUOp == `OOR)? A | B:
               32'b0;

endmodule
