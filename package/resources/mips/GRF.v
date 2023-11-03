`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    11:11:52 10/31/2023 
// Design Name: 
// Module Name:    GRF 
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
module GRF(
    input Clk,
    input Reset,
    input [4:0] Rs,
    input [4:0] Rt,
    input [4:0] Wt,
    input [31:0] Wd,
    input Wr,
    input [31:0] Pc,
    output [31:0] Rd1,
    output [31:0] Rd2
    );

    reg [31:0] Reg[31:1];

    assign Rd1 = (Rs == 5'b0)? 0: Reg[Rs];
    assign Rd2 = (Rt == 5'b0)? 0: Reg[Rt];

    integer i;

    always @(posedge Clk) begin
        if (Reset) begin
            for (i = 1; i <= 31; i = i + 1)
                Reg[i] <= 32'b0;
        end
        else begin
            if (Wr && Wt != 0) begin
                Reg[Wt] <= Wd;
				$display("@%h: $%d <= %h", Pc, Wt, Wd);
            end
        end
    end

endmodule
