fun computeSqrt(n: Double): Double {
    if (n >= 0) return Math.sqrt(n)
    else throw RuntimeException("no negative please") // return Nothing
}

computeSqrt(-1.0)
// Nothing 可以替代任何类
// 唯一作用是帮助编译器验证程序中的类型的完整性

// Any 相当于 Java 中的 Object 类
// Any 有扩展函数 to, run, apply, with 等