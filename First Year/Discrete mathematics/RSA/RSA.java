package com.company;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class RSA {

    public RSA() throws IOException {
        File PublicKeys = new File("public.txt");
        File PrivateKeys = new File("Private.txt");
        BufferedWriter publicBw = new BufferedWriter(new FileWriter(PublicKeys));
        BufferedWriter privateBw = new BufferedWriter(new FileWriter(PrivateKeys));
        Random rand = new Random();
        long p, q, n, k, d = 0, e;
        p = SieveOfEratosthenes(1000).get(rand.nextInt(SieveOfEratosthenes(1000).size()));
        q = SieveOfEratosthenes(1000).get(rand.nextInt(SieveOfEratosthenes(1000).size()));
        n = p * q;
        k = (p - 1) * (q - 1);
        for (e = 2; e < k; e++) {
            if (gcd((int) e, (int) k) == 1) {
                break;
            }
        }
        d = (int) computeD(e, k);
        publicBw.write(e + " " + n + "\n"); // public key
        privateBw.write(d + " " + n + "\n"); // private key
        privateBw.close();
        publicBw.close();
    }

    public int gcd(int x, int y) {
        if (y != 0)
            return gcd(y, x % y);
        else
            return x;
    }


    public List<Integer> SieveOfEratosthenes(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        for (int p = 2; p * p <= n; p++) {
            if (primes[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    primes[i] = false;
                }
            }
        }
        List<Integer> primeNumbers = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }


    public double computeD(double e, double k) {
        for (int x = 1; x < k; x++)
            if (((e % k) * (x % k)) % k == 1)
                return x;
        return 1;
    }

    public void encryptFile() throws IOException {
        BufferedReader textbr = new BufferedReader(new FileReader("text.txt"));
        String Text = textbr.readLine();
        File PublicKeys = new File("public.txt");
        BufferedReader publicBr = new BufferedReader(new FileReader(PublicKeys));
        String line = publicBr.readLine();
        String[] PublicKey = line.split(" ");
        int e = Integer.parseInt(PublicKey[0]);
        int n = Integer.parseInt(PublicKey[1]);
        byte[] textBytes = Text.getBytes(StandardCharsets.UTF_8);
        double[] c = new double[textBytes.length];
        System.out.println(Arrays.toString(textBytes));
        for (int i = 0; i < textBytes.length; i++) {
            c[i] = (Math.pow(textBytes[i], e)) % n;
        }
        File encrypt = new File("encrypt.txt"); // text before encryption
        BufferedWriter encryptedBw = new BufferedWriter(new FileWriter(encrypt));
        for (double C : c) {
            encryptedBw.write((long) C + " ");
        }
        encryptedBw.close();
        publicBr.close();
        textbr.close();
    }

    public void decrypt() throws IOException {
        BufferedReader encryptedbr = new BufferedReader(new FileReader("encrypt.txt"));
        String encryptedText = encryptedbr.readLine();
        String[] temp = encryptedText.split(" ");
        int[] c = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            c[i] = Integer.parseInt(temp[i]);
        }
        File PrivateKeys = new File("Private.txt");
        BufferedReader privateBr = new BufferedReader(new FileReader(PrivateKeys));
        String line = privateBr.readLine();
        String[] PrivateKey = line.split(" ");
        int d = Integer.parseInt(PrivateKey[0]);
        int n = Integer.parseInt(PrivateKey[1]);
        System.out.println(d + "  " + n);
        BigInteger[] M = new BigInteger[c.length];
        System.out.println(Arrays.toString(c));
        for (int i = 0; i < c.length; i++) {
            int c1 = c[i];
            BigInteger N = BigInteger.valueOf(n);
            BigInteger C = BigDecimal.valueOf(c1).toBigInteger();
            M[i] = (C.pow(d)).mod(N);
        }
        System.out.println(Arrays.toString(M));
        String[] Mbytes = new String[M.length];
        byte[] decryptedBytes = new byte[M.length];
        for (int i = 0; i < M.length; i++) {
            Mbytes[i] = String.valueOf(M[i]);
        }
        for (int i = 0; i < M.length; i++) {
            decryptedBytes[i] = Byte.parseByte(Mbytes[i]);
        }
        String decryptedMessage = new String(decryptedBytes, StandardCharsets.UTF_8);
        BufferedWriter encryptedBw = new BufferedWriter(new FileWriter("decrypt.txt"));
        encryptedBw.write(decryptedMessage);
        encryptedBw.close();
        privateBr.close();
        encryptedbr.close();
        encryptedBw.close();
    }


    public void textToFile(String text) throws IOException {
        File Text = new File("text.txt"); // text before encryption
        BufferedWriter TextBw = new BufferedWriter(new FileWriter(Text));
        TextBw.write(text);
        TextBw.close();

    }


}
