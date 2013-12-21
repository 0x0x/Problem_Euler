package Problems;

// Right answer: 40824

public class Problem_8 {
    public static void solution_1() {
        String []inData = new String[20];
        inData[0] = "73167176531330624919225119674426574742355349194934";
        inData[1] = "96983520312774506326239578318016984801869478851843";
        inData[2] = "85861560789112949495459501737958331952853208805511";
        inData[3] = "12540698747158523863050715693290963295227443043557";
        inData[4] = "66896648950445244523161731856403098711121722383113";
        inData[5] = "62229893423380308135336276614282806444486645238749";
        inData[6] = "30358907296290491560440772390713810515859307960866";
        inData[7] = "70172427121883998797908792274921901699720888093776";
        inData[8] = "65727333001053367881220235421809751254540594752243";
        inData[9] = "52584907711670556013604839586446706324415722155397";

        inData[10] = "53697817977846174064955149290862569321978468622482";
        inData[11] = "83972241375657056057490261407972968652414535100474";
        inData[12] = "82166370484403199890008895243450658541227588666881";
        inData[13] = "16427171479924442928230863465674813919123162824586";
        inData[14] = "17866458359124566529476545682848912883142607690042";
        inData[15] = "24219022671055626321111109370544217506941658960408";
        inData[16] = "07198403850962455444362981230987879927244284909188";
        inData[17] = "84580156166097919133875499200524063689912560717606";
        inData[18] = "05886116467109405077541002256983155200055935729725";
        inData[19] = "71636269561882670428252483600823257530420752963450";

        String data = new String("");
        for (String str : inData) {
            if (str != null) {
                data += str;
            }
        }

        int i = 0, j, mul = 1, resultMul = -1;
        while (i < data.length() - 5) {
            j = 0;
            mul = 1;
            while (j < 5) {
                char a = data.charAt(i+j);
                mul *= Character.getNumericValue(data.charAt(i+j));
                if (mul == 0) {
                    break;
                } else {
                    j++;
                }
            }
            if (mul > resultMul) {
                resultMul = mul;
            }
            if (mul == 0) {
                i += j + 1;
            } else {
                i++;
            }
        }
        System.out.println(resultMul);
    }
}