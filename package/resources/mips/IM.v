`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    10:53:13 10/31/2023 
// Design Name: 
// Module Name:    IM 
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
`define IM_BEGIN 32'hc00
`define IM_END   32'h1bff

module IM(
    input [12:0] A,
    output [31:0] D
    );

    reg [31:0] im[`IM_BEGIN:`IM_END];

    initial begin
        $readmemh("code.txt", im);
    end

    assign D = im[A];

endmodule
