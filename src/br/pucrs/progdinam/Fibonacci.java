package br.pucrs.progdinam;
import java.util.Arrays;

public class Fibonacci {
    // FIBO-REC (n)
    //    se n ≤ 1
    //    então devolva n
    //    senão a ← FIBO-REC (n − 1)
    //          b ← FIBO-REC (n − 2)
    //          devolva a + b
    public  int fiboRec(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fiboRec(n - 1) + fiboRec(n - 2);
        }
    }

// FIBO (n)
//  f [0] ← 0 
// 	f [1] ← 1
// 	para i ← 2 até n faça
//            f[i] ← f[i-1]+f[i-2]
//   	devolva f [n]
public int fiboIter(int n) {
        int[] f = new int[n + 1];

        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

// MEMOIZED-FIBO (f, n)
// 	para i ← 0 até n faça
// 	     f [i] ← −1
// 	devolva LOOKUP-FIBO (f, n)

// LOOKUP-FIBO (f, n)
// 	se f [n] ≥ 0
//         então devolva f [n]
// 	se n ≤ 1
// 	então f [n] ← n
// 	senão f [n] ← LOOKUP-FIBO(f, n − 1) + LOOKUP-FIBO(f, n − 2)
// 	devolva f [n]

public int fiboMemo(int n) {
        int[] f = new int[n + 1];
        Arrays.fill(f, -1);
        return lookupFibo(f, n);
    }

    private int lookupFibo(int[] f, int n) {
        if (f[n] >= 0) {
            return f[n];
        }
        
        if (n <= 1) {
            f[n] = n;
        } else {
            f[n] = lookupFibo(f, n - 1) + lookupFibo(f, n - 2);
        }
        return f[n];
    }

}
