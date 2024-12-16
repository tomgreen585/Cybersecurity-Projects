# How to run part4

## Compile

- javac src/part4/Util.java src/part4/Part4.java

Implementation of bruteforce works for when the decrypted.dec matches the initial plaintext then it breaks. ideally would break if the decrypted.dec is 'human' readable but i heard we could compare it to the plaintext so thats how ive done my implementation

## 0 (ENCRYPTION then DECRYPTION)

- java -cp src part4.Part4 enc --pass "a" -i plaintext.txt -o zeroencrypted1.txt
- java -cp src part4.Part4 zeroencrypted1.txt.enc -t 0
- java -cp src part4.Part4 enc --pass "aa" -i plaintext.txt -o zeroencrypted2.txt
- java -cp src part4.Part4 zeroencrypted2.txt.enc -t 0
- java -cp src part4.Part4 enc --pass "aaa" -i plaintext.txt -o zeroencrypted3.txt
- java -cp src part4.Part4 zeroencrypted3.txt.enc -t 0
- java -cp src part4.Part4 enc --pass "aaaa" -i plaintext.txt -o zeroencrypted4.txt
- java -cp src part4.Part4 zeroencrypted4.txt.enc -t 0
- java -cp src part4.Part4 enc --pass "aaaaa" -i plaintext.txt -o zeroencrypted5.txt
- java -cp src part4.Part4 zeroencrypted5.txt.enc -t 0
- java -cp src part4.Part4 enc --pass "aaaaaa" -i plaintext.txt -o zeroencrypted6.txt
- java -cp src part4.Part4 zeroencrypted6.txt.enc -t 0

## 1 (ENCRYPTION then DECRYPTION)

- java -cp src part4.Part4 enc --pass "a" -i plaintext.txt -o oneencrypted1.txt
- java -cp src part4.Part4 oneencrypted1.txt.enc -t 1
- java -cp src part4.Part4 enc --pass "aa" -i plaintext.txt -o oneencrypted2.txt
- java -cp src part4.Part4 oneencrypted2.txt.enc -t 1
- java -cp src part4.Part4 enc --pass "aaa" -i plaintext.txt -o oneencrypted3.txt
- java -cp src part4.Part4 oneencrypted3.txt.enc -t 1
- java -cp src part4.Part4 enc --pass "aaaa" -i plaintext.txt -o oneencrypted4.txt
- java -cp src part4.Part4 oneencrypted4.txt.enc -t 1
- java -cp src part4.Part4 enc --pass "aaaaa" -i plaintext.txt -o oneencrypted5.txt
- java -cp src part4.Part4 oneencrypted5.txt.enc -t 1
- java -cp src part4.Part4 enc --pass "aaaaaa" -i plaintext.txt -o oneencrypted6.txt
- java -cp src part4.Part4 oneencrypted6.txt.enc -t 1

## 2 (ENCRYPTION then DECRYPTION)

- java -cp src part4.Part4 enc --pass "a" -i plaintext.txt -o twoencrypted1.txt
- java -cp src part4.Part4 twoencrypted1.txt.enc -t 2
- java -cp src part4.Part4 enc --pass "aa" -i plaintext.txt -o twoencrypted2.txt
- java -cp src part4.Part4 twoencrypted2.txt.enc -t 2
- java -cp src part4.Part4 enc --pass "aaa" -i plaintext.txt -o twoencrypted3.txt
- java -cp src part4.Part4 twoencrypted3.txt.enc -t 2
- java -cp src part4.Part4 enc --pass "aaaa" -i plaintext.txt -o twoencrypted4.txt
- java -cp src part4.Part4 twoencrypted4.txt.enc -t 2
- java -cp src part4.Part4 enc --pass "aaaaa" -i plaintext.txt -o twoencrypted5.txt
- java -cp src part4.Part4 twoencrypted5.txt.enc -t 2
- java -cp src part4.Part4 enc --pass "aaaaa" -i plaintext.txt -o twoencrypted6.txt
- java -cp src part4.Part4 twoencrypted6.txt.enc -t 2

## Results

### For lowercase letters (0) - (Nanoseconds) "abcdefghijklmnopqrstuvwxyz"

- Time to go from "a" to "z" (26 combinations) is 352210299.6ns
- Time for each letter is 14088411.98ns (z(t)/26-1)
- 26^1, 26^2, 26^3, 26^4, 26^5, 26^6

- For zeroencrypted1 ("a"), the time was 14088411.98 ns
- For zeroencrypted2 ("aa"), 'zeroencrypted1'(time) x 26 = 366298711.5 ns
- For zeroencrypted3 ("aaa"), 'zeroencrypted2'(time) x 26 = 9523766500 ns
- For zeroencrypted4 ("aaaa"), 'zeroencrypted3'(time) x 26 = 247398789000 ns
- For zeroencrypted5 ("aaaaa"), 'zeroencrypted4'(time) x 26 = 6440367514000 ns
- For zeroencrypted6 ("aaaaaa"), 'zeroencrypted5'(time) x 26 = 167405561334000 ns

### For lowercase letters and numbers (1) - (Nanoseconds) "abcdefghijklmnopqrstuvwxyz1234567890"

- Time to go from "a" to "0" (36 combinations) is 472574375ns
- Time for each letter is 13502125ns (z(t)/36-1)
- 36^1, 36^2, 36^3, 36^4, 36^5, 36^6

- For oneencrypted1 ("a"), the time was: 13502125 ns
- For oneencrypted2 ("aa"), 'oneencrypted1'(time) x 36 = 486076500 ns
- For oneencrypted3 ("aaa"), 'oneencrypted2'(time) x 36 = 17788114708 ns
- For oneencrypted4 ("aaaa"), 'oneencrypted3'(time) x 36 = 640389726548 ns
- For oneencrypted5 ("aaaaa"), 'oneencrypted4'(time) x 36 = 23654953697688 ns
- For oneencrypted6 ("aaaaaa"), 'oneencrypted5'(time) x 36 = 851573540082688 ns

### For lowercase letters and uppercase letters (2) - (Nanoseconds) "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

- Time to go from "a" to "Z" (52 combinations) is 700051782.9 ns
- Time for each letter is 13726505.55ns (z(t)/52-1)
- 52^1, 52^2, 52^3, 52^4, 52^5, 52^6

- For twoencrypted1 ("a"), the time was 13726505.55 ns
- For twoencrypted2 ("aa"), 'twoencrypted1'(time) x 52 713778288.5 ns
- For twoencrypted3 ("aaa"), 'twoencrypted2'(time) x 52 = 37116471000 ns
- For twoencrypted4 ("aaaa"), 'twoencrypted3'(time) x 52 = 1928556492000 ns
- For twoencrypted5 ("aaaaa"), 'twoencrypted4'(time) x 52 = 100286155584000 ns
- For twoencrypted6 ("aaaaaa"), 'twoencrypted5'(time) x 52 = 5211854097088000 ns
