package com.example.hans_antlr4.domain.type;

import static org.objectweb.asm.Opcodes.*;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeSpecificOpcodes {
    INT(ILOAD, ISTORE, IRETURN, I2D, D2I, NOP, INEG, IMUL, IDIV, IREM, IADD, ISUB, ISHL, ISHR, IUSHR, IAND, IXOR,
            IOR), LONG(LLOAD, LSTORE, LRETURN, L2D, D2L, L2I, LNEG, LMUL, LDIV, LREM, LADD, LSUB, LSHL, LSHR, LUSHR,
                    LAND, LXOR, LOR), FLOAT(FLOAD, FSTORE, FRETURN, F2D, D2F, F2I, FNEG, FMUL, FDIV, FREM, FADD, FSUB,
                            -1, -1, -1, -1, -1, -1), DOUBLE(DLOAD, DSTORE, DRETURN, NOP, NOP, D2I, DNEG, DMUL, DDIV,
                                    DREM, DADD, DSUB, -1, -1, -1, -1, -1, -1), VOID(ALOAD, ASTORE, RETURN, -1, -1, -1,
                                            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1), OBJECT(ALOAD, ASTORE,
                                                    ARETURN, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                                                    -1);

    private final int load;
    private final int store;
    private final int ret;
    private final int toDouble;
    private final int doubleToThisType;
    private final int toInt;
    private final int unaryNegative;
    private final int mul;
    private final int div;
    private final int rem;
    private final int add;
    private final int sub;
    private final int shl;
    private final int shr;
    private final int unsignedShr;
    private final int and;
    private final int xor;
    private final int or;
}
