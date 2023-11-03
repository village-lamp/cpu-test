`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    11:25:27 10/31/2023 
// Design Name: 
// Module Name:    EXT 
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
`define UE 2'b00
`define SE 2'b01
`define HE 2'b10

module EXT(
    input [15:0] imm,
    input [1:0] EXTOp,
    output [31:0] out
    );

    assign out = (EXTOp == `UE)? {16'b0, imm}:
                 (EXTOp == `SE)? {{16{imm[15]}}, imm}:
                 (EXTOp == `HE)? {imm, 16'b0}:
                 32'b0;
    
endmodule
