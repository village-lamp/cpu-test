line1: ori $16, $0, 56076
line2: ori $17, $0, 55155
line3: ori $18, $0, 6122
line4: ori $19, $0, 9281
line5: ori $20, $0, 19930
line6: ori $21, $0, 4258
line7: ori $22, $0, 37117
line8: ori $23, $0, 56139
line9: ori $24, $0, 60257
line10: ori $25, $0, 15908
line11: ori $26, $0, 2
line12: ori $27, $0, 3
line13: ori $28, $0, 1
line14: ori $29, $0, 3
line15: ori $30, $0, 1
line16: lui $1, 901
line17: ori $1, $1, 18156
line18: lui $2, 22068
line19: ori $2, $2, 48165
line20: lui $3, 31864
line21: ori $3, $3, 14414
line22: lui $4, 30043
line23: ori $4, $4, 1715
line24: lui $5, 18918
line25: ori $5, $5, 16329
line26: lui $6, 42330
line27: ori $6, $6, 2124
line28: lui $7, 2540
line29: ori $7, $7, 65388
line30: lui $8, 28489
line31: ori $8, $8, 47866
line32: lui $9, 50011
line33: ori $9, $9, 52716
line34: lui $10, 20021
line35: ori $10, $10, 33088
line36: lui $11, 50211
line37: ori $11, $11, 4699
line38: lui $12, 34091
line39: ori $12, $12, 6734
line40: lui $13, 52758
line41: ori $13, $13, 56359
line42: lui $14, 35867
line43: ori $14, $14, 22417
line44: lui $15, 31304
line45: ori $15, $15, 49708
line46: lw $19, 6122($18)
line47: sw $10, 11488($19)
line48: lui $4, 4219
line49: lui $14, 44363
line50: lui $3, 60487
line51: beq $31, $31, line53
line52: nop
line53: add $16, $26, $31
line54: add $3, $14, $16
line55: ori $17, $19, 604
line56: beq $31, $31, line79
line57: nop
line58: nop
line59: sub $15, $9, $5
line60: add $4, $4, $14
line61: sub $11, $4, $25
line62: ori $21, $24, 24238
line63: ori $5, $21, 16594
line64: add $24, $21, $28
line65: add $24, $21, $27
line66: lui $10, 55603
line67: lui $9, 64927
line68: sub $22, $27, $28
line69: ori $7, $10, 37653
line70: sub $26, $27, $28
line71: lui $7, 50799
line72: lui $13, 52694
line73: sw $7, 10880($26)
line74: sub $19, $24, $26
line75: sub $2, $19, $2
line76: lui $14, 5360
line77: jr $31
line78: nop
line79: jal line102
line80: nop
line81: nop
line82: sub $2, $31, $22
line83: lui $15, 64430
line84: ori $14, $15, 2478
line85: beq $15, $15, line303
line86: nop
line87: lui $13, 17733
line88: sw $30, 5046($17)
line89: lw $27, 5046($17)
line90: sub $13, $14, $27
line91: lw $23, 2479($30)
line92: add $5, $27, $23
line93: beq $13, $13, line144
line94: nop
line95: lui $9, 1566
line96: lui $14, 56616
line97: sw $9, 9775($30)
line98: lw $29, 0($19)
line99: lui $11, 434
line100: beq $11, $11, line107
line101: nop
line102: ori $20, $17, 24463
line103: add $2, $20, $17
line104: lui $9, 43646
line105: beq $31, $31, line95
line106: nop
line107: ori $16, $26, 589
line108: beq $31, $31, line132
line109: nop
line110: lui $3, 37370
line111: lw $12, 11487($28)
line112: add $7, $3, $12
line113: add $5, $12, $7
line114: lw $12, 10884($17)
line115: ori $21, $29, 13479
line116: add $19, $16, $17
line117: sub $12, $8, $12
line118: lui $7, 28509
line119: sub $9, $7, $28
line120: lui $13, 19058
line121: lw $16, 10007($28)
line122: add $16, $30, $26
line123: sw $13, 4397($16)
line124: sw $16, 2477($16)
line125: ori $2, $13, 38898
line126: sub $25, $16, $28
line127: ori $1, $2, 11663
line128: add $21, $29, $16
line129: lui $5, 58022
line130: jr $31
line131: nop
line132: lui $10, 12000
line133: sub $20, $20, $26
line134: add $1, $20, $16
line135: add $6, $1, $16
line136: add $14, $21, $23
line137: jal line110
line138: nop
line139: sub $3, $23, $5
line140: add $17, $26, $29
line141: sw $1, 5902($17)
line142: beq $31, $31, line87
line143: nop
line144: lw $8, 4709($19)
line145: sub $26, $30, $28
line146: ori $4, $14, 12542
line147: lw $23, 10008($26)
line148: sub $23, $26, $23
line149: lw $16, 3886($18)
line150: ori $10, $23, 383
line151: add $9, $10, $22
line152: ori $13, $20, 65315
line153: lw $19, 2478($17)
line154: ori $29, $30, 1
line155: jal line157
line156: nop
line157: ori $22, $31, 32166
line158: ori $7, $19, 37367
line159: lw $24, 2479($29)
line160: sub $10, $22, $7
line161: beq $31, $31, line182
line162: nop
line163: ori $13, $8, 51960
line164: lui $15, 45224
line165: beq $26, $26, line232
line166: nop
line167: sw $26, 6424($21)
line168: ori $18, $0, 61586
line169: ori $19, $0, 12441
line170: sub $3, $18, $19
line171: lw $6, 5736($21)
line172: sub $25, $31, $26
line173: sw $13, 712($21)
line174: add $30, $28, $29
line175: lui $2, 10098
line176: add $1, $30, $2
line177: ori $29, $29, 3
line178: sub $10, $29, $2
line179: add $15, $24, $29
line180: jr $31
line181: nop
line182: sw $7, 7761($24)
line183: lw $6, 5904($23)
line184: lw $4, 5366($18)
line185: ori $26, $29, 3
line186: ori $21, $0, 4040
line187: jal line167
line188: nop
line189: sub $14, $15, $10
line190: sw $14, 9389($26)
line191: lw $6, 7764($23)
line192: sub $22, $25, $29
line193: lui $15, 43245
line194: ori $8, $6, 3377
line195: sw $15, 3264($21)
line196: ori $3, $21, 12323
line197: ori $18, $0, 21123
line198: lw $28, 5047($28)
line199: lui $10, 9859
line200: ori $20, $28, 19103
line201: jal line203
line202: nop
line203: beq $26, $29, line206
line204: nop
line205: nop
line206: lui $4, 29934
line207: ori $6, $20, 3915
line208: add $14, $20, $4
line209: sub $21, $26, $28
line210: lui $12, 61052
line211: lw $9, 9390($21)
line212: sw $3, 5414($21)
line213: lui $14, 21580
line214: lui $1, 1046
line215: jal line59
line216: nop
line217: lui $11, 39827
line218: sw $11, 6722($17)
line219: lui $3, 2528
line220: jal line67
line221: nop
line222: add $8, $10, $14
line223: lw $5, 10877($29)
line224: add $21, $27, $31
line225: lw $6, 4752($16)
line226: ori $16, $0, 62166
line227: ori $20, $0, 54596
line228: lui $8, 45242
line229: lui $11, 56804
line230: beq $31, $31, line162
line231: nop
line232: lw $15, 5415($28)
line233: ori $25, $16, 43498
line234: sw $15, 5536($26)
line235: add $25, $26, $27
line236: ori $28, $27, 2
line237: sub $5, $28, $25
line238: sw $24, 11967($25)
line239: add $23, $28, $25
line240: add $15, $5, $28
line241: ori $20, $25, 19193
line242: lui $14, 28232
line243: add $17, $20, $27
line244: jal line267
line245: nop
line246: nop
line247: beq $9, $9, line323
line248: nop
line249: ori $21, $26, 8553
line250: add $30, $27, $30
line251: sw $30, 8393($30)
line252: add $1, $1, $31
line253: add $24, $24, $28
line254: sub $6, $8, $24
line255: add $4, $6, $8
line256: ori $2, $4, 63520
line257: sw $2, 5077($30)
line258: ori $30, $26, 1
line259: sub $22, $28, $30
line260: add $5, $22, $2
line261: lw $3, 10282($22)
line262: add $4, $5, $8
line263: lui $15, 39908
line264: lw $22, 8292($23)
line265: beq $22, $22, line271
line266: nop
line267: add $21, $23, $27
line268: ori $1, $21, 57454
line269: beq $31, $31, line249
line270: nop
line271: sub $7, $15, $3
line272: add $3, $7, $15
line273: sub $4, $22, $1
line274: add $8, $4, $7
line275: lw $19, 8296($22)
line276: sub $26, $28, $30
line277: jal line76
line278: nop
line279: lw $26, 8396($19)
line280: sub $27, $26, $28
line281: lui $11, 8814
line282: sw $27, 10333($26)
line283: ori $26, $27, 0
line284: lui $14, 22580
line285: ori $30, $29, 0
line286: jal line127
line287: nop
line288: lui $4, 57582
line289: add $3, $30, $24
line290: sub $23, $31, $19
line291: sub $18, $30, $27
line292: add $25, $30, $26
line293: ori $30, $26, 1
line294: sub $25, $29, $30
line295: sub $2, $8, $25
line296: ori $15, $2, 11757
line297: ori $17, $26, 10854
line298: sw $16, 1505($28)
line299: add $10, $15, $2
line300: ori $20, $17, 50375
line301: beq $26, $27, line82
line302: nop
line303: jal line178
line304: nop
line305: lw $9, 11556($26)
line306: beq $26, $27, line321
line307: nop
line308: sub $19, $30, $16
line309: add $1, $17, $16
line310: lw $12, 11555($16)
line311: lw $11, 9392($19)
line312: sub $28, $30, $29
line313: sw $12, 10973($18)
line314: sw $28, 2460($28)
line315: ori $16, $0, 32053
line316: sub $15, $11, $31
line317: lw $22, 9812($28)
line318: lui $11, 28579
line319: beq $5, $5, line367
line320: nop
line321: beq $26, $27, line247
line322: nop
line323: beq $26, $27, line326
line324: nop
line325: nop
line326: add $8, $14, $15
line327: jal line329
line328: nop
line329: lui $15, 54692
line330: ori $22, $30, 43940
line331: ori $3, $20, 21858
line332: lui $14, 12890
line333: add $25, $30, $26
line334: add $10, $19, $25
line335: lw $7, 9391($25)
line336: sw $25, 9811($25)
line337: ori $21, $25, 61859
line338: sub $10, $22, $21
line339: ori $13, $21, 50072
line340: sub $10, $27, $22
line341: add $10, $10, $24
line342: lui $9, 10033
line343: sw $9, 9796($26)
line344: add $23, $26, $25
line345: sub $23, $29, $30
line346: ori $16, $20, 42698
line347: ori $15, $23, 57156
line348: lw $4, 9774($23)
line349: ori $16, $30, 61377
line350: sw $1, 4588($27)
line351: add $6, $15, $24
line352: lui $11, 39557
line353: ori $1, $11, 59833
line354: sw $14, 3163($30)
line355: add $5, $1, $11
line356: lui $12, 55978
line357: lw $12, 5077($29)
line358: sw $12, 3137($18)
line359: ori $10, $12, 50463
line360: ori $16, $0, 65025
line361: add $7, $16, $10
line362: sub $1, $24, $7
line363: add $29, $27, $30
line364: add $16, $29, $19
line365: beq $26, $27, line307
line366: nop
line367: sw $22, 4079($22)
line368: add $29, $29, $28
line369: jal line388
line370: nop
line371: sw $11, 10751($22)
line372: beq $15, $15, line721
line373: nop
line374: sub $3, $12, $4
line375: ori $14, $4, 34226
line376: lui $3, 14709
line377: lui $2, 41868
line378: ori $25, $25, 4365
line379: ori $17, $26, 13195
line380: lui $6, 55623
line381: beq $17, $17, line517
line382: nop
line383: lui $12, 23562
line384: lui $4, 41862
line385: lui $8, 49191
line386: jr $31
line387: nop
line388: ori $5, $14, 16871
line389: sub $22, $29, $28
line390: lui $15, 30384
line391: lw $20, 4795($22)
line392: sw $15, 4728($20)
line393: lw $18, 1508($20)
line394: lw $18, 2479($25)
line395: lui $13, 11509
line396: lw $28, 8393($18)
line397: ori $27, $28, 0
line398: sub $23, $24, $29
line399: ori $7, $27, 30852
line400: lui $9, 60152
line401: sub $6, $15, $7
line402: lw $27, 10336($26)
line403: lui $14, 23394
line404: sub $2, $14, $8
line405: lui $8, 36150
line406: add $20, $27, $28
line407: add $9, $8, $15
line408: add $19, $22, $28
line409: sw $20, 12100($19)
line410: lw $10, 5901($20)
line411: sw $4, 10852($19)
line412: lui $8, 22960
line413: jal line417
line414: nop
line415: beq $15, $15, line636
line416: nop
line417: lui $12, 55725
line418: sub $11, $12, $8
line419: sub $9, $31, $8
line420: sw $11, 371($30)
line421: lw $9, 1792($19)
line422: jal line424
line423: nop
line424: add $28, $30, $27
line425: lw $1, 383($28)
line426: add $27, $28, $27
line427: ori $27, $28, 0
line428: jal line62
line429: nop
line430: ori $28, $27, 0
line431: sw $29, 5959($27)
line432: jal line73
line433: nop
line434: sw $7, 10727($28)
line435: add $13, $27, $28
line436: sw $27, 10535($27)
line437: lw $15, 383($28)
line438: lw $28, 10535($28)
line439: sub $27, $28, $26
line440: sw $15, 6327($27)
line441: sub $28, $27, $28
line442: sub $1, $28, $14
line443: jal line447
line444: nop
line445: beq $2, $2, line1146
line446: nop
line447: lui $6, 64845
line448: lw $7, 372($28)
line449: jal line127
line450: nop
line451: jal line128
line452: nop
line453: lui $4, 28007
line454: ori $18, $0, 3764
line455: add $10, $4, $7
line456: ori $18, $0, 34104
line457: jal line474
line458: nop
line459: jr $31
line460: nop
line461: lui $6, 47353
line462: jr $31
line463: nop
line464: sw $20, 10676($24)
line465: sw $21, 9795($30)
line466: ori $18, $23, 47522
line467: lw $17, 6091($30)
line468: sub $18, $29, $30
line469: jr $31
line470: nop
line471: lui $9, 49794
line472: beq $1, $1, line503
line473: nop
line474: add $5, $10, $3
line475: sub $5, $10, $18
line476: lui $5, 18525
line477: add $23, $28, $30
line478: sub $30, $27, $26
line479: sw $9, 115($30)
line480: jal line496
line481: nop
line482: nop
line483: sw $7, 8150($21)
line484: sw $15, 822($21)
line485: beq $7, $7, line941
line486: nop
line487: ori $24, $27, 30764
line488: beq $3, $3, line618
line489: nop
line490: sub $26, $29, $27
line491: jr $31
line492: nop
line493: lw $17, 6091($29)
line494: jr $31
line495: nop
line496: sub $28, $27, $28
line497: sub $26, $28, $30
line498: ori $19, $30, 31264
line499: ori $20, $26, 28493
line500: add $25, $31, $26
line501: beq $31, $31, line471
line502: nop
line503: add $6, $22, $9
line504: ori $15, $9, 63541
line505: add $4, $9, $17
line506: add $24, $26, $30
line507: lui $3, 13825
line508: lw $25, 9811($24)
line509: lw $25, 3967($25)
line510: beq $31, $31, line512
line511: nop
line512: ori $23, $0, 39975
line513: jal line383
line514: nop
line515: beq $31, $31, line374
line516: nop
line517: lw $26, 2460($26)
line518: lw $18, 2480($26)
line519: lw $13, 9389($18)
line520: add $19, $18, $26
line521: lw $22, 4077($18)
line522: sub $10, $13, $19
line523: lw $21, 2477($19)
line524: sw $21, 9099($22)
line525: jal line63
line526: nop
line527: jal line64
line528: nop
line529: ori $27, $26, 1
line530: lw $24, 11288($26)
line531: ori $1, $20, 53465
line532: lui $8, 12556
line533: lw $23, 2480($24)
line534: add $29, $26, $27
line535: jal line493
line536: nop
line537: lui $13, 13459
line538: sub $22, $18, $17
line539: add $11, $13, $17
line540: sw $13, 1492($17)
line541: add $19, $26, $22
line542: lw $25, 5697($19)
line543: add $22, $25, $19
line544: sw $25, 688($25)
line545: sw $22, 8203($28)
line546: lw $17, 2477($22)
line547: add $17, $17, $26
line548: jal line490
line549: nop
line550: jal line573
line551: nop
line552: sub $2, $24, $10
line553: lui $14, 32956
line554: sw $2, 7893($21)
line555: sub $23, $21, $30
line556: sw $23, 3557($30)
line557: sw $15, 8560($23)
line558: sub $8, $12, $14
line559: ori $13, $23, 4974
line560: add $10, $30, $8
line561: ori $19, $22, 58020
line562: add $27, $26, $27
line563: lui $5, 31742
line564: lui $9, 11061
line565: add $16, $27, $30
line566: sub $6, $3, $5
line567: add $22, $30, $16
line568: add $8, $25, $6
line569: lw $29, 10464($25)
line570: sub $9, $25, $8
line571: jr $31
line572: nop
line573: sub $6, $26, $24
line574: ori $6, $6, 24984
line575: add $30, $27, $26
line576: jal line464
line577: nop
line578: sub $2, $18, $24
line579: sub $2, $17, $18
line580: lui $15, 59147
line581: sw $2, 7313($21)
line582: ori $6, $6, 20338
line583: add $12, $6, $15
line584: jal line177
line585: nop
line586: sub $6, $15, $12
line587: lui $11, 20232
line588: lui $10, 52860
line589: sw $11, 12039($27)
line590: ori $20, $18, 38878
line591: jal line594
line592: nop
line593: nop
line594: lui $3, 41850
line595: add $19, $23, $30
line596: sw $12, 7260($19)
line597: lui $4, 22108
line598: sw $19, 3905($23)
line599: sub $21, $29, $18
line600: jal line611
line601: nop
line602: sub $25, $30, $18
line603: lw $1, 11485($25)
line604: sub $7, $25, $1
line605: sw $1, 3097($29)
line606: lui $14, 19576
line607: lw $15, 7893($30)
line608: sw $15, 1612($18)
line609: jr $31
line610: nop
line611: ori $27, $29, 1
line612: ori $8, $4, 30909
line613: ori $12, $21, 8131
line614: lui $3, 53115
line615: lw $2, 10976($18)
line616: beq $31, $31, line487
line617: nop
line618: lui $8, 55063
line619: ori $13, $8, 64891
line620: sw $8, 10332($17)
line621: sub $3, $13, $17
line622: sub $22, $24, $27
line623: lui $7, 39539
line624: lui $5, 24280
line625: lui $12, 11647
line626: sw $6, 3244($26)
line627: ori $20, $27, 34292
line628: lui $9, 23244
line629: lw $1, 4292($26)
line630: sub $5, $20, $29
line631: lui $15, 20398
line632: lw $17, 2479($30)
line633: ori $1, $15, 25106
line634: beq $31, $31, line415
line635: nop
line636: lw $30, 10461($17)
line637: ori $17, $26, 11629
line638: lui $3, 49349
line639: sub $16, $16, $29
line640: lui $8, 12479
line641: ori $24, $30, 53643
line642: add $4, $8, $2
line643: sub $10, $4, $10
line644: jal line552
line645: nop
line646: sub $18, $27, $29
line647: ori $21, $27, 25619
line648: lui $12, 15137
line649: lui $4, 4353
line650: jal line601
line651: nop
line652: add $11, $20, $14
line653: sub $27, $29, $27
line654: add $20, $27, $23
line655: add $3, $20, $3
line656: lw $9, 5080($18)
line657: lui $5, 53639
line658: ori $2, $3, 43673
line659: ori $21, $27, 16195
line660: lui $4, 30074
line661: add $13, $4, $21
line662: sw $12, 8136($20)
line663: lw $10, 9775($28)
line664: jal line127
line665: nop
line666: lui $6, 59944
line667: ori $25, $27, 4890
line668: ori $14, $6, 21102
line669: sw $25, 3524($27)
line670: ori $27, $0, 2
line671: lw $3, 5902($27)
line672: lui $2, 40845
line673: sw $21, 11218($27)
line674: lui $1, 53775
line675: lw $21, 2480($18)
line676: sub $30, $27, $26
line677: sub $3, $4, $1
line678: lui $12, 61546
line679: lw $14, 10878($30)
line680: lui $5, 2341
line681: add $19, $27, $30
line682: sub $7, $5, $28
line683: lw $20, 1505($21)
line684: lui $3, 23088
line685: sub $3, $7, $6
line686: sub $19, $19, $28
line687: sub $6, $11, $19
line688: sw $1, 217($19)
line689: sub $1, $19, $6
line690: sw $19, 12267($22)
line691: sub $22, $29, $27
line692: sw $22, 7627($22)
line693: sw $22, 11483($22)
line694: sw $1, 1087($22)
line695: lui $5, 37036
line696: lw $4, 6327($22)
line697: beq $31, $31, line699
line698: nop
line699: sw $22, 1199($22)
line700: sub $14, $4, $13
line701: ori $8, $4, 54281
line702: sub $27, $27, $30
line703: add $21, $27, $31
line704: add $6, $27, $21
line705: lw $30, 8396($27)
line706: add $19, $30, $29
line707: sub $27, $30, $27
line708: sw $30, 11906($19)
line709: add $11, $30, $27
line710: lui $12, 13631
line711: add $17, $23, $19
line712: jal line461
line713: nop
line714: sw $17, 8909($30)
line715: sub $12, $23, $17
line716: add $15, $8, $17
line717: ori $13, $12, 29170
line718: sub $11, $13, $15
line719: beq $31, $31, line371
line720: nop
line721: sub $25, $19, $30
line722: add $11, $25, $13
line723: lui $1, 23969
line724: jal line469
line725: nop
line726: lui $2, 61075
line727: sub $3, $1, $2
line728: lui $7, 12538
line729: ori $28, $0, 0
line730: sw $7, 4858($16)
line731: add $15, $3, $28
line732: sub $4, $15, $28
line733: sub $5, $15, $28
line734: sub $7, $4, $5
line735: sub $18, $30, $27
line736: lui $14, 30088
line737: lw $13, 116($18)
line738: ori $12, $31, 53333
line739: sub $23, $27, $28
line740: lui $13, 59024
line741: sw $23, 8861($25)
line742: lui $6, 28917
line743: ori $23, $28, 21860
line744: lui $10, 42437
line745: beq $26, $28, line758
line746: nop
line747: ori $22, $30, 14963
line748: ori $28, $30, 3
line749: lui $15, 22293
line750: sw $19, 10317($28)
line751: jr $31
line752: nop
line753: lui $1, 50013
line754: sub $21, $30, $27
line755: add $16, $30, $20
line756: jr $31
line757: nop
line758: sub $7, $10, $6
line759: add $21, $23, $30
line760: sw $5, 11460($18)
line761: lui $10, 30293
line762: sub $25, $18, $28
line763: lui $9, 6160
line764: lui $5, 44232
line765: sub $19, $27, $25
line766: lw $23, 9100($18)
line767: sw $7, 11641($23)
line768: add $5, $5, $19
line769: ori $17, $30, 36284
line770: add $15, $10, $23
line771: ori $25, $30, 23091
line772: lui $14, 44367
line773: jal line782
line774: nop
line775: sw $15, 3313($29)
line776: lui $3, 55001
line777: add $9, $14, $6
line778: lui $15, 1413
line779: ori $2, $15, 32623
line780: beq $4, $4, line1155
line781: nop
line782: lui $10, 26220
line783: ori $2, $10, 10719
line784: sub $14, $16, $10
line785: sub $14, $13, $14
line786: lui $6, 23718
line787: sw $14, 370($16)
line788: lui $5, 39555
line789: add $4, $5, $12
line790: lui $10, 34752
line791: lui $3, 47802
line792: jal line459
line793: nop
line794: lui $3, 61547
line795: sub $27, $27, $28
line796: add $27, $27, $28
line797: sw $15, 6701($27)
line798: sw $27, 5849($27)
line799: sub $23, $27, $19
line800: jal line807
line801: nop
line802: sw $10, 10412($22)
line803: sub $11, $8, $15
line804: add $16, $18, $26
line805: beq $4, $4, line881
line806: nop
line807: lw $11, 1844($23)
line808: sub $15, $23, $11
line809: lui $1, 20412
line810: ori $13, $11, 51587
line811: lui $12, 15481
line812: lui $13, 60630
line813: ori $14, $13, 28253
line814: add $30, $28, $30
line815: add $20, $21, $27
line816: sw $14, 5485($30)
line817: ori $30, $0, 3
line818: lui $14, 33148
line819: add $7, $30, $14
line820: lui $9, 35787
line821: sw $9, 4112($26)
line822: add $7, $26, $9
line823: jal line753
line824: nop
line825: lui $10, 43976
line826: sub $18, $30, $23
line827: sw $1, 4($26)
line828: add $19, $30, $16
line829: add $17, $30, $27
line830: sw $12, 5830($17)
line831: ori $2, $18, 27404
line832: sub $1, $11, $2
line833: sub $22, $30, $27
line834: sub $3, $22, $6
line835: sw $19, 140($22)
line836: sub $16, $19, $30
line837: sub $27, $27, $30
line838: ori $15, $19, 49501
line839: sw $27, 7336($27)
line840: sub $9, $15, $16
line841: sw $9, 2768($26)
line842: add $17, $16, $27
line843: lui $1, 14195
line844: lw $10, 4752($26)
line845: lw $15, 10976($26)
line846: sub $11, $26, $17
line847: lui $14, 16201
line848: lw $16, 1505($30)
line849: lw $26, 5852($28)
line850: jal line459
line851: nop
line852: ori $21, $26, 52590
line853: sub $12, $26, $5
line854: sw $12, 1309($26)
line855: ori $24, $26, 65439
line856: add $15, $12, $24
line857: add $8, $12, $24
line858: sub $1, $24, $15
line859: add $24, $17, $26
line860: lui $15, 8518
line861: sw $14, 4561($18)
line862: lui $5, 11947
line863: ori $11, $15, 17405
line864: ori $1, $18, 60333
line865: sub $10, $5, $28
line866: lui $8, 18186
line867: sub $11, $6, $15
line868: sub $16, $26, $27
line869: ori $9, $11, 56442
line870: lw $18, 10005($16)
line871: lui $12, 7814
line872: sub $26, $26, $27
line873: ori $13, $26, 54240
line874: jal line570
line875: nop
line876: ori $4, $12, 55164
line877: lw $8, 10941($26)
line878: lui $10, 54240
line879: beq $26, $29, line801
line880: nop
line881: sw $16, 428($27)
line882: lw $30, 11909($16)
line883: lui $3, 64536
line884: add $21, $26, $24
line885: sub $18, $26, $16
line886: lui $7, 18888
line887: jal line905
line888: nop
line889: lw $14, 5415($27)
line890: lui $3, 53448
line891: add $23, $27, $31
line892: add $14, $20, $14
line893: ori $6, $14, 60770
line894: add $8, $23, $14
line895: add $18, $28, $29
line896: lui $1, 19718
line897: sw $8, 5501($18)
line898: lw $8, 1841($18)
line899: sw $1, 12257($18)
line900: add $22, $30, $27
line901: sub $3, $22, $8
line902: lui $8, 9699
line903: beq $3, $3, line909
line904: nop
line905: ori $7, $18, 64285
line906: lw $27, 10536($23)
line907: beq $26, $29, line175
line908: nop
line909: sub $13, $8, $22
line910: sub $21, $29, $30
line911: sw $13, 216($21)
line912: lui $10, 12774
line913: ori $9, $13, 63298
line914: lui $14, 23629
line915: sw $9, 705($29)
line916: lui $4, 28197
line917: ori $24, $27, 56714
line918: ori $27, $0, 3
line919: lui $7, 2593
line920: ori $27, $27, 1
line921: ori $17, $27, 35450
line922: add $21, $27, $29
line923: ori $15, $21, 22649
line924: add $24, $27, $26
line925: lui $8, 23863
line926: add $8, $27, $17
line927: sub $4, $8, $24
line928: ori $6, $8, 14060
line929: sub $17, $21, $27
line930: lw $24, 3965($17)
line931: lw $30, 5852($24)
line932: ori $25, $27, 51607
line933: lui $1, 16938
line934: add $11, $1, $30
line935: sub $12, $25, $5
line936: sub $7, $8, $1
line937: sub $12, $11, $7
line938: lui $14, 12176
line939: beq $26, $27, line483
line940: nop
line941: add $4, $7, $14
line942: add $24, $30, $27
line943: add $27, $30, $28
line944: sw $15, 8145($27)
line945: sub $14, $7, $27
line946: lw $14, 11993($27)
line947: lui $15, 2548
line948: sub $7, $14, $15
line949: sw $7, 6392($22)
line950: sub $2, $14, $16
line951: ori $15, $2, 23892
line952: add $3, $15, $2
line953: sw $15, 7761($26)
line954: ori $14, $3, 2871
line955: add $3, $3, $15
line956: ori $25, $0, 8294
line957: add $13, $14, $3
line958: jal line177
line959: nop
line960: lw $12, 5504($28)
line961: lui $7, 21708
line962: add $22, $27, $24
line963: sw $7, 11259($22)
line964: ori $25, $30, 37314
line965: sub $23, $27, $29
line966: ori $28, $27, 2
line967: lw $30, 10533($28)
line968: lui $5, 14385
line969: lui $9, 6135
line970: sw $30, 6199($30)
line971: lui $8, 39020
line972: ori $4, $9, 5734
line973: ori $23, $0, 3639
line974: sub $12, $25, $3
line975: lw $17, 5225($23)
line976: sw $12, 3405($17)
line977: lui $15, 37112
line978: lw $3, 1765($17)
line979: lui $10, 38459
line980: sub $25, $28, $30
line981: ori $9, $25, 3137
line982: lw $29, 2458($25)
line983: ori $20, $17, 24028
line984: sub $1, $20, $9
line985: lui $9, 27136
line986: add $27, $28, $29
line987: lw $8, 11993($27)
line988: lw $26, 5849($27)
line989: lui $11, 24805
line990: sw $26, 11629($26)
line991: ori $24, $26, 38911
line992: sw $24, 11369($26)
line993: sub $12, $11, $25
line994: lui $14, 49629
line995: add $24, $27, $30
line996: lw $20, 8860($24)
line997: add $18, $27, $26
line998: lw $7, 1301($20)
line999: sub $1, $20, $5
line1000: lui $3, 60542
line1001: ori $3, $16, 41025
line1002: lui $8, 1130
line1003: sw $5, 8261($16)
line1004: add $13, $3, $13
line1005: sw $13, 2210($25)
line1006: lui $12, 62945
line1007: lw $18, 3968($29)
line1008: add $18, $18, $22
line1009: lw $29, 5843($18)
line1010: lui $10, 11492
line1011: ori $5, $18, 24596
line1012: lui $7, 55673
line1013: sub $2, $15, $8
line1014: lw $11, 5833($28)
line1015: lw $1, 12173($17)
line1016: ori $21, $0, 60789
line1017: add $19, $29, $24
line1018: sub $7, $19, $21
line1019: lui $11, 9613
line1020: ori $3, $4, 8549
line1021: sw $7, 746($25)
line1022: jal line570
line1023: nop
line1024: ori $5, $11, 38946
line1025: add $16, $30, $26
line1026: lui $9, 20810
line1027: lw $20, 6369($23)
line1028: lw $12, 3164($20)
line1029: lui $10, 55212
line1030: lw $9, 4724($24)
line1031: ori $26, $0, 1
line1032: ori $18, $16, 21222
line1033: jal line1042
line1034: nop
line1035: add $23, $26, $29
line1036: ori $27, $26, 0
line1037: ori $19, $0, 4701
line1038: sw $19, 11644($23)
line1039: sub $13, $27, $14
line1040: beq $18, $18, line1046
line1041: nop
line1042: add $22, $30, $20
line1043: lui $11, 64121
line1044: beq $26, $30, line469
line1045: nop
line1046: sw $19, 11167($30)
line1047: sub $3, $19, $13
line1048: lui $6, 3345
line1049: sw $11, 3368($23)
line1050: sw $6, 4977($29)
line1051: beq $26, $27, line1058
line1052: nop
line1053: jr $31
line1054: nop
line1055: lui $15, 65096
line1056: jr $31
line1057: nop
line1058: lw $6, 8260($23)
line1059: add $15, $6, $3
line1060: lui $14, 25938
line1061: lui $15, 40893
line1062: ori $12, $15, 58396
line1063: lui $12, 24732
line1064: add $8, $15, $12
line1065: sub $2, $12, $8
line1066: sw $27, 3871($27)
line1067: sw $2, 11908($23)
line1068: add $27, $30, $27
line1069: sw $8, 11498($27)
line1070: add $5, $27, $7
line1071: sub $9, $2, $5
line1072: lw $10, 8262($27)
line1073: lui $3, 64904
line1074: sub $20, $28, $27
line1075: sw $3, 12279($20)
line1076: jal line1095
line1077: nop
line1078: sw $9, 167($20)
line1079: add $30, $26, $27
line1080: lui $5, 62107
line1081: lui $8, 63072
line1082: sub $15, $2, $8
line1083: add $24, $22, $20
line1084: sw $30, 4569($24)
line1085: sw $15, 4541($29)
line1086: ori $24, $30, 62450
line1087: ori $9, $15, 63739
line1088: lui $2, 11712
line1089: lui $7, 10995
line1090: sw $2, 2661($17)
line1091: ori $1, $7, 65275
line1092: sub $15, $7, $1
line1093: beq $15, $15, line1097
line1094: nop
line1095: beq $26, $30, line1041
line1096: nop
line1097: sub $6, $7, $1
line1098: lw $9, 9872($23)
line1099: ori $20, $24, 3436
line1100: add $5, $15, $9
line1101: ori $4, $20, 9691
line1102: sub $13, $20, $5
line1103: ori $2, $13, 8290
line1104: add $2, $2, $5
line1105: ori $3, $21, 61589
line1106: sw $2, 1248($23)
line1107: add $22, $30, $27
line1108: add $6, $3, $28
line1109: ori $23, $26, 84
line1110: beq $31, $31, line1120
line1111: nop
line1112: ori $16, $17, 31194
line1113: lw $15, 3312($25)
line1114: add $13, $15, $16
line1115: sw $13, 4083($17)
line1116: jr $31
line1117: nop
line1118: beq $27, $27, line1137
line1119: nop
line1120: jal line743
line1121: nop
line1122: lui $3, 38229
line1123: lui $15, 22288
line1124: ori $6, $15, 49851
line1125: ori $11, $15, 42432
line1126: lw $4, 213($29)
line1127: sw $11, 7534($25)
line1128: ori $1, $1, 18533
line1129: ori $3, $4, 50629
line1130: lui $9, 41362
line1131: lui $6, 20146
line1132: add $5, $9, $3
line1133: lw $27, 5958($25)
line1134: lw $30, 10335($27)
line1135: beq $26, $27, line1118
line1136: nop
line1137: sub $4, $30, $27
line1138: add $1, $12, $27
line1139: sub $13, $4, $26
line1140: lui $10, 60357
line1141: sw $10, 7583($26)
line1142: sub $23, $28, $27
line1143: add $19, $30, $27
line1144: beq $26, $27, line444
line1145: nop
line1146: sw $23, 8519($19)
line1147: ori $27, $27, 2
line1148: lw $7, 1609($27)
line1149: add $3, $22, $27
line1150: jal line1055
line1151: nop
line1152: add $6, $1, $6
line1153: beq $31, $31, line775
line1154: nop
line1155: lui $11, 8307
line1156: add $28, $30, $29
line1157: lui $3, 34897
line1158: lui $12, 17399
line1159: add $5, $1, $28
line1160: sub $27, $29, $26
line1161: ori $2, $12, 64012
line1162: lw $12, 5415($19)
line1163: lw $9, 370($27)
line1164: ori $18, $26, 8790
line1165: lui $3, 62671
line1166: beq $31, $31, line1184
line1167: nop
line1168: ori $9, $21, 12404
line1169: beq $11, $11, line1600
line1170: nop
line1171: add $22, $29, $26
line1172: add $19, $29, $22
line1173: beq $19, $19, line1212
line1174: nop
line1175: lui $12, 52347
line1176: sub $24, $28, $26
line1177: lui $14, 29418
line1178: sw $14, 1034($24)
line1179: lw $22, 4406($24)
line1180: ori $29, $27, 1
line1181: lui $12, 52224
line1182: beq $29, $29, line1187
line1183: nop
line1184: lui $13, 35699
line1185: beq $31, $31, line1175
line1186: nop
line1187: ori $28, $0, 2
line1188: lui $1, 46742
line1189: lw $7, 3138($28)
line1190: add $8, $7, $1
line1191: lw $21, 4406($28)
line1192: ori $21, $29, 35907
line1193: lui $11, 52457
line1194: sub $26, $29, $26
line1195: add $5, $11, $21
line1196: sub $21, $26, $28
line1197: sw $21, 1180($16)
line1198: lw $29, 5850($24)
line1199: ori $24, $29, 26192
line1200: lui $10, 18378
line1201: add $27, $26, $30
line1202: sw $24, 9162($27)
line1203: ori $16, $26, 21368
line1204: lw $23, 11966($27)
line1205: ori $7, $16, 34283
line1206: ori $25, $26, 13441
line1207: lui $7, 50400
line1208: lui $1, 4902
line1209: lui $9, 62359
line1210: beq $26, $27, line1171
line1211: nop
line1212: ori $3, $17, 30337
line1213: sw $22, 8378($26)
line1214: lw $21, 11476($19)
line1215: sw $21, 8312($19)
line1216: lw $27, 5040($19)
line1217: add $25, $27, $29
line1218: lui $13, 21928
line1219: lui $15, 36252
line1220: ori $8, $3, 46915
line1221: sw $13, 11433($29)
line1222: ori $21, $27, 7427
line1223: add $12, $8, $21
line1224: lui $7, 5577
line1225: ori $14, $7, 36452
line1226: ori $4, $12, 37569
line1227: ori $10, $28, 19802
line1228: ori $21, $29, 4396
line1229: lui $9, 57284
line1230: sub $11, $8, $11
line1231: lui $3, 54867
line1232: lui $12, 8204
line1233: add $30, $28, $30
line1234: sw $25, 10326($30)
line1235: sw $12, 10278($30)
line1236: lw $1, 1302($30)
line1237: add $12, $12, $1
line1238: ori $3, $12, 8883
line1239: ori $30, $27, 1
line1240: ori $14, $28, 4819
line1241: ori $3, $14, 59339
line1242: lw $16, 5699($30)
line1243: add $15, $3, $14
line1244: lw $11, 2212($16)
line1245: sw $15, 2352($16)
line1246: sub $27, $30, $27
line1247: lw $15, 9392($27)
line1248: lui $9, 18442
line1249: add $27, $27, $29
line1250: sub $11, $15, $9
line1251: sub $12, $20, $27
line1252: add $1, $27, $12
line1253: sub $17, $19, $27
line1254: sw $13, 8371($17)
line1255: add $23, $27, $30
line1256: sw $1, 9027($17)
line1257: sub $3, $23, $17
line1258: add $13, $23, $17
line1259: lw $12, 9112($23)
line1260: jal line1112
line1261: nop
line1262: lui $7, 58599
line1263: sw $13, 665($29)
line1264: lw $29, 5045($27)
line1265: sw $7, 8033($27)
line1266: lw $13, 5993($27)
line1267: add $26, $26, $29
line1268: lui $12, 44033
line1269: sub $12, $13, $27
line1270: ori $20, $0, 381
line1271: add $8, $12, $22
line1272: lw $19, 1127($20)
line1273: sw $19, 6277($26)
line1274: add $12, $19, $20
line1275: lui $1, 56223
line1276: add $13, $19, $12
line1277: sw $1, 9156($25)
line1278: sub $1, $1, $13
line1279: lw $13, 4421($26)
line1280: add $18, $28, $27
line1281: sw $17, 943($18)
line1282: lw $5, 1087($29)
line1283: sub $27, $27, $28
line1284: lw $1, 2719($20)
line1285: jal line754
line1286: nop
line1287: lw $8, 10855($30)
line1288: ori $3, $1, 62483
line1289: add $17, $27, $18
line1290: sw $3, 4022($17)
line1291: lw $18, 11214($17)
line1292: sub $25, $18, $27
line1293: ori $25, $27, 28484
line1294: lw $3, 467($20)
line1295: lui $3, 36279
line1296: sw $25, 1602($28)
line1297: ori $5, $25, 30300
line1298: sub $17, $26, $29
line1299: sw $17, 8938($17)
line1300: lui $15, 59663
line1301: add $7, $5, $15
line1302: lui $1, 23333
line1303: lui $5, 4054
line1304: sub $29, $29, $27
line1305: sw $1, 10192($29)
line1306: jal line178
line1307: nop
line1308: add $5, $5, $29
line1309: add $21, $17, $30
line1310: lw $22, 8380($29)
line1311: sub $6, $5, $2
line1312: lw $7, 10275($22)
line1313: ori $19, $0, 24119
line1314: ori $11, $7, 55381
line1315: add $15, $18, $19
line1316: add $30, $27, $28
line1317: lui $9, 50655
line1318: sub $5, $9, $6
line1319: beq $26, $30, line1340
line1320: nop
line1321: ori $2, $16, 50982
line1322: sub $3, $10, $2
line1323: ori $12, $2, 42448
line1324: lui $12, 41326
line1325: ori $29, $27, 1
line1326: lui $8, 11395
line1327: lui $5, 30524
line1328: jr $31
line1329: nop
line1330: ori $21, $24, 61187
line1331: lui $5, 11079
line1332: beq $31, $31, line1388
line1333: nop
line1334: lw $20, 11266($16)
line1335: ori $24, $26, 4378
line1336: sub $25, $24, $27
line1337: sw $25, 7195($20)
line1338: beq $20, $20, line1365
line1339: nop
line1340: add $20, $22, $27
line1341: sub $3, $9, $5
line1342: sub $11, $20, $3
line1343: lw $13, 5482($20)
line1344: ori $24, $0, 24669
line1345: ori $2, $13, 15534
line1346: add $3, $2, $13
line1347: lui $10, 7477
line1348: add $6, $2, $19
line1349: sw $10, 5195($27)
line1350: sub $17, $24, $29
line1351: lw $10, 1840($23)
line1352: jal line386
line1353: nop
line1354: ori $27, $0, 1
line1355: add $26, $29, $27
line1356: sw $18, 10207($26)
line1357: sw $10, 4475($27)
line1358: sub $2, $27, $17
line1359: lui $14, 18106
line1360: ori $5, $2, 25755
line1361: sub $1, $14, $31
line1362: ori $7, $7, 37758
line1363: beq $26, $27, line1334
line1364: nop
line1365: ori $4, $10, 57690
line1366: add $2, $9, $24
line1367: add $9, $2, $10
line1368: add $12, $4, $6
line1369: lui $11, 53186
line1370: lui $12, 42203
line1371: lui $13, 32111
line1372: jal line1384
line1373: nop
line1374: lw $27, 7333($25)
line1375: lw $27, 3869($25)
line1376: lw $5, 559($27)
line1377: sw $27, 9339($27)
line1378: ori $17, $29, 22441
line1379: ori $28, $26, 0
line1380: lui $15, 18093
line1381: lui $14, 62596
line1382: beq $14, $14, line1392
line1383: nop
line1384: ori $23, $26, 1670
line1385: add $2, $12, $13
line1386: beq $26, $27, line1330
line1387: nop
line1388: sub $25, $30, $29
line1389: add $6, $25, $4
line1390: beq $26, $27, line570
line1391: nop
line1392: sub $7, $28, $4
line1393: sub $22, $27, $28
line1394: ori $12, $4, 61542
line1395: sw $22, 4595($28)
line1396: sw $25, 3753($23)
line1397: sw $12, 3145($25)
line1398: ori $6, $12, 38658
line1399: ori $16, $17, 64731
line1400: add $10, $6, $16
line1401: jal line1321
line1402: nop
line1403: lui $12, 51247
line1404: sub $29, $29, $27
line1405: add $23, $29, $26
line1406: ori $14, $24, 61398
line1407: sub $8, $29, $14
line1408: sw $25, 11675($23)
line1409: sub $11, $8, $21
line1410: ori $28, $29, 0
line1411: lw $16, 5424($22)
line1412: sub $25, $23, $28
line1413: ori $21, $0, 46782
line1414: lui $3, 44451
line1415: jal line1426
line1416: nop
line1417: sub $21, $25, $28
line1418: sub $5, $2, $21
line1419: lui $4, 32018
line1420: lui $10, 21733
line1421: lw $27, 11623($18)
line1422: sw $4, 11645($27)
line1423: sub $12, $10, $4
line1424: beq $12, $12, line1429
line1425: nop
line1426: sub $7, $3, $12
line1427: beq $26, $27, line1323
line1428: nop
line1429: lui $6, 1174
line1430: lw $15, 1311($29)
line1431: lui $2, 43283
line1432: sw $15, 6615($18)
line1433: add $21, $27, $16
line1434: ori $11, $15, 3242
line1435: lui $15, 3083
line1436: lw $7, 162($21)
line1437: lw $23, 3965($30)
line1438: lui $11, 31759
line1439: lw $10, 1844($23)
line1440: sw $23, 12168($23)
line1441: add $14, $24, $4
line1442: add $24, $23, $28
line1443: ori $7, $10, 10102
line1444: add $13, $14, $24
line1445: lui $2, 21092
line1446: sub $10, $13, $7
line1447: add $2, $13, $10
line1448: sw $10, 3720($28)
line1449: ori $28, $0, 2
line1450: add $6, $22, $10
line1451: ori $2, $28, 13568
line1452: add $5, $2, $28
line1453: sub $27, $28, $29
line1454: ori $21, $0, 9608
line1455: add $5, $15, $27
line1456: lw $7, 371($27)
line1457: lui $11, 54823
line1458: sw $9, 5669($30)
line1459: add $11, $11, $5
line1460: ori $20, $0, 21044
line1461: lw $29, 7287($18)
line1462: sub $28, $28, $29
line1463: lui $3, 11896
line1464: sub $21, $30, $28
line1465: lw $23, 8204($24)
line1466: lui $13, 57372
line1467: lw $26, 2460($24)
line1468: sub $12, $13, $26
line1469: lui $2, 19161
line1470: add $6, $2, $20
line1471: lw $23, 5699($27)
line1472: lw $4, 220($23)
line1473: sw $23, 1390($28)
line1474: lw $7, 12176($23)
line1475: lui $2, 37636
line1476: lui $15, 1915
line1477: add $28, $26, $29
line1478: ori $10, $20, 61330
line1479: lui $3, 23705
line1480: sub $20, $28, $26
line1481: ori $10, $3, 55192
line1482: ori $19, $28, 21659
line1483: add $10, $26, $10
line1484: lw $26, 2460($28)
line1485: lw $30, 4572($26)
line1486: lui $1, 26841
line1487: sw $28, 3513($30)
line1488: lui $2, 54681
line1489: add $12, $3, $2
line1490: lw $30, 10335($27)
line1491: sub $13, $2, $30
line1492: lw $20, 8940($24)
line1493: sw $20, 2037($16)
line1494: lui $1, 28117
line1495: sw $20, 4008($23)
line1496: ori $13, $20, 42997
line1497: sub $9, $3, $1
line1498: ori $1, $25, 59618
line1499: add $14, $13, $9
line1500: add $23, $30, $27
line1501: sw $14, 12099($23)
line1502: sw $5, 9139($23)
line1503: ori $27, $30, 2
line1504: sw $16, 1819($23)
line1505: sw $23, 10994($27)
line1506: lui $8, 22020
line1507: beq $26, $28, line1525
line1508: nop
line1509: sw $29, 6553($29)
line1510: lw $18, 11484($20)
line1511: jr $31
line1512: nop
line1513: add $13, $27, $2
line1514: lui $4, 16912
line1515: beq $27, $27, line1696
line1516: nop
line1517: lui $6, 23895
line1518: sub $16, $30, $27
line1519: lw $18, 8296($16)
line1520: add $20, $27, $17
line1521: lui $5, 43949
line1522: lui $7, 60756
line1523: jr $31
line1524: nop
line1525: add $7, $8, $27
line1526: add $10, $7, $27
line1527: ori $15, $10, 39967
line1528: lui $13, 11363
line1529: sub $28, $27, $30
line1530: sub $23, $28, $27
line1531: add $23, $27, $31
line1532: ori $22, $28, 38657
line1533: ori $1, $22, 21306
line1534: lui $6, 5999
line1535: sw $1, 2360($29)
line1536: lui $12, 64441
line1537: add $28, $27, $26
line1538: add $1, $28, $6
line1539: add $10, $5, $1
line1540: jal line1116
line1541: nop
line1542: lui $13, 34025
line1543: lw $13, 4110($20)
line1544: lui $4, 7969
line1545: lui $10, 22327
line1546: ori $25, $22, 25271
line1547: add $8, $1, $10
line1548: lui $15, 50569
line1549: sw $8, 7698($27)
line1550: add $28, $29, $28
line1551: lui $13, 16301
line1552: sub $12, $15, $16
line1553: lw $27, 5958($28)
line1554: add $29, $28, $27
line1555: add $8, $12, $29
line1556: sub $2, $27, $8
line1557: lw $19, 6277($29)
line1558: sub $21, $17, $29
line1559: sub $1, $21, $19
line1560: beq $26, $30, line1577
line1561: nop
line1562: nop
line1563: nop
line1564: beq $15, $15, line1991
line1565: nop
line1566: ori $24, $26, 47360
line1567: add $24, $23, $29
line1568: add $18, $28, $30
line1569: sw $21, 5727($24)
line1570: add $11, $24, $18
line1571: lui $9, 10019
line1572: ori $13, $11, 18276
line1573: beq $25, $25, line1827
line1574: nop
line1575: jr $31
line1576: nop
line1577: jal line1597
line1578: nop
line1579: lui $11, 16630
line1580: sw $16, 2945($29)
line1581: ori $23, $29, 12580
line1582: lui $12, 13939
line1583: lw $26, 6200($30)
line1584: add $21, $29, $23
line1585: ori $7, $26, 59312
line1586: sub $1, $12, $10
line1587: add $5, $7, $6
line1588: lui $8, 6981
line1589: ori $27, $0, 1
line1590: sw $2, 2347($27)
line1591: add $14, $10, $8
line1592: sub $27, $27, $26
line1593: sw $14, 2472($27)
line1594: sw $27, 2544($27)
line1595: beq $14, $14, line1653
line1596: nop
line1597: sw $19, 572($26)
line1598: beq $26, $30, line1168
line1599: nop
line1600: ori $13, $9, 16700
line1601: sw $9, 2722($28)
line1602: sub $9, $13, $9
line1603: sub $14, $13, $9
line1604: sw $14, 8757($29)
line1605: lui $1, 2085
line1606: lw $19, 8862($28)
line1607: sw $3, 5229($19)
line1608: lui $1, 22332
line1609: sub $22, $21, $29
line1610: sw $19, 9909($19)
line1611: lui $13, 35778
line1612: add $15, $28, $13
line1613: ori $14, $15, 10599
line1614: lui $10, 50011
line1615: sub $2, $26, $28
line1616: add $24, $28, $31
line1617: add $21, $29, $24
line1618: ori $14, $21, 20030
line1619: sub $12, $21, $1
line1620: lui $3, 46376
line1621: sub $9, $10, $14
line1622: sw $11, 7975($27)
line1623: sw $27, 1937($16)
line1624: lui $1, 38351
line1625: add $19, $29, $27
line1626: sub $6, $27, $14
line1627: ori $16, $0, 19989
line1628: lw $29, 11628($19)
line1629: beq $26, $30, line1651
line1630: nop
line1631: nop
line1632: lui $11, 25951
line1633: sub $6, $25, $13
line1634: add $18, $29, $27
line1635: sw $18, 2892($18)
line1636: sw $26, 4888($18)
line1637: ori $3, $18, 48332
line1638: ori $5, $3, 61819
line1639: ori $29, $0, 1
line1640: add $29, $29, $26
line1641: add $8, $29, $5
line1642: add $16, $27, $29
line1643: sw $29, 1642($29)
line1644: sub $23, $31, $23
line1645: ori $10, $6, 53454
line1646: lw $3, 5075($16)
line1647: sw $3, 3691($23)
line1648: sub $17, $29, $26
line1649: beq $10, $10, line1683
line1650: nop
line1651: beq $26, $30, line1043
line1652: nop
line1653: ori $15, $27, 17276
line1654: sw $27, 4972($27)
line1655: sw $14, 3356($27)
line1656: ori $25, $23, 39768
line1657: add $1, $27, $28
line1658: add $3, $25, $15
line1659: lui $10, 63499
line1660: jal line1517
line1661: nop
line1662: add $28, $26, $27
line1663: sub $27, $29, $26
line1664: sw $27, 11487($28)
line1665: sub $3, $23, $27
line1666: sub $29, $27, $28
line1667: sub $19, $27, $28
line1668: sw $29, 3423($29)
line1669: lw $6, 10975($19)
line1670: sub $9, $6, $29
line1671: add $14, $9, $6
line1672: ori $6, $9, 39836
line1673: add $27, $27, $29
line1674: lui $4, 25849
line1675: lui $5, 8336
line1676: add $24, $27, $24
line1677: ori $24, $24, 36976
line1678: lui $7, 27538
line1679: lui $8, 19034
line1680: ori $13, $8, 2851
line1681: beq $26, $28, line1632
line1682: nop
line1683: lui $1, 29242
line1684: lui $9, 65316
line1685: lui $3, 31871
line1686: sw $3, 4087($23)
line1687: lui $8, 9050
line1688: lui $13, 4224
line1689: lui $9, 24639
line1690: lui $10, 42485
line1691: lui $2, 63556
line1692: sub $27, $27, $29
line1693: sw $5, 8676($30)
line1694: beq $26, $27, line1513
line1695: nop
line1696: sw $13, 4467($17)
line1697: ori $28, $29, 2
line1698: add $20, $28, $31
line1699: sub $9, $4, $28
line1700: sw $28, 5702($28)
line1701: add $19, $19, $29
line1702: sw $20, 4021($19)
line1703: ori $24, $20, 48673
line1704: sub $3, $19, $9
line1705: lui $4, 47043
line1706: ori $5, $24, 26099
line1707: sub $13, $3, $4
line1708: ori $23, $0, 2510
line1709: beq $26, $27, line1733
line1710: nop
line1711: lui $4, 22429
line1712: ori $3, $19, 45806
line1713: sub $24, $31, $16
line1714: lui $1, 20552
line1715: sub $7, $3, $22
line1716: jr $31
line1717: nop
line1718: sw $9, 6689($25)
line1719: lui $4, 28316
line1720: sub $1, $15, $4
line1721: sub $27, $28, $27
line1722: lui $12, 55258
line1723: lui $12, 2042
line1724: ori $14, $22, 22030
line1725: add $16, $28, $27
line1726: ori $25, $16, 29980
line1727: lui $9, 12038
line1728: lui $13, 50401
line1729: lui $2, 52536
line1730: add $29, $27, $26
line1731: jr $31
line1732: nop
line1733: add $13, $13, $4
line1734: ori $13, $12, 4107
line1735: sw $31, 3338($23)
line1736: ori $18, $0, 49779
line1737: sub $1, $18, $11
line1738: ori $13, $18, 5337
line1739: sub $4, $1, $18
line1740: add $1, $13, $4
line1741: lw $28, 1642($29)
line1742: add $8, $14, $1
line1743: sw $28, 9607($16)
line1744: lui $5, 28585
line1745: add $8, $5, $3
line1746: lui $4, 36304
line1747: jal line1575
line1748: nop
line1749: add $6, $4, $24
line1750: sw $8, 11236($30)
line1751: ori $12, $4, 33592
line1752: add $5, $6, $12
line1753: add $11, $6, $14
line1754: sw $5, 226($29)
line1755: lui $10, 23214
line1756: ori $25, $0, 2359
line1757: add $9, $11, $13
line1758: add $15, $9, $25
line1759: jal line1718
line1760: nop
line1761: ori $5, $13, 55370
line1762: add $3, $1, $29
line1763: lui $11, 46626
line1764: lw $30, 1603($17)
line1765: ori $10, $11, 45693
line1766: ori $30, $30, 3
line1767: add $19, $17, $30
line1768: lui $3, 7758
line1769: add $13, $3, $19
line1770: lui $5, 25961
line1771: lw $20, 8863($26)
line1772: lw $26, 5045($20)
line1773: lui $2, 10283
line1774: lui $2, 44106
line1775: sw $2, 7809($16)
line1776: lui $14, 34135
line1777: add $24, $19, $20
line1778: sub $13, $9, $2
line1779: lui $1, 2090
line1780: ori $19, $0, 54509
line1781: add $9, $1, $19
line1782: sub $6, $19, $9
line1783: lui $10, 36883
line1784: sub $29, $29, $26
line1785: sub $18, $26, $29
line1786: lui $12, 59338
line1787: ori $7, $18, 20162
line1788: add $30, $28, $26
line1789: ori $25, $0, 37249
line1790: lw $13, 8375($27)
line1791: lui $4, 8504
line1792: add $24, $26, $30
line1793: sw $7, 6283($26)
line1794: lw $22, 8861($30)
line1795: add $21, $29, $28
line1796: add $23, $27, $22
line1797: ori $28, $26, 0
line1798: sw $23, 8464($23)
line1799: jal line1053
line1800: nop
line1801: jal line1824
line1802: nop
line1803: lui $15, 53810
line1804: sw $28, 1551($23)
line1805: lui $8, 5638
line1806: jr $31
line1807: nop
line1808: ori $8, $11, 14180
line1809: sw $6, 1121($30)
line1810: sw $8, 7089($28)
line1811: ori $4, $8, 52941
line1812: ori $1, $8, 30274
line1813: add $20, $29, $24
line1814: add $22, $29, $25
line1815: lw $20, 12091($20)
line1816: sub $15, $20, $22
line1817: ori $25, $22, 26294
line1818: ori $6, $15, 20841
line1819: sub $29, $30, $29
line1820: add $22, $25, $29
line1821: lui $4, 41946
line1822: jr $31
line1823: nop
line1824: ori $9, $4, 61575
line1825: beq $26, $27, line1566
line1826: nop
line1827: sw $11, 3575($17)
line1828: add $20, $24, $29
line1829: ori $25, $0, 50925
line1830: lw $28, 11482($20)
line1831: jal line1720
line1832: nop
line1833: sub $7, $25, $22
line1834: ori $3, $7, 31908
line1835: ori $19, $30, 12361
line1836: ori $7, $2, 3045
line1837: lui $8, 33526
line1838: lui $13, 50595
line1839: lui $4, 40402
line1840: add $16, $28, $30
line1841: sw $16, 6003($17)
line1842: lw $6, 1791($16)
line1843: sw $4, 4341($30)
line1844: sub $4, $6, $4
line1845: add $16, $16, $29
line1846: ori $12, $15, 58963
line1847: sw $16, 1153($16)
line1848: sw $28, 8473($16)
line1849: ori $30, $30, 3
line1850: ori $6, $16, 57106
line1851: sw $30, 4071($24)
line1852: lui $1, 9439
line1853: lw $29, 5957($30)
line1854: lw $22, 8203($29)
line1855: sw $22, 11295($29)
line1856: sub $9, $30, $22
line1857: lw $25, 10207($29)
line1858: add $23, $29, $30
line1859: ori $28, $30, 0
line1860: ori $29, $0, 1
line1861: sw $28, 4940($23)
line1862: lw $1, 2221($28)
line1863: lw $18, 11895($29)
line1864: beq $26, $27, line1879
line1865: nop
line1866: jr $31
line1867: nop
line1868: sub $17, $29, $27
line1869: lui $8, 1542
line1870: ori $22, $16, 63338
line1871: lui $1, 4860
line1872: add $16, $31, $28
line1873: sub $2, $16, $25
line1874: jr $31
line1875: nop
line1876: ori $13, $28, 29158
line1877: jr $31
line1878: nop
line1879: lui $1, 14666
line1880: sw $1, 2062($18)
line1881: add $21, $28, $29
line1882: lui $6, 61233
line1883: add $24, $28, $29
line1884: sw $6, 8132($24)
line1885: sub $14, $6, $21
line1886: lui $3, 52645
line1887: ori $14, $3, 17380
line1888: ori $6, $14, 19195
line1889: jal line1808
line1890: nop
line1891: add $29, $27, $29
line1892: lui $4, 45359
line1893: lw $26, 9609($30)
line1894: lw $29, 4570($26)
line1895: lui $1, 42474
line1896: sw $1, 7309($29)
line1897: sw $29, 4994($26)
line1898: sub $6, $26, $29
line1899: jal line1486
line1900: nop
line1901: sw $25, 3063($18)
line1902: lw $3, 11995($18)
line1903: jal line1507
line1904: nop
line1905: sub $9, $28, $18
line1906: sw $9, 9094($27)
line1907: lw $3, 9391($18)
line1908: lw $30, 5960($30)
line1909: jal line756
line1910: nop
line1911: lui $1, 7964
line1912: lw $28, 3515($30)
line1913: sub $20, $29, $30
line1914: sub $15, $28, $6
line1915: add $1, $15, $28
line1916: lui $1, 41448
line1917: lui $6, 21425
line1918: sw $1, 8823($23)
line1919: lw $12, 1329($16)
line1920: ori $24, $28, 39592
line1921: lui $4, 46982
line1922: jal line1803
line1923: nop
line1924: ori $10, $4, 61183
line1925: lui $15, 40945
line1926: ori $2, $10, 3789
line1927: ori $20, $28, 40983
line1928: add $24, $28, $17
line1929: lui $15, 8483
line1930: lw $26, 5045($28)
line1931: add $2, $15, $2
line1932: lui $2, 25309
line1933: sub $7, $2, $23
line1934: lw $6, 1035($26)
line1935: add $2, $2, $13
line1936: sub $13, $6, $7
line1937: add $2, $2, $19
line1938: lw $19, 4021($28)
line1939: sub $4, $2, $13
line1940: lui $7, 61296
line1941: sub $7, $4, $7
line1942: lw $18, 8939($18)
line1943: add $24, $18, $30
line1944: lui $2, 32322
line1945: ori $20, $0, 9431
line1946: ori $15, $2, 39380
line1947: ori $12, $14, 15499
line1948: sub $11, $31, $12
line1949: jal line469
line1950: nop
line1951: lw $19, 8518($18)
line1952: lw $1, 12174($19)
line1953: ori $26, $29, 2
line1954: lui $10, 34233
line1955: ori $26, $26, 0
line1956: add $17, $17, $30
line1957: lw $5, 4587($30)
line1958: lw $14, 4290($17)
line1959: add $18, $26, $17
line1960: add $22, $27, $26
line1961: sw $14, 8010($17)
line1962: ori $11, $26, 31720
line1963: ori $28, $30, 3
line1964: ori $4, $31, 23331
line1965: lw $8, 9113($28)
line1966: ori $21, $27, 18073
line1967: sub $12, $22, $21
line1968: sub $30, $26, $29
line1969: sw $12, 1388($30)
line1970: sw $12, 2011($22)
line1971: jal line1523
line1972: nop
line1973: lui $1, 30307
line1974: sw $19, 8600($30)
line1975: lui $10, 28208
line1976: lw $3, 3816($30)
line1977: lui $10, 12082
line1978: lui $7, 50209
line1979: sub $27, $27, $30
line1980: add $24, $22, $26
line1981: sw $24, 8286($27)
line1982: add $16, $27, $29
line1983: sub $10, $27, $24
line1984: lui $4, 43193
line1985: add $17, $26, $30
line1986: sw $10, 7247($23)
line1987: ori $1, $10, 2739
line1988: lw $9, 3161($17)
line1989: beq $26, $28, line1564
line1990: nop
line1991: sub $1, $10, $17
line1992: sw $9, 3367($22)
line1993: lui $13, 25803
line1994: sub $21, $31, $17
line1995: lui $10, 63925
line1996: ori $3, $21, 451
line1997: ori $6, $10, 134
line1998: ori $15, $15, 23621
line1999: lw $16, 8932($24)
line2000: lw $26, 4074($16)
line2001: lw $15, 3226($16)
line2002: lw $5, 3369($26)
line2003: jal line1876
line2004: nop
line2005: lui $15, 52796
line2006: sub $11, $24, $5
line2007: lui $10, 54301
line2008: add $16, $23, $21
line2009: add $19, $27, $30
line2010: sw $5, 7753($26)
line2011: jal line1728
line2012: nop
line2013: jal line1710
line2014: nop
line2015: lui $5, 15229
line2016: ori $1, $1, 3417
line2017: sw $1, 4958($24)
line2018: lui $13, 43502
line2019: sw $5, 11414($27)
line2020: ori $14, $1, 25378
line2021: lw $20, 2038($27)
line2022: jal line1802
line2023: nop
line2024: sub $7, $10, $14
line2025: add $26, $30, $27
line2026: lw $11, 7810($26)
line2027: lui $11, 33271
line2028: sw $11, 4862($26)
line2029: sw $11, 11754($26)
line2030: sub $19, $20, $26
line2031: ori $20, $26, 51300
line2032: sw $19, 1056($19)
line2033: sub $3, $20, $19
line2034: lui $5, 29589
line2035: lui $3, 62641
line2036: ori $18, $20, 7597
line2037: sub $15, $3, $5
line2038: ori $14, $18, 15667
line2039: sw $18, 12159($29)
line2040: add $27, $30, $27
line2041: sw $27, 10890($27)
line2042: ori $7, $14, 14896
line2043: lui $4, 25592
line2044: ori $15, $4, 23480
line2045: ori $6, $3, 23487
line2046: ori $1, $15, 46684
line2047: sub $14, $3, $15
line2048: add $6, $14, $18
line2049: lui $4, 51736
line2050: add $12, $14, $4
line2051: sw $6, 5524($30)
line2052: ori $20, $0, 58980
line2053: lui $12, 30102
line2054: ori $15, $20, 60891
line2055: lui $14, 57877
line2056: lw $10, 907($29)
line2057: ori $28, $0, 3
line2058: lw $27, 3513($28)
line2059: ori $29, $0, 1
line2060: add $2, $28, $27
line2061: lui $4, 14645
line2062: lw $22, 685($27)
line2063: ori $16, $29, 61794
line2064: ori $23, $0, 37459
line2065: lui $8, 35616
line2066: jal line1719
line2067: nop
line2068: ori $8, $23, 37723
line2069: ori $18, $28, 62673
line2070: add $14, $8, $16
line2071: lui $3, 49200
line2072: ori $16, $18, 25842
line2073: sub $12, $16, $14
line2074: add $10, $24, $6
line2075: sub $5, $25, $12
line2076: beq $26, $29, line2098
line2077: nop
line2078: sw $21, 11475($29)
line2079: ori $4, $31, 64893
line2080: ori $7, $5, 31120
line2081: lui $2, 19495
line2082: sw $2, 8384($22)
line2083: sw $2, 4337($17)
line2084: ori $7, $7, 42850
line2085: ori $12, $7, 56169
line2086: lui $3, 40509
line2087: lw $28, 9612($19)
line2088: sw $12, 1290($28)
line2089: lui $5, 58861
line2090: ori $17, $29, 4295
line2091: lui $10, 25786
line2092: sw $10, 1281($17)
line2093: lw $3, 3601($17)
line2094: sw $3, 17($17)
line2095: sw $15, 6865($17)
line2096: beq $5, $5, line2106
line2097: nop
line2098: add $4, $5, $11
line2099: sw $5, 324($30)
line2100: sw $29, 9753($28)
line2101: lui $1, 62494
line2102: sub $29, $28, $26
line2103: sw $1, 9911($29)
line2104: beq $31, $31, line571
line2105: nop
line2106: lui $2, 22789
line2107: add $20, $19, $29
line2108: jal line1322
line2109: nop
line2110: lui $14, 44841
line2111: lw $5, 8534($28)
line2112: add $30, $29, $27
line2113: add $30, $29, $27
line2114: add $22, $26, $20
line2115: lw $5, 167($30)
line2116: sw $4, 3997($22)
line2117: add $14, $5, $30
line2118: sw $24, 5010($28)
line2119: ori $11, $5, 20833
line2120: sw $11, 7216($27)
line2121: sub $19, $25, $28
line2122: ori $16, $0, 63374
line2123: sub $9, $11, $16
line2124: add $6, $6, $19
line2125: add $23, $30, $28
line2126: lw $7, 8821($23)
line2127: sw $6, 3663($29)
line2128: ori $22, $27, 30314
line2129: sub $5, $23, $7
line2130: ori $8, $14, 37515
line2131: lui $12, 43272
line2132: ori $11, $12, 8412
line2133: add $7, $8, $11
line2134: sub $11, $11, $12
line2135: lui $13, 27889
line2136: ori $4, $13, 37001
line2137: ori $24, $30, 55112
line2138: lui $12, 18348
line2139: sw $12, 4443($20)
line2140: sub $21, $28, $27
line2141: lui $4, 49834
line2142: ori $8, $4, 3574
line2143: lui $4, 25913
line2144: sw $3, 10943($29)
line2145: sw $4, 7841($17)
line2146: ori $15, $31, 31503
line2147: ori $25, $0, 22035
line2148: ori $19, $21, 12039
line2149: ori $9, $19, 7625
line2150: beq $26, $28, line2162
line2151: nop
line2152: lw $29, 10333($23)
line2153: sw $15, 12269($23)
line2154: add $7, $29, $4
line2155: sw $23, 11284($29)
line2156: sub $5, $29, $24
line2157: add $5, $29, $7
line2158: add $8, $7, $19
line2159: ori $3, $5, 35898
line2160: beq $3, $3, line2320
line2161: nop
line2162: sub $21, $25, $28
line2163: lui $12, 10094
line2164: lui $12, 57858
line2165: lui $12, 17489
line2166: ori $18, $21, 40013
line2167: add $28, $28, $30
line2168: add $24, $28, $19
line2169: add $10, $28, $24
line2170: lui $9, 60520
line2171: sub $8, $24, $10
line2172: add $8, $29, $13
line2173: lui $4, 17789
line2174: ori $24, $27, 15754
line2175: lw $22, 572($27)
line2176: sub $12, $27, $18
line2177: sub $14, $22, $27
line2178: lui $4, 844
line2179: add $8, $12, $24
line2180: jal line1816
line2181: nop
line2182: lw $24, 570($26)
line2183: sw $30, 11158($26)
line2184: ori $5, $8, 1014
line2185: sub $14, $26, $5
line2186: lui $7, 35557
line2187: add $26, $26, $29
line2188: ori $25, $26, 37988
line2189: sub $12, $7, $26
line2190: add $11, $24, $12
line2191: add $7, $11, $12
line2192: ori $5, $16, 40590
line2193: add $3, $5, $14
line2194: jal line466
line2195: nop
line2196: jal line2210
line2197: nop
line2198: sub $1, $3, $19
line2199: sub $10, $11, $15
line2200: lui $4, 4043
line2201: ori $18, $0, 52848
line2202: ori $27, $26, 1
line2203: lw $25, 9341($27)
line2204: ori $19, $25, 20905
line2205: add $3, $4, $25
line2206: add $7, $3, $19
line2207: sw $29, 4078($29)
line2208: beq $7, $7, line2214
line2209: nop
line2210: sub $6, $3, $5
line2211: lui $11, 19992
line2212: beq $31, $31, line1730
line2213: nop
line2214: ori $2, $7, 11841
line2215: lui $2, 11495
line2216: ori $20, $19, 23466
line2217: sub $7, $9, $2
line2218: ori $28, $27, 0
line2219: lw $15, 11909($28)
line2220: sw $28, 5825($28)
line2221: lui $5, 38680
line2222: sw $28, 10304($17)
line2223: add $13, $5, $28
line2224: sw $13, 11496($25)
line2225: lui $8, 4477
line2226: lui $10, 11783
line2227: sub $2, $29, $10
line2228: ori $2, $5, 14659
line2229: jal line753
line2230: nop
line2231: lui $11, 15741
line2232: jal line1817
line2233: nop
line2234: lui $1, 49780
line2235: ori $6, $1, 21477
line2236: ori $23, $28, 5916
line2237: ori $20, $27, 64957
line2238: lw $3, 11063($30)
line2239: sub $17, $18, $19
line2240: jal line384
line2241: nop
line2242: sub $7, $17, $20
line2243: sw $17, 289($23)
line2244: lui $4, 44954
line2245: sub $27, $28, $26
line2246: lui $3, 45041
line2247: add $1, $2, $1
line2248: ori $1, $3, 56708
line2249: ori $24, $27, 59491
line2250: add $7, $2, $1
line2251: ori $6, $24, 15166
line2252: ori $27, $28, 1
line2253: add $5, $7, $27
line2254: lui $2, 60834
line2255: add $12, $5, $2
line2256: add $6, $5, $12
line2257: sub $6, $6, $12
line2258: ori $15, $6, 2645
line2259: sw $15, 1501($23)
line2260: sub $13, $6, $10
line2261: add $14, $6, $15
line2262: ori $5, $15, 3121
line2263: add $7, $14, $5
line2264: add $7, $7, $5
line2265: sub $3, $3, $5
line2266: sub $11, $3, $7
line2267: ori $17, $31, 37909
line2268: ori $13, $17, 24922
line2269: lui $11, 35668
line2270: add $1, $17, $28
line2271: lui $10, 44512
line2272: sub $8, $1, $10
line2273: lw $13, 10943($30)
line2274: ori $2, $12, 32052
line2275: add $6, $12, $2
line2276: lw $27, 637($23)
line2277: add $10, $27, $5
line2278: sub $3, $10, $27
line2279: add $12, $10, $7
line2280: lui $12, 56849
line2281: sub $1, $12, $3
line2282: lui $8, 12663
line2283: sub $15, $1, $23
line2284: ori $14, $15, 5293
line2285: add $11, $29, $15
line2286: lui $3, 1604
line2287: lw $28, 5046($26)
line2288: add $30, $30, $28
line2289: ori $14, $3, 10629
line2290: lui $12, 56746
line2291: lui $4, 7240
line2292: ori $19, $22, 32314
line2293: lui $11, 63255
line2294: lw $18, 6206($30)
line2295: add $27, $29, $30
line2296: lw $16, 2947($27)
line2297: sub $26, $30, $27
line2298: lui $13, 16080
line2299: add $7, $17, $30
line2300: sub $3, $7, $26
line2301: ori $11, $13, 22823
line2302: lui $1, 38052
line2303: add $8, $11, $1
line2304: add $4, $8, $27
line2305: ori $7, $8, 47294
line2306: add $12, $4, $7
line2307: add $15, $8, $7
line2308: ori $4, $12, 49093
line2309: lui $14, 1802
line2310: lui $6, 61110
line2311: add $27, $30, $27
line2312: lui $13, 59084
line2313: sw $27, 11053($27)
line2314: lui $4, 20511
line2315: add $23, $30, $26
line2316: jal line1323
line2317: nop
line2318: beq $26, $28, line2151
line2319: nop
line2320: add $25, $27, $23
line2321: sub $2, $8, $25
line2322: sub $21, $25, $23
line2323: lui $8, 43956
line2324: lui $5, 60965
line2325: sw $8, 11953($21)
line2326: ori $8, $5, 31251
line2327: lui $15, 63115
line2328: sub $12, $5, $8
line2329: ori $2, $15, 61167
line2330: lui $12, 20377
line2331: sub $13, $7, $2
line2332: ori $23, $0, 20216
line2333: lui $3, 62115
line2334: ori $2, $3, 35505
line2335: sub $29, $27, $29
line2336: ori $21, $21, 38382
line2337: lw $11, 5501($29)
line2338: lw $11, 8127($26)
line2339: sw $30, 6561($29)
line2340: lui $2, 55354
line2341: add $3, $11, $2
line2342: sw $2, 3591($28)
line2343: sub $13, $11, $5
line2344: ori $13, $2, 52969
line2345: lui $1, 25670
line2346: lui $5, 3638
line2347: ori $4, $5, 50013
line2348: sub $30, $29, $27
line2349: sub $3, $26, $30
line2350: jal line383
line2351: nop
line2352: add $18, $30, $29
line2353: lw $6, 3140($30)
line2354: lw $11, 7697($18)
line2355: lui $14, 38361
line2356: ori $25, $30, 60004
line2357: lui $4, 11782
line2358: jal line385
line2359: nop
line2360: sub $20, $29, $30
line2361: ori $27, $0, 3
line2362: sw $20, 1449($27)
line2363: sub $8, $27, $8
line2364: ori $20, $0, 21678
line2365: add $18, $29, $20
line2366: jal line1868
line2367: nop
line2368: lui $3, 11768
line2369: add $10, $2, $16
line2370: lw $13, 5835($26)
line2371: lui $15, 9424
line2372: lw $25, 11967($26)
line2373: lui $3, 57201
line2374: ori $4, $25, 10556
line2375: lui $10, 22560
line2376: sw $4, 9524($30)
line2377: sw $10, 733($29)
line2378: add $5, $15, $3
line2379: lw $30, 7333($27)
line2380: lw $2, 440($30)
line2381: add $19, $25, $27
line2382: ori $22, $27, 19500
line2383: ori $4, $15, 10871
line2384: lui $1, 16043
line2385: sub $21, $31, $30
line2386: lui $8, 44381
line2387: add $15, $21, $5
line2388: sub $12, $7, $18
line2389: sub $8, $13, $15
line2390: lw $4, 10309($27)
line2391: lw $29, 4073($27)
line2392: lw $7, 8821($29)
line2393: ori $26, $30, 2
line2394: jal line2407
line2395: nop
line2396: nop
line2397: nop
line2398: nop
line2399: nop
line2400: sub $28, $28, $29
line2401: beq $1, $1, line3061
line2402: nop
line2403: ori $24, $25, 54950
line2404: sw $23, 8617($28)
line2405: beq $24, $24, line3007
line2406: nop
line2407: jal line174
line2408: nop
line2409: ori $22, $26, 45156
line2410: lui $2, 64288
line2411: add $4, $2, $22
line2412: sub $20, $29, $26
line2413: sub $9, $21, $20
line2414: add $3, $9, $14
line2415: ori $1, $20, 43176
line2416: sw $9, 3604($17)
line2417: lui $7, 40807
line2418: add $13, $7, $1
line2419: lw $26, 5044($30)
line2420: lw $12, 11643($26)
line2421: add $25, $20, $31
line2422: lw $19, 571($26)
line2423: lui $1, 52923
line2424: add $19, $25, $26
line2425: lui $8, 63260
line2426: lui $11, 28015
line2427: ori $4, $30, 18462
line2428: lw $4, 1289($27)
line2429: add $14, $4, $19
line2430: sub $27, $26, $28
line2431: lui $1, 14581
line2432: ori $4, $5, 32070
line2433: sw $27, 10160($27)
line2434: add $23, $26, $31
line2435: add $16, $26, $27
line2436: lw $23, 12095($16)
line2437: sub $10, $21, $23
line2438: add $30, $26, $27
line2439: ori $17, $0, 9843
line2440: lui $15, 41371
line2441: lui $11, 63783
line2442: sub $15, $14, $17
line2443: add $16, $23, $30
line2444: sw $1, 10895($16)
line2445: ori $10, $15, 16350
line2446: jal line747
line2447: nop
line2448: lw $21, 5423($16)
line2449: sw $10, 10557($21)
line2450: sw $10, 3953($21)
line2451: lw $2, 12133($21)
line2452: jal line745
line2453: nop
line2454: jal line2470
line2455: nop
line2456: sub $1, $6, $24
line2457: add $16, $29, $28
line2458: lui $15, 33225
line2459: add $19, $29, $30
line2460: sub $12, $19, $15
line2461: add $24, $16, $30
line2462: sw $24, 9269($24)
line2463: add $7, $24, $5
line2464: lw $21, 11961($24)
line2465: sw $24, 2297($24)
line2466: sub $28, $29, $30
line2467: add $6, $7, $5
line2468: beq $21, $21, line2533
line2469: nop
line2470: sw $21, 5953($21)
line2471: lw $29, 1601($21)
line2472: lui $8, 38610
line2473: add $26, $30, $27
line2474: sw $23, 7719($26)
line2475: lw $4, 2076($23)
line2476: lw $4, 7839($26)
line2477: sub $26, $30, $26
line2478: jal line2481
line2479: nop
line2480: beq $26, $26, line2483
line2481: nop
line2482: nop
line2483: add $23, $26, $23
line2484: add $27, $26, $28
line2485: jal line468
line2486: nop
line2487: lui $9, 3427
line2488: sub $4, $9, $27
line2489: lui $4, 32805
line2490: sub $16, $30, $26
line2491: lw $6, 8215($16)
line2492: lui $11, 39803
line2493: ori $10, $12, 62330
line2494: add $4, $11, $23
line2495: sw $10, 3964($26)
line2496: sw $11, 6813($27)
line2497: lui $14, 32892
line2498: add $9, $4, $14
line2499: lui $11, 57747
line2500: sw $11, 9395($16)
line2501: lw $23, 2896($26)
line2502: add $11, $23, $11
line2503: sub $1, $23, $11
line2504: sw $11, 6124($23)
line2505: ori $18, $31, 10619
line2506: sub $1, $14, $30
line2507: lw $19, 2893($21)
line2508: sw $1, 1293($28)
line2509: lw $20, 11164($19)
line2510: lui $2, 1706
line2511: ori $7, $24, 5755
line2512: sw $2, 931($20)
line2513: ori $12, $2, 56487
line2514: add $29, $26, $30
line2515: lui $14, 24600
line2516: add $9, $26, $14
line2517: ori $18, $29, 19685
line2518: lui $2, 3131
line2519: ori $29, $27, 0
line2520: lui $14, 12664
line2521: lw $15, 3573($29)
line2522: sub $3, $14, $6
line2523: add $9, $3, $14
line2524: sw $15, 5765($27)
line2525: add $17, $20, $29
line2526: sw $17, 7048($17)
line2527: lui $15, 2751
line2528: lui $6, 36887
line2529: sub $24, $18, $29
line2530: ori $14, $15, 43071
line2531: beq $31, $31, line2455
line2532: nop
line2533: ori $27, $0, 2
line2534: sw $6, 5358($28)
line2535: sw $6, 9018($27)
line2536: ori $6, $6, 13220
line2537: lui $5, 42016
line2538: sw $5, 6578($27)
line2539: lw $4, 6814($27)
line2540: ori $22, $0, 23066
line2541: sw $5, 7473($24)
line2542: add $13, $22, $5
line2543: ori $4, $4, 59998
line2544: ori $15, $4, 48675
line2545: ori $22, $27, 22766
line2546: add $19, $28, $22
line2547: sub $2, $15, $2
line2548: sub $2, $16, $2
line2549: ori $16, $26, 50214
line2550: ori $25, $0, 62976
line2551: ori $29, $28, 3
line2552: lui $4, 48471
line2553: lw $17, 8201($29)
line2554: beq $31, $31, line2573
line2555: nop
line2556: nop
line2557: jr $31
line2558: nop
line2559: lw $23, 9091($19)
line2560: lw $19, 9273($28)
line2561: sub $12, $5, $25
line2562: jr $31
line2563: nop
line2564: lui $9, 27599
line2565: jr $31
line2566: nop
line2567: ori $30, $0, 3
line2568: add $5, $4, $30
line2569: add $1, $30, $5
line2570: lui $5, 20780
line2571: beq $1, $1, line2820
line2572: nop
line2573: lw $22, 1389($17)
line2574: lui $10, 47068
line2575: sw $17, 1884($26)
line2576: sub $30, $28, $27
line2577: jal line2601
line2578: nop
line2579: nop
line2580: nop
line2581: nop
line2582: lui $1, 14977
line2583: ori $22, $27, 61676
line2584: add $2, $22, $1
line2585: lui $8, 31970
line2586: add $3, $22, $8
line2587: add $1, $30, $8
line2588: sw $3, 3724($28)
line2589: add $13, $8, $30
line2590: ori $13, $1, 31308
line2591: ori $13, $13, 36657
line2592: ori $29, $0, 1
line2593: ori $13, $19, 51679
line2594: sw $25, 10131($29)
line2595: add $26, $28, $30
line2596: lui $1, 55844
line2597: add $1, $13, $26
line2598: sub $2, $1, $20
line2599: beq $1, $1, line2650
line2600: nop
line2601: jr $19
line2602: nop
line2603: nop
line2604: lw $22, 3240($19)
line2605: add $3, $11, $22
line2606: lw $30, 2460($22)
line2607: add $9, $30, $9
line2608: add $24, $30, $24
line2609: sub $20, $22, $30
line2610: lui $14, 7066
line2611: lui $4, 20077
line2612: jr $31
line2613: nop
line2614: sw $24, 6625($23)
line2615: jr $31
line2616: nop
line2617: ori $27, $0, 3
line2618: lw $26, 10889($30)
line2619: beq $26, $26, line2627
line2620: nop
line2621: jal line130
line2622: nop
line2623: ori $24, $29, 50851
line2624: ori $30, $30, 3
line2625: beq $31, $31, line2617
line2626: nop
line2627: sw $26, 1865($27)
line2628: lw $6, 8154($26)
line2629: sw $26, 6669($27)
line2630: ori $2, $18, 17961
line2631: sub $1, $26, $2
line2632: jal line754
line2633: nop
line2634: ori $21, $30, 62157
line2635: jal line461
line2636: nop
line2637: sub $28, $30, $27
line2638: jal line2104
line2639: nop
line2640: add $1, $1, $11
line2641: lw $22, 1820($28)
line2642: ori $12, $1, 46007
line2643: lui $11, 23953
line2644: lui $14, 39378
line2645: ori $20, $21, 30767
line2646: ori $3, $11, 21524
line2647: sub $15, $3, $14
line2648: beq $31, $31, line2582
line2649: nop
line2650: lui $14, 18118
line2651: sw $2, 10825($30)
line2652: sw $1, 5001($27)
line2653: add $29, $29, $28
line2654: add $3, $4, $14
line2655: ori $8, $3, 12162
line2656: sw $29, 5699($29)
line2657: lui $3, 28246
line2658: sw $3, 11860($28)
line2659: lui $5, 42898
line2660: sw $8, 3260($23)
line2661: ori $1, $5, 28598
line2662: ori $28, $29, 2
line2663: lw $17, 8937($28)
line2664: add $1, $1, $17
line2665: ori $11, $17, 24258
line2666: sub $9, $11, $17
line2667: lui $8, 37233
line2668: sw $8, 1177($30)
line2669: lw $27, 1938($17)
line2670: sw $20, 8155($27)
line2671: add $23, $28, $23
line2672: add $9, $31, $8
line2673: lw $15, 6127($27)
line2674: ori $24, $29, 22934
line2675: lw $18, 7719($27)
line2676: lui $5, 12580
line2677: ori $22, $29, 21880
line2678: add $13, $1, $22
line2679: ori $30, $0, 2
line2680: sw $20, 11494($30)
line2681: ori $18, $16, 47179
line2682: add $24, $29, $30
line2683: lui $7, 22301
line2684: ori $9, $7, 49972
line2685: ori $3, $24, 32226
line2686: ori $8, $23, 28331
line2687: ori $23, $29, 48046
line2688: ori $13, $24, 11143
line2689: sw $23, 1574($17)
line2690: ori $17, $30, 48381
line2691: lw $1, 4397($26)
line2692: sw $17, 8725($26)
line2693: lui $9, 14754
line2694: sw $17, 4734($30)
line2695: lui $12, 63736
line2696: ori $12, $1, 22549
line2697: ori $20, $17, 48626
line2698: sw $12, 1265($24)
line2699: lui $13, 1211
line2700: sub $14, $13, $20
line2701: ori $15, $20, 58208
line2702: add $2, $14, $15
line2703: ori $23, $0, 10028
line2704: lui $11, 13109
line2705: lw $14, 1832($23)
line2706: ori $28, $30, 0
line2707: lui $13, 8568
line2708: ori $3, $15, 48177
line2709: add $28, $28, $29
line2710: ori $29, $28, 2
line2711: lui $14, 55905
line2712: add $16, $29, $28
line2713: lw $15, 1489($29)
line2714: lw $12, 1793($29)
line2715: jal line1871
line2716: nop
line2717: sub $26, $28, $29
line2718: lui $9, 64887
line2719: sub $12, $9, $10
line2720: sw $28, 6873($28)
line2721: lw $2, 2469($28)
line2722: ori $16, $26, 29658
line2723: sub $13, $2, $16
line2724: sub $29, $29, $26
line2725: ori $25, $28, 47241
line2726: jal line2737
line2727: nop
line2728: add $10, $23, $11
line2729: sub $4, $28, $23
line2730: sw $4, 10861($29)
line2731: ori $17, $0, 18308
line2732: sub $11, $10, $4
line2733: ori $9, $11, 9064
line2734: lw $17, 11473($28)
line2735: beq $28, $28, line2751
line2736: nop
line2737: lui $15, 9907
line2738: sub $19, $28, $29
line2739: ori $2, $19, 56781
line2740: ori $24, $26, 24375
line2741: sw $24, 10776($19)
line2742: sub $3, $24, $13
line2743: add $19, $29, $28
line2744: sub $29, $29, $26
line2745: sub $11, $7, $12
line2746: ori $28, $28, 2
line2747: lw $23, 11285($29)
line2748: sw $28, 869($28)
line2749: beq $31, $31, line385
line2750: nop
line2751: jal line2209
line2752: nop
line2753: jal line1318
line2754: nop
line2755: ori $28, $0, 2
line2756: lui $12, 9502
line2757: sub $1, $13, $12
line2758: lw $23, 9274($28)
line2759: lw $27, 6194($19)
line2760: ori $7, $27, 29903
line2761: lw $21, 5417($23)
line2762: add $17, $28, $27
line2763: lw $2, 10941($17)
line2764: sub $27, $28, $27
line2765: ori $19, $17, 38208
line2766: ori $19, $0, 13931
line2767: sw $27, 7935($27)
line2768: jal line1864
line2769: nop
line2770: lui $4, 63085
line2771: ori $24, $27, 48745
line2772: jal line490
line2773: nop
line2774: add $6, $4, $31
line2775: ori $2, $6, 27108
line2776: sub $9, $6, $10
line2777: lui $2, 56386
line2778: lw $15, 5080($26)
line2779: sw $2, 1824($26)
line2780: lw $15, 3998($28)
line2781: lui $13, 15934
line2782: lui $9, 14330
line2783: add $12, $15, $9
line2784: add $8, $6, $13
line2785: ori $12, $1, 30593
line2786: sw $13, 5107($29)
line2787: jal line2614
line2788: nop
line2789: add $16, $28, $23
line2790: sw $23, 3386($30)
line2791: sub $3, $16, $11
line2792: jal line125
line2793: nop
line2794: lw $6, 10038($30)
line2795: beq $31, $31, line2803
line2796: nop
line2797: nop
line2798: nop
line2799: ori $22, $19, 61641
line2800: add $26, $30, $28
line2801: beq $26, $26, line3189
line2802: nop
line2803: add $16, $16, $26
line2804: lui $10, 38018
line2805: ori $19, $24, 52604
line2806: add $30, $27, $28
line2807: sw $19, 9558($21)
line2808: sw $10, 4769($30)
line2809: ori $21, $24, 3622
line2810: add $26, $30, $26
line2811: lui $7, 4037
line2812: lui $9, 52744
line2813: add $21, $30, $26
line2814: sub $1, $9, $7
line2815: lw $4, 2330($21)
line2816: add $15, $1, $4
line2817: lw $29, 7929($25)
line2818: beq $26, $30, line2567
line2819: nop
line2820: ori $2, $3, 59508
line2821: add $18, $21, $30
line2822: ori $27, $28, 3
line2823: add $2, $18, $27
line2824: lui $5, 25098
line2825: lw $7, 7301($17)
line2826: sw $1, 3033($23)
line2827: lw $29, 5825($27)
line2828: sub $13, $5, $29
line2829: lw $20, 6913($29)
line2830: add $5, $20, $13
line2831: lw $10, 3957($23)
line2832: sw $5, 11832($20)
line2833: ori $6, $20, 29596
line2834: sw $6, 6547($16)
line2835: add $15, $6, $7
line2836: sub $20, $27, $20
line2837: lw $29, 10933($17)
line2838: sw $15, 3376($29)
line2839: ori $20, $29, 37942
line2840: sw $29, 6960($29)
line2841: sub $5, $9, $29
line2842: lui $4, 529
line2843: ori $20, $29, 60942
line2844: sub $8, $1, $5
line2845: add $28, $29, $27
line2846: lui $3, 41265
line2847: sub $9, $15, $3
line2848: lui $14, 41908
line2849: sw $9, 7889($27)
line2850: ori $26, $0, 2
line2851: lw $19, 5422($26)
line2852: sw $27, 5745($19)
line2853: ori $25, $0, 44338
line2854: lui $8, 54576
line2855: sw $3, 1269($19)
line2856: lui $1, 1304
line2857: lui $6, 21761
line2858: sub $11, $10, $1
line2859: ori $27, $29, 3
line2860: ori $17, $0, 20864
line2861: sub $17, $17, $26
line2862: sub $14, $27, $17
line2863: sw $14, 12153($30)
line2864: add $3, $17, $14
line2865: sw $3, 1494($26)
line2866: lw $23, 4005($30)
line2867: ori $27, $26, 1
line2868: lui $9, 31046
line2869: sub $4, $27, $23
line2870: sub $2, $27, $26
line2871: add $22, $27, $26
line2872: sub $1, $15, $2
line2873: add $2, $22, $2
line2874: lw $8, 1487($22)
line2875: ori $19, $23, 25325
line2876: add $24, $26, $28
line2877: sub $15, $8, $27
line2878: sw $15, 1363($24)
line2879: lui $13, 40835
line2880: add $11, $13, $24
line2881: ori $20, $27, 40164
line2882: sub $13, $13, $20
line2883: ori $28, $0, 0
line2884: lui $3, 1452
line2885: sw $28, 6556($28)
line2886: lui $7, 159
line2887: lw $20, 2295($18)
line2888: sw $3, 7045($20)
line2889: ori $14, $7, 43600
line2890: sw $4, 10476($28)
line2891: ori $27, $0, 2
line2892: ori $13, $13, 60039
line2893: lui $11, 55318
line2894: ori $11, $27, 50134
line2895: add $23, $27, $23
line2896: ori $28, $27, 1
line2897: add $11, $28, $11
line2898: sw $28, 2744($23)
line2899: lui $9, 48736
line2900: lui $6, 123
line2901: lw $19, 6090($27)
line2902: jal line383
line2903: nop
line2904: sub $2, $6, $9
line2905: ori $12, $2, 59956
line2906: sub $8, $3, $12
line2907: lw $13, 7059($18)
line2908: sw $12, 9833($20)
line2909: add $25, $28, $29
line2910: lw $10, 4283($16)
line2911: lui $1, 20897
line2912: jal line2564
line2913: nop
line2914: lw $29, 7334($26)
line2915: lw $23, 6980($29)
line2916: add $13, $29, $23
line2917: sw $13, 5708($29)
line2918: add $16, $25, $31
line2919: ori $10, $29, 56935
line2920: add $3, $13, $16
line2921: lui $5, 15268
line2922: lui $5, 32891
line2923: ori $13, $5, 5060
line2924: sw $5, 2689($28)
line2925: add $2, $13, $5
line2926: sub $13, $26, $2
line2927: lui $14, 9661
line2928: ori $30, $29, 3
line2929: lui $2, 31727
line2930: sub $18, $30, $29
line2931: ori $3, $2, 57593
line2932: sw $25, 6345($18)
line2933: lui $6, 8461
line2934: lw $27, 5697($18)
line2935: lw $26, 2543($27)
line2936: lw $11, 3573($28)
line2937: sub $30, $27, $26
line2938: jal line2604
line2939: nop
line2940: lw $6, 10752($19)
line2941: lui $7, 46458
line2942: lui $9, 20300
line2943: ori $25, $30, 21059
line2944: lui $11, 62131
line2945: sub $4, $5, $11
line2946: add $14, $4, $11
line2947: jal line2210
line2948: nop
line2949: sub $27, $28, $26
line2950: ori $14, $28, 23739
line2951: lw $27, 6553($27)
line2952: add $20, $27, $28
line2953: ori $9, $20, 32418
line2954: sub $15, $20, $27
line2955: sw $9, 8741($20)
line2956: add $26, $27, $28
line2957: ori $15, $26, 30871
line2958: lw $4, 3893($26)
line2959: add $22, $20, $26
line2960: add $7, $22, $15
line2961: lw $19, 4402($22)
line2962: lui $2, 60226
line2963: ori $25, $30, 57939
line2964: sw $21, 1212($19)
line2965: sw $19, 6396($19)
line2966: add $8, $27, $1
line2967: ori $12, $8, 3130
line2968: lui $9, 4054
line2969: add $11, $9, $8
line2970: sw $12, 8781($18)
line2971: sub $21, $24, $30
line2972: lw $7, 2475($21)
line2973: sw $7, 7847($21)
line2974: lw $13, 5993($20)
line2975: sw $7, 8367($21)
line2976: add $29, $27, $26
line2977: ori $14, $29, 17260
line2978: add $3, $21, $15
line2979: sub $15, $29, $14
line2980: sw $14, 4864($30)
line2981: lui $15, 42500
line2982: lw $8, 1252($27)
line2983: lui $2, 51180
line2984: lui $3, 39429
line2985: lw $15, 4463($24)
line2986: ori $12, $15, 40920
line2987: add $30, $27, $26
line2988: sub $17, $30, $29
line2989: lui $5, 36746
line2990: lui $2, 49497
line2991: sub $28, $26, $29
line2992: add $25, $30, $29
line2993: ori $1, $28, 13548
line2994: lui $14, 27140
line2995: add $28, $27, $30
line2996: ori $29, $0, 0
line2997: jal line1819
line2998: nop
line2999: sw $28, 4137($28)
line3000: add $12, $20, $29
line3001: lw $9, 6145($29)
line3002: sw $12, 12243($22)
line3003: add $25, $30, $28
line3004: lui $8, 46143
line3005: beq $26, $28, line2403
line3006: nop
line3007: add $12, $25, $24
line3008: sw $24, 9994($25)
line3009: lw $26, 4134($25)
line3010: add $19, $26, $25
line3011: sw $19, 7695($19)
line3012: sub $6, $19, $12
line3013: sub $3, $26, $19
line3014: sw $19, 8511($19)
line3015: ori $11, $19, 39312
line3016: lw $8, 10557($20)
line3017: add $21, $19, $26
line3018: lw $20, 8380($23)
line3019: sub $29, $29, $30
line3020: sw $21, 5604($21)
line3021: sw $20, 43($20)
line3022: lui $11, 10531
line3023: lw $5, 6619($20)
line3024: sub $20, $20, $29
line3025: lw $12, 3571($20)
line3026: sw $12, 4427($20)
line3027: sw $5, 9752($29)
line3028: ori $13, $12, 1238
line3029: sw $9, 6635($20)
line3030: sw $13, 10323($20)
line3031: sub $9, $13, $20
line3032: add $5, $13, $12
line3033: jal line2559
line3034: nop
line3035: lui $5, 25769
line3036: ori $26, $26, 0
line3037: sw $26, 11477($26)
line3038: lui $9, 41608
line3039: lw $28, 4073($26)
line3040: ori $17, $29, 54497
line3041: ori $21, $28, 16497
line3042: add $8, $13, $5
line3043: add $7, $17, $1
line3044: add $8, $22, $21
line3045: sw $19, 125($26)
line3046: add $4, $7, $8
line3047: add $14, $7, $8
line3048: ori $14, $4, 38964
line3049: ori $10, $14, 34547
line3050: lui $10, 8303
line3051: sub $9, $14, $10
line3052: lw $12, 3950($25)
line3053: lui $3, 52640
line3054: ori $26, $0, 1
line3055: ori $12, $1, 33473
line3056: jal line179
line3057: nop
line3058: sub $1, $26, $3
line3059: beq $31, $31, line2400
line3060: nop
line3061: ori $4, $28, 26377
line3062: sub $25, $21, $28
line3063: sw $28, 5085($28)
line3064: lui $8, 64529
line3065: ori $17, $26, 56236
line3066: lui $12, 5064
line3067: sub $9, $8, $12
line3068: ori $30, $26, 3
line3069: sub $23, $31, $25
line3070: lui $12, 13848
line3071: lui $11, 51867
line3072: add $24, $23, $30
line3073: ori $14, $24, 21079
line3074: lui $12, 18153
line3075: add $5, $30, $12
line3076: sub $24, $26, $29
line3077: lw $23, 9091($22)
line3078: add $13, $5, $25
line3079: lw $7, 10941($23)
line3080: lw $7, 5357($23)
line3081: lw $23, 2887($22)
line3082: sub $16, $28, $30
line3083: lui $15, 21017
line3084: sw $23, 4100($16)
line3085: ori $1, $16, 41478
line3086: lw $23, 8940($16)
line3087: lui $10, 12462
line3088: lw $19, 12274($23)
line3089: ori $19, $20, 30349
line3090: lui $10, 2699
line3091: add $11, $9, $19
line3092: ori $26, $29, 1
line3093: sub $13, $10, $26
line3094: sub $6, $12, $14
line3095: add $11, $6, $13
line3096: lw $13, 382($23)
line3097: lw $18, 48($16)
line3098: lui $7, 2688
line3099: ori $6, $7, 52730
line3100: lw $7, 1824($16)
line3101: sub $2, $23, $6
line3102: lui $12, 41641
line3103: add $17, $18, $27
line3104: sub $15, $30, $2
line3105: sub $3, $15, $17
line3106: add $7, $24, $31
line3107: ori $23, $0, 54609
line3108: sub $7, $23, $3
line3109: add $26, $30, $29
line3110: add $1, $26, $10
line3111: lw $9, 10877($26)
line3112: lui $8, 23255
line3113: sw $8, 8475($17)
line3114: sub $8, $9, $14
line3115: sub $3, $9, $8
line3116: sw $24, 4052($16)
line3117: add $8, $8, $6
line3118: ori $8, $31, 19917
line3119: sw $8, 7395($18)
line3120: ori $18, $26, 64940
line3121: add $28, $29, $27
line3122: lui $13, 35985
line3123: add $5, $18, $28
line3124: sub $8, $5, $2
line3125: lui $1, 13241
line3126: add $16, $28, $27
line3127: lui $12, 46811
line3128: sub $8, $16, $12
line3129: sub $6, $12, $8
line3130: sub $17, $27, $28
line3131: lui $7, 29818
line3132: sub $15, $13, $17
line3133: ori $24, $18, 40912
line3134: lui $5, 28459
line3135: lui $8, 51424
line3136: ori $5, $24, 64650
line3137: ori $18, $16, 36989
line3138: sub $6, $18, $8
line3139: sw $6, 1977($26)
line3140: ori $1, $18, 48680
line3141: add $9, $6, $25
line3142: lui $12, 20898
line3143: lui $12, 46288
line3144: sw $9, 12224($16)
line3145: lw $26, 10336($17)
line3146: lw $6, 5080($26)
line3147: sub $28, $27, $29
line3148: add $28, $30, $26
line3149: sw $6, 11581($28)
line3150: ori $18, $26, 45140
line3151: ori $11, $18, 5722
line3152: lui $10, 21158
line3153: add $6, $30, $11
line3154: sub $26, $28, $26
line3155: sw $8, 8505($26)
line3156: sw $6, 9429($26)
line3157: lw $30, 9399($22)
line3158: sw $30, 5408($30)
line3159: sw $30, 7305($26)
line3160: lui $6, 46911
line3161: sw $6, 11785($26)
line3162: sw $30, 6432($30)
line3163: add $2, $30, $6
line3164: beq $26, $28, line3176
line3165: nop
line3166: nop
line3167: nop
line3168: nop
line3169: nop
line3170: nop
line3171: nop
line3172: nop
line3173: nop
line3174: nop
line3175: nop
line3176: sw $6, 5292($30)
line3177: lui $15, 62124
line3178: lui $6, 7074
line3179: sw $12, 7237($26)
line3180: sw $15, 4856($29)
line3181: lui $14, 22463
line3182: jal line2557
line3183: nop
line3184: sw $14, 11488($16)
line3185: lui $13, 49973
line3186: ori $1, $13, 58160
line3187: beq $26, $28, line2799
line3188: nop
line3189: sub $2, $26, $1
line3190: ori $30, $26, 1
line3191: jal line1721
line3192: nop
line3193: lw $30, 7305($26)
line3194: lw $22, 6092($30)
line3195: jal line2562
line3196: nop
line3197: ori $1, $30, 19988
line3198: ori $18, $22, 57114
line3199: ori $28, $30, 3
line3200: sub $29, $28, $30
line3201: lw $26, 8393($29)
line3202: add $16, $28, $29
line3203: sw $18, 4669($29)
line3204: lui $6, 205
line3205: add $30, $29, $30
line3206: lui $1, 5401
line3207: add $2, $1, $6
line3208: lui $14, 54897
line3209: sub $29, $29, $30
line3210: sw $29, 5072($29)
line3211: jal line3219
line3212: nop
line3213: lw $1, 3089($29)
line3214: ori $5, $5, 7473
line3215: jr $31
line3216: nop
line3217: beq $14, $14, line3270
line3218: nop
line3219: sub $7, $14, $29
line3220: sub $8, $29, $22
line3221: lw $18, 9100($29)
line3222: lui $11, 9038
line3223: lw $10, 1289($18)
line3224: add $1, $5, $11
line3225: add $24, $29, $30
line3226: ori $1, $12, 3600
line3227: sw $24, 8653($24)
line3228: ori $13, $24, 3156
line3229: lui $4, 14271
line3230: lui $15, 59853
line3231: ori $9, $13, 51420
line3232: add $21, $29, $18
line3233: lw $2, 9773($21)
line3234: lw $21, 6001($21)
line3235: lw $18, 6879($21)
line3236: add $14, $18, $21
line3237: lw $29, 10160($18)
line3238: lw $17, 11676($18)
line3239: add $2, $24, $17
line3240: add $9, $2, $8
line3241: add $18, $31, $26
line3242: lw $18, 9563($21)
line3243: ori $26, $29, 3
line3244: add $5, $18, $6
line3245: lw $2, 5289($26)
line3246: ori $5, $26, 56284
line3247: add $5, $5, $2
line3248: sub $1, $2, $5
line3249: add $19, $29, $17
line3250: lui $3, 10595
line3251: sw $1, 8837($19)
line3252: sw $1, 429($19)
line3253: sw $1, 6189($19)
line3254: lw $17, 5421($19)
line3255: sw $1, 6975($21)
line3256: sw $4, 1989($19)
line3257: lui $15, 47496
line3258: add $23, $29, $27
line3259: lui $15, 7158
line3260: sw $23, 1173($23)
line3261: ori $16, $17, 49462
line3262: add $26, $29, $26
line3263: add $21, $28, $29
line3264: ori $11, $18, 23849
line3265: ori $12, $7, 44456
line3266: lui $14, 47929
line3267: sw $12, 1313($21)
line3268: beq $26, $27, line3217
line3269: nop
line3270: lui $3, 1559
line3271: add $1, $3, $14
line3272: lw $28, 4889($27)
line3273: ori $3, $28, 3718
line3274: ori $8, $28, 53992
line3275: sub $21, $26, $21
line3276: jal line166
line3277: nop
line3278: sw $16, 3780($21)
line3279: lui $4, 15713
line3280: lw $17, 11167($28)
line3281: sw $4, 164($21)
line3282: ori $1, $21, 27095
line3283: lui $1, 34937
line3284: sw $17, 4707($17)
line3285: sub $16, $26, $28
line3286: sub $11, $1, $17
line3287: lw $8, 5522($16)
line3288: add $20, $21, $22
line3289: ori $22, $26, 24848
line3290: sub $9, $8, $20
line3291: add $19, $31, $26
line3292: lui $3, 41923
line3293: add $18, $26, $30
line3294: add $19, $26, $18
line3295: sub $18, $23, $26
line3296: sub $4, $18, $19
line3297: add $7, $19, $18
line3298: sw $18, 252($18)
line3299: sw $4, 5577($26)
line3300: add $20, $19, $18
line3301: ori $17, $28, 25488
line3302: beq $26, $27, line3314
line3303: nop
line3304: nop
line3305: nop
line3306: nop
line3307: nop
line3308: nop
line3309: nop
line3310: nop
line3311: nop
line3312: beq $3, $3, line3468
line3313: nop
line3314: sub $3, $7, $20
line3315: add $12, $19, $3
line3316: sub $10, $12, $3
line3317: lui $12, 28248
line3318: lui $6, 48383
line3319: sw $12, 3137($26)
line3320: sw $25, 1069($19)
line3321: ori $12, $10, 13988
line3322: sw $12, 12190($16)
line3323: sub $5, $6, $12
line3324: lw $26, 8394($16)
line3325: lw $14, 845($26)
line3326: ori $24, $26, 46978
line3327: lw $12, 12279($30)
line3328: add $18, $26, $17
line3329: lui $12, 16504
line3330: lui $3, 13080
line3331: add $1, $15, $3
line3332: ori $23, $28, 64589
line3333: add $25, $18, $26
line3334: add $24, $30, $25
line3335: lui $2, 18127
line3336: sub $4, $1, $13
line3337: jal line383
line3338: nop
line3339: ori $16, $26, 10004
line3340: lui $4, 46464
line3341: lui $8, 55685
line3342: lui $12, 25984
line3343: lw $15, 7303($30)
line3344: sub $24, $26, $28
line3345: sub $7, $12, $17
line3346: lw $12, 5230($24)
line3347: lui $1, 27132
line3348: ori $5, $18, 38022
line3349: add $8, $1, $5
line3350: lui $12, 33620
line3351: add $5, $12, $5
line3352: jal line3213
line3353: nop
line3354: sub $11, $30, $11
line3355: lui $11, 37520
line3356: lui $2, 52899
line3357: sw $11, 10737($27)
line3358: add $19, $25, $29
line3359: ori $24, $22, 55729
line3360: ori $20, $19, 27668
line3361: lui $4, 10191
line3362: lui $14, 49002
line3363: add $15, $14, $4
line3364: lw $16, 9405($27)
line3365: lui $2, 33520
line3366: add $1, $16, $2
line3367: add $25, $20, $26
line3368: lw $8, 6125($26)
line3369: add $22, $16, $30
line3370: sw $25, 546($22)
line3371: ori $24, $22, 53287
line3372: add $8, $8, $22
line3373: sub $5, $22, $8
line3374: add $7, $8, $24
line3375: lui $6, 18104
line3376: sw $5, 2934($22)
line3377: sub $30, $30, $28
line3378: lw $18, 5424($30)
line3379: sw $30, 8209($18)
line3380: ori $21, $24, 65390
line3381: sub $5, $30, $29
line3382: lw $8, 1767($28)
line3383: lui $15, 7707
line3384: sub $10, $10, $8
line3385: lw $13, 6189($29)
line3386: ori $3, $13, 10146
line3387: ori $20, $0, 33614
line3388: add $14, $3, $20
line3389: lw $27, 5635($16)
line3390: sw $27, 4480($27)
line3391: sw $1, 10124($27)
line3392: ori $26, $30, 3
line3393: lw $4, 7633($26)
line3394: sub $1, $4, $13
line3395: sub $27, $27, $30
line3396: sw $1, 7993($18)
line3397: lw $29, 1641($29)
line3398: sw $1, 7170($29)
line3399: sw $27, 4128($27)
line3400: add $22, $27, $25
line3401: add $18, $29, $26
line3402: sw $18, 410($29)
line3403: ori $23, $29, 59613
line3404: ori $18, $24, 974
line3405: lui $12, 16465
line3406: add $23, $27, $29
line3407: sub $20, $26, $30
line3408: lui $12, 50804
line3409: sub $12, $23, $20
line3410: lw $9, 6325($20)
line3411: sub $8, $12, $9
line3412: sw $12, 11346($23)
line3413: ori $9, $12, 51639
line3414: sub $12, $8, $9
line3415: lui $9, 58181
line3416: sw $12, 3791($16)
line3417: lui $11, 58045
line3418: add $8, $16, $11
line3419: lui $9, 10833
line3420: lui $4, 19151
line3421: sub $7, $8, $25
line3422: sub $17, $16, $29
line3423: add $8, $7, $17
line3424: ori $22, $17, 41442
line3425: sub $3, $17, $24
line3426: add $25, $29, $16
line3427: add $15, $16, $25
line3428: sub $9, $3, $15
line3429: sub $5, $9, $25
line3430: sub $5, $15, $9
line3431: ori $26, $29, 1
line3432: lui $14, 14409
line3433: sub $23, $25, $27
line3434: lw $7, 6853($23)
line3435: add $16, $25, $31
line3436: lw $23, 4865($23)
line3437: lui $5, 40756
line3438: add $24, $30, $27
line3439: add $30, $26, $27
line3440: lui $1, 59387
line3441: sub $9, $12, $24
line3442: sw $1, 8125($30)
line3443: sub $9, $1, $30
line3444: lw $14, 4430($29)
line3445: add $17, $30, $25
line3446: sw $23, 1410($17)
line3447: lui $6, 35174
line3448: lw $29, 366($17)
line3449: lw $3, 978($17)
line3450: sub $16, $30, $29
line3451: sw $29, 688($29)
line3452: sub $25, $30, $29
line3453: sub $12, $3, $25
line3454: lw $10, 4853($16)
line3455: lui $1, 33078
line3456: jal line386
line3457: nop
line3458: sw $1, 4720($24)
line3459: sub $6, $19, $12
line3460: lui $14, 31251
line3461: ori $7, $6, 6995
line3462: ori $28, $0, 1
line3463: ori $3, $3, 35757
line3464: add $22, $28, $30
line3465: lw $19, 4020($22)
line3466: beq $26, $30, line3312
line3467: nop
line3468: ori $23, $0, 39513
line3469: add $26, $29, $30
line3470: lui $1, 23934
line3471: ori $21, $19, 52713
line3472: sub $29, $26, $30
line3473: lw $5, 5996($29)
line3474: lui $14, 17600
line3475: lw $6, 2768($29)
line3476: ori $1, $5, 61041
line3477: lw $3, 9393($25)
line3478: add $17, $16, $26
line3479: ori $1, $11, 1200
line3480: ori $13, $25, 33612
line3481: lui $6, 44164
line3482: lw $6, 6148($27)
line3483: add $2, $6, $22
line3484: sw $2, 5668($22)
line3485: add $4, $6, $11
line3486: lui $15, 60375
line3487: sw $15, 10812($29)
line3488: ori $20, $30, 2457
line3489: ori $22, $29, 64457
line3490: ori $9, $22, 44008
line3491: lui $9, 5989
line3492: lui $8, 49150
line3493: ori $21, $0, 16123
line3494: lw $28, 1643($28)
line3495: ori $24, $0, 26982
line3496: sw $24, 4954($28)
line3497: lw $18, 9566($28)
line3498: lui $13, 41241
line3499: add $30, $28, $29
line3500: ori $27, $28, 0
line3501: ori $13, $13, 16020
line3502: add $19, $27, $30
line3503: sub $21, $30, $28
line3504: add $19, $27, $30
line3505: sub $8, $19, $6
line3506: sub $8, $8, $21
line3507: lw $25, 4096($19)
line3508: sw $8, 2172($25)
line3509: ori $8, $8, 42730
line3510: sw $29, 4884($25)
line3511: add $4, $8, $25
line3512: add $1, $4, $25
line3513: add $7, $7, $4
line3514: lui $10, 31252
line3515: lui $3, 61939
line3516: ori $23, $27, 38176
line3517: ori $12, $30, 35242
line3518: add $14, $23, $12
line3519: sub $12, $28, $14
line3520: sub $8, $14, $28
line3521: ori $9, $14, 21539
line3522: add $3, $7, $8
line3523: add $12, $8, $16
line3524: add $6, $3, $9
line3525: sw $6, 3258($30)
line3526: lw $23, 1052($25)
line3527: sw $23, 4884($23)
line3528: sub $2, $12, $6
line3529: beq $31, $31, line3541
line3530: nop
line3531: lw $29, 4476($25)
line3532: sw $31, 2051($23)
line3533: add $9, $18, $17
line3534: add $4, $6, $29
line3535: sub $8, $29, $9
line3536: sub $11, $24, $27
line3537: sw $8, 5264($25)
line3538: lw $22, 5009($26)
line3539: jr $31
line3540: nop
line3541: lui $10, 48451
line3542: lw $4, 11856($19)
line3543: ori $29, $27, 0
line3544: ori $18, $18, 38948
line3545: ori $17, $0, 47490
line3546: sw $17, 12177($26)
line3547: ori $13, $29, 2427
line3548: lui $11, 15293
line3549: lui $1, 63976
line3550: ori $26, $27, 3
line3551: sw $11, 9065($26)
line3552: add $9, $26, $1
line3553: ori $17, $26, 62588
line3554: sub $4, $17, $22
line3555: lui $6, 15208
line3556: jal line1730
line3557: nop
line3558: ori $13, $6, 41679
line3559: sub $12, $28, $6
line3560: ori $23, $0, 3437
line3561: add $9, $14, $13
line3562: lw $28, 4477($26)
line3563: sub $8, $9, $23
line3564: sw $9, 5276($28)
line3565: sw $28, 2452($28)
line3566: add $1, $8, $27
line3567: lw $5, 7216($28)
line3568: lw $26, 1971($23)
line3569: add $13, $5, $1
line3570: sw $5, 1332($26)
line3571: add $30, $26, $27
line3572: ori $3, $13, 40330
line3573: sw $3, 4170($30)
line3574: sw $12, 8654($30)
line3575: sw $13, 2478($30)
line3576: sw $3, 1630($30)
line3577: add $24, $26, $28
line3578: lui $7, 6453
line3579: sw $24, 7112($24)
line3580: add $29, $30, $28
line3581: ori $13, $23, 62406
line3582: add $3, $7, $26
line3583: lw $13, 4586($29)
line3584: ori $1, $13, 36134
line3585: add $28, $26, $29
line3586: sub $9, $25, $6
line3587: lui $15, 56968
line3588: sw $15, 10250($28)
line3589: ori $1, $9, 36149
line3590: ori $26, $28, 3
line3591: add $20, $28, $26
line3592: sw $20, 2343($20)
line3593: ori $20, $27, 38332
line3594: sub $10, $20, $23
line3595: sw $20, 8035($23)
line3596: lw $18, 8285($16)
line3597: jal line3531
line3598: nop
line3599: add $5, $7, $8
line3600: lui $1, 34431
line3601: add $22, $28, $26
line3602: lw $15, 5263($22)
line3603: add $23, $26, $22
line3604: lw $21, 8862($30)
line3605: sw $23, 5689($21)
line3606: sub $28, $26, $27
line3607: sw $23, 6829($21)
line3608: lw $20, 9407($28)
line3609: lui $14, 65030
line3610: ori $17, $28, 35051
line3611: ori $5, $20, 58378
line3612: ori $6, $5, 19706
line3613: lui $6, 37596
line3614: lui $14, 50998
line3615: sub $10, $3, $14
line3616: ori $10, $14, 57684
line3617: lui $10, 34668
line3618: add $15, $10, $4
line3619: add $27, $26, $29
line3620: add $4, $2, $27
line3621: lw $14, 7412($23)
line3622: lui $3, 56916
line3623: lui $14, 38502
line3624: jal line1322
line3625: nop
line3626: lui $1, 21060
line3627: ori $18, $0, 55518
line3628: sub $7, $29, $14
line3629: lui $12, 47640
line3630: jal line175
line3631: nop
line3632: ori $15, $5, 29214
line3633: ori $2, $15, 34838
line3634: lui $2, 62007
line3635: jal line461
line3636: nop
line3637: ori $30, $27, 1
line3638: ori $18, $18, 60031
line3639: sub $11, $30, $18
line3640: ori $9, $13, 1483
line3641: lw $26, 3864($23)
line3642: ori $17, $18, 59334
line3643: add $1, $17, $26
line3644: lw $3, 6283($26)
line3645: ori $13, $17, 62992
line3646: sub $10, $7, $3
line3647: lui $15, 27418
line3648: add $7, $10, $13
line3649: lui $14, 46324
line3650: sub $11, $7, $15
line3651: ori $14, $14, 14072
line3652: sw $14, 8085($30)
line3653: ori $5, $15, 35536
line3654: sw $11, 4745($16)
line3655: add $12, $11, $5
line3656: sw $5, 388($19)
line3657: sub $7, $14, $5
line3658: ori $7, $6, 43590
line3659: add $1, $7, $12
line3660: lw $21, 11481($16)
line3661: lw $3, 5535($21)
line3662: sw $12, 9687($21)
line3663: add $14, $21, $3
line3664: sub $15, $27, $14
line3665: lw $10, 4109($30)
line3666: ori $13, $10, 8964
line3667: sw $12, 10199($22)
line3668: sw $10, 1771($22)
line3669: ori $17, $27, 21222
line3670: lui $15, 25930
line3671: lw $18, 5727($22)
line3672: lui $14, 27025
line3673: ori $1, $14, 47827
line3674: ori $3, $29, 49122
line3675: lui $4, 30029
line3676: ori $19, $19, 20312
line3677: sub $28, $26, $28
line3678: sub $4, $4, $19
line3679: add $4, $4, $19
line3680: lui $15, 9918
line3681: lui $3, 15220
line3682: beq $31, $31, line3690
line3683: nop
line3684: nop
line3685: sw $6, 6015($21)
line3686: lui $4, 39009
line3687: sub $1, $28, $4
line3688: jr $31
line3689: nop
line3690: ori $19, $19, 29688
line3691: add $7, $19, $3
line3692: lui $6, 2357
line3693: sub $12, $7, $31
line3694: sub $8, $7, $12
line3695: lw $10, 4168($25)
line3696: ori $2, $10, 34016
line3697: add $12, $10, $2
line3698: lw $26, 10301($16)
line3699: sw $2, 4641($26)
line3700: lui $13, 10274
line3701: ori $18, $19, 2591
line3702: sw $26, 7753($26)
line3703: ori $3, $1, 29709
line3704: lui $2, 18762
line3705: sub $10, $15, $3
line3706: lw $14, 4695($20)
line3707: ori $13, $10, 24955
line3708: sw $13, 7231($22)
line3709: sw $10, 7113($26)
line3710: sub $24, $31, $28
line3711: add $14, $14, $2
line3712: sub $12, $13, $14
line3713: ori $10, $14, 39842
line3714: sub $4, $12, $31
line3715: lui $15, 37387
line3716: ori $23, $27, 17122
line3717: lui $15, 55312
line3718: lw $1, 11955($21)
line3719: lui $9, 3527
line3720: sub $1, $15, $1
line3721: lw $1, 685($27)
line3722: add $23, $31, $28
line3723: lw $18, 11281($27)
line3724: sub $1, $18, $17
line3725: sub $3, $18, $30
line3726: lw $26, 4137($18)
line3727: lui $15, 37927
line3728: lui $5, 23357
line3729: sw $15, 3089($26)
line3730: sub $28, $27, $26
line3731: lw $27, 11160($28)
line3732: sub $18, $29, $28
line3733: sw $27, 10983($27)
line3734: ori $27, $26, 1
line3735: sub $15, $22, $27
line3736: sw $27, 6705($27)
line3737: jal line1055
line3738: nop
line3739: lw $10, 9429($27)
line3740: add $6, $27, $15
line3741: jal line3685
line3742: nop
line3743: sub $30, $27, $28
line3744: lw $12, 7891($21)
line3745: lw $22, 9741($30)
line3746: lui $10, 61065
line3747: ori $19, $27, 3836
line3748: lw $3, 4533($19)
line3749: add $21, $30, $22
line3750: sub $5, $3, $19
line3751: lui $15, 12346
line3752: lui $12, 4210
line3753: lui $4, 25600
line3754: lui $11, 42099
line3755: sw $12, 4437($19)
line3756: sub $29, $30, $27
line3757: ori $25, $30, 26487
line3758: lui $2, 52785
line3759: sub $13, $29, $9
line3760: lw $4, 1085($16)
line3761: ori $8, $14, 11266
line3762: ori $28, $29, 0
line3763: jal line1820
line3764: nop
line3765: add $11, $8, $28
line3766: sub $27, $29, $28
line3767: lw $17, 8864($28)
line3768: lui $1, 11253
line3769: ori $30, $28, 2
line3770: sw $17, 11062($30)
line3771: ori $23, $24, 34867
line3772: lui $11, 63050
line3773: sw $30, 8674($30)
line3774: jal line2615
line3775: nop
line3776: sub $14, $30, $23
line3777: sub $11, $11, $23
line3778: ori $12, $11, 12084
line3779: lw $24, 1746($30)
line3780: sub $10, $11, $14
line3781: lw $25, 9744($24)
line3782: sw $24, 4896($24)
line3783: sw $10, 3268($25)
line3784: ori $27, $28, 2
line3785: ori $18, $0, 4439
line3786: ori $19, $27, 37479
line3787: sub $27, $27, $30
line3788: ori $3, $27, 26569
line3789: sub $5, $3, $10
line3790: add $21, $18, $27
line3791: ori $3, $5, 6902
line3792: jal line1321
line3793: nop
line3794: lw $2, 9652($25)
line3795: lw $23, 4029($18)
line3796: ori $27, $0, 0
line3797: ori $4, $23, 57612
line3798: ori $26, $27, 0
line3799: ori $25, $27, 4237
line3800: lui $6, 62792
line3801: lw $9, 7100($26)
line3802: ori $23, $26, 57100
line3803: lui $13, 12438
line3804: ori $3, $13, 8967
line3805: add $12, $3, $18
line3806: sub $7, $22, $13
line3807: sub $26, $27, $26
line3808: add $26, $30, $26
line3809: sub $14, $9, $5
line3810: lui $2, 59181
line3811: lui $2, 63145
line3812: lw $7, 8560($24)
line3813: lw $17, 9809($17)
line3814: sw $7, 8678($26)
line3815: ori $13, $17, 33380
line3816: lui $1, 8070
line3817: jal line1056
line3818: nop
line3819: ori $25, $23, 17903
line3820: ori $22, $0, 56906
line3821: add $6, $22, $1
line3822: lw $12, 6128($27)
line3823: ori $13, $22, 24388
line3824: sw $12, 1697($18)
line3825: lui $11, 65059
line3826: ori $20, $17, 50601
line3827: ori $13, $13, 7238
line3828: lui $5, 36967
line3829: sub $24, $26, $24
line3830: lw $15, 7634($26)
line3831: sw $3, 5424($27)
line3832: lui $15, 32231
line3833: lui $8, 23095
line3834: add $1, $15, $2
line3835: add $13, $15, $19
line3836: sub $13, $8, $24
line3837: lui $7, 1187
line3838: add $14, $13, $11
line3839: lui $3, 55866
line3840: add $7, $7, $14
line3841: lui $5, 46360
line3842: sw $5, 9756($28)
line3843: lui $7, 31848
line3844: add $18, $26, $27
line3845: add $1, $7, $5
line3846: add $10, $18, $1
line3847: sub $14, $18, $10
line3848: sub $2, $30, $14
line3849: lw $21, 682($26)
line3850: add $4, $21, $9
line3851: lui $8, 63244
line3852: sub $30, $26, $29
line3853: ori $12, $28, 10518
line3854: sub $12, $12, $30
line3855: lw $14, 9115($30)
line3856: lui $7, 56230
line3857: sw $12, 3980($28)
line3858: add $2, $12, $7
line3859: lw $13, 2579($30)
line3860: jal line70
line3861: nop
line3862: lui $6, 9684
line3863: ori $29, $30, 1
line3864: ori $3, $29, 7319
line3865: lw $27, 5071($29)
line3866: lui $13, 34618
line3867: ori $10, $3, 54165
line3868: add $22, $30, $29
line3869: sw $13, 1342($22)
line3870: ori $7, $22, 52579
line3871: jal line460
line3872: nop
line3873: add $11, $24, $22
line3874: add $2, $7, $22
line3875: sub $28, $28, $27
line3876: lw $28, 9340($28)
line3877: ori $10, $13, 24259
line3878: add $3, $28, $10
line3879: sub $18, $28, $27
line3880: lui $12, 52133
line3881: sub $27, $28, $29
line3882: jal line756
line3883: nop
line3884: sw $16, 5432($27)
line3885: add $13, $18, $12
line3886: ori $4, $16, 24338
line3887: lui $11, 54098
line3888: jal line1330
line3889: nop
line3890: add $20, $27, $30
line3891: sub $30, $28, $30
line3892: sw $30, 8996($30)
line3893: lui $13, 57466
line3894: sw $30, 2863($20)
line3895: ori $22, $20, 36786
line3896: add $19, $28, $31
line3897: sub $27, $27, $30
line3898: ori $26, $27, 2
line3899: lw $22, 11168($30)
line3900: lw $1, 4395($22)
line3901: sub $13, $4, $22
line3902: lui $1, 42437
line3903: lui $1, 7558
line3904: add $24, $30, $22
line3905: lw $1, 3191($24)
line3906: sub $4, $19, $1
line3907: sw $14, 4967($18)
line3908: sw $4, 6783($22)
line3909: lw $13, 4731($22)
line3910: sw $29, 11840($25)
line3911: lui $5, 13686
line3912: sub $15, $13, $22
line3913: ori $20, $0, 24460
line3914: sub $11, $20, $5
line3915: lui $5, 26255
line3916: sub $17, $20, $29
line3917: sub $3, $17, $10
line3918: lui $9, 47687
line3919: ori $20, $0, 14377
line3920: add $29, $29, $27
line3921: lui $5, 24053
line3922: add $19, $27, $31
line3923: ori $9, $2, 62078
line3924: lw $19, 6884($30)
line3925: lw $2, 4747($18)
line3926: ori $14, $28, 8809
line3927: lui $2, 33352
line3928: lui $1, 27126
line3929: add $12, $2, $1
line3930: sw $12, 6277($16)
line3931: ori $6, $2, 11896
line3932: sub $7, $30, $1
line3933: sub $16, $29, $19
line3934: ori $19, $0, 63000
line3935: lui $15, 8510
line3936: jal line1865
line3937: nop
line3938: add $20, $27, $31
line3939: lui $6, 33367
line3940: ori $4, $15, 3582
line3941: lw $19, 8436($27)
line3942: lui $9, 57552
line3943: lui $3, 41350
line3944: add $17, $26, $19
line3945: sw $3, 758($17)
line3946: lw $9, 11754($17)
line3947: ori $16, $17, 44547
line3948: lui $4, 34449
line3949: ori $14, $9, 52750
line3950: sw $19, 3596($19)
line3951: ori $15, $14, 3237
line3952: lw $27, 5048($19)
line3953: ori $16, $27, 42042
line3954: lw $16, 6207($27)
line3955: lui $6, 42222
line3956: beq $31, $31, line3968
line3957: nop
line3958: nop
line3959: nop
line3960: nop
line3961: nop
line3962: nop
line3963: nop
line3964: nop
line3965: nop
line3966: nop
line3967: nop
line3968: ori $27, $28, 1
line3969: sub $17, $27, $30
line3970: lw $7, 2603($27)
line3971: ori $27, $27, 0
line3972: sw $27, 5571($27)
line3973: lw $23, 6703($27)
line3974: lw $13, 376($25)
line3975: lui $15, 9289
line3976: add $17, $27, $22
line3977: add $28, $28, $26
line3978: add $2, $9, $17
line3979: ori $27, $27, 3
line3980: sub $2, $2, $13
line3981: add $14, $8, $27
line3982: sw $2, 833($27)
line3983: lw $19, 2345($27)
line3984: ori $26, $0, 1
line3985: lw $28, 2966($17)
line3986: ori $30, $0, 3
line3987: lw $10, 10853($30)
line3988: ori $26, $26, 0
line3989: lw $23, 4895($26)
line3990: sub $26, $26, $28
line3991: sw $26, 9063($26)
line3992: sw $23, 12283($26)
line3993: sw $26, 8376($23)
line3994: ori $18, $26, 37747
line3995: sub $30, $26, $29
line3996: lui $15, 3003
line3997: lui $7, 49207
line3998: ori $11, $13, 28813
line3999: sw $11, 3575($19)
line4000: lui $13, 24693
line4001: lui $5, 8947
line4002: sub $6, $5, $14
line4003: sub $6, $6, $2
line4004: ori $18, $30, 47057
line4005: add $27, $30, $26
line4006: lui $15, 61100
line4007: sw $27, 1363($27)
line4008: add $27, $28, $30
line4009: sw $5, 6548($27)
line4010: add $7, $27, $15
line4011: sw $27, 11712($27)
line4012: lui $8, 59753
line4013: lw $16, 9344($27)
line4014: ori $2, $7, 65106
line4015: sw $10, 3856($16)
line4016: sw $16, 8620($16)
line4017: sw $2, 1184($16)
line4018: lui $2, 64990
line4019: ori $17, $27, 52627
line4020: sw $29, 6324($16)
line4021: add $19, $27, $16
line4022: sub $1, $17, $19
line4023: sw $19, 6092($19)
line4024: sub $15, $17, $15
line4025: sub $1, $1, $27
line4026: lw $17, 11472($23)
line4027: sub $12, $20, $6
line4028: ori $27, $28, 1
line4029: add $14, $12, $19
line4030: lw $5, 9651($27)
line4031: sub $2, $27, $5
line4032: lui $10, 16305
line4033: lui $1, 41499
