`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    10:50:47 10/31/2023 
// Design Name: 
// Module Name:    PC 
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
`define PC_BEGIN 32'h3000

module PC(
    input Clk,
    input Reset,
    input [31:0] Npc,
    output reg [31:0] Pc
    );

    always @(posedge Clk) begin
        if (Reset) Pc <= `PC_BEGIN;
        else Pc <= Npc;
    end

endmodule
