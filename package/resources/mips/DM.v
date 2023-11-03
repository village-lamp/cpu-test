`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    11:20:23 10/31/2023 
// Design Name: 
// Module Name:    DM 
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
`define DM_BEGIN 32'h0
`define DM_END 32'hbff

module DM(
    input Clk,
    input Reset,
    input [31:0] Ad,
    input [31:0] Wd,
    input Wr,
    input [31:0] Pc,
    output [31:0] Rd
    );

    reg [31:0] mem[`DM_END:`DM_BEGIN];

    integer i;

    assign Rd = mem[Ad[13:2]];

    always @(posedge Clk) begin
        if (Reset) begin
            for (i = `DM_BEGIN; i <= `DM_END; i = i + 1)
                mem[i] <= 32'b0;
        end
        else begin
            if (Wr) begin
                mem[Ad[13:2]] <= Wd;
                $display("@%h: *%h <= %h", Pc, Ad, Wd);
            end
        end
    end
    
endmodule
