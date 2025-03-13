/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * 
 */
public class learning {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    


        int[] arr1 = {-3, 1, 6, 2, 0, 15};
        int[] arr2 = {1, 1, 1, 1};
        int[] arr3 = {1, 2, 3, 4};
        int[] arr4 = {2, -2, 1, 3, 1, 0, 5};
        int[] arr5 = {12, 14, 8, 9, 11, 7};
        
        System.out.println(findFirstMissing(arr1)); // 3
        System.out.println(findFirstMissing(arr2)); // 2
        System.out.println(findFirstMissing(arr3)); // 5
        System.out.println(findFirstMissing(arr4)); // 4
        System.out.println(findFirstMissing(arr5)); // 1

        
        //  int mat[][] = {
        //     {1, 5, 7 },
        //     {3, 2,9},
        //     {1, 2, 3},
        // };
        // int[] arr = { 7, 2, 3};
        // int k=2;
        // System.out.println(covers(mat, arr, k));
        

        // int[] arr = {1, 2, 4, 5};
        // System.out.println(findSmallest(arr));


        //  int m[][] = {
        //     {4, 5, 8, 2},
        //     {3, 12,16, 7},
        //     {13, 1, 10, 14},
        //     {15, 11, 9, 6},
        // };
        // System.out.println("expected 12: " + minOfmax(m));
        


    

    }



    // int[] arr = {1, 1, 4, 10, 10, 4, 3, 10, 10};
    // System.out.println(longestAlmostPalindrome(arr));



        //    int[][] mat = {
        //    {2, 3},
        //    {4, 1}
        //                };
        // System.out.println("המסלול עם הסכום הגבוה ביותר: " + greatestRoute(mat));
                    
        // int[] arr = new int[4];
        // minNumWithSum(arr, 14);
        // System.out.println(Arrays.toString(arr));

        // int sum=7;
        // System.out.println(count(sum));


        // int[] a = {2, 3, 8, 27};
        // int k=30;
        // System.out.println(superInc(a,k));


        // char[][] tavim1 = {
        //     {'a', 'c', 'b', 'c', '@', 'a'},
        //     {'b', 'x', 'z', 'c', 's', 'a'},
        //     {'?', 'c', 'd', '*', 'c', 'd'},
        //     {'b', 'c', 'a', '8', 'b', 'b'},
        //     {'c', '2', 'x', '+', 'b', 'c'}};

        // char[][] tavim2 = {
        //     {'a', 'd', 'c', 's', '@', 'a'},
        //     {'3', 'a', 'z', 'a', 's', 'a'},
        //     {'?', 'c', 'b', 'b', 'c', 'd'},
        //     {'b', 'c', 'a', '8', 'b', 'b'},
        //     {'c', '2', 'x', '+', 'b', 'c'}};

        // int[] arr = {-2,1,4,7,10,13,16,22,25}; // 10
        // //0 ,  1   2   3   4   5   6   7
        // System.out.println("thisssssssssss!");
        // System.out.println("expected 19: " + findMissingIndex(arr));

        // System.out.println("****************************");
        // int[] m = {25, 17, 13, 252, 4, 128, 7, 3, 81};
        // System.out.println("before");
        // for (int num : m) {
        //     System.out.print(num + " ");
        // }

        // sortmod(m, 10);
        // System.out.println("\nafter");
        // for (int num : m) {
        //     System.out.print(num + " ");
        // }

        // int[] sss = {5, 4, 2, 1, 3};

        // System.out.println("expected true: " + isSum(sss, 0));
        // System.out.println("expected true: " + isSum(sss, 8));
        // System.out.println("expected true: " + isSum(sss, 9));
        // System.out.println("expected true: " + isSum(sss, 2));
        // System.out.println("expected false: " + isSum(sss, 11));
        // System.out.println("expected false: " + isSum(sss, 17));

        // System.out.println("******************");

        // int[] r1 = {5, 4, 5, 8, 12, 9, 9, 3};
        // int[] r2 = {7, 3, 3, 12, 10, 2, 10, 7};

        // System.out.println("expected 49: " + shortestRoad(r1, r2));

        // int[] xx = {2, 4, 8, 3, 10, 1, 12, 3, 2};

        // System.out.println("expected 8: " + cheapRt(xx, 3, 2, 4));

        // int[] y = {-4, 1, -8, 9, 6};

        // System.out.println("expected 288: " + findTriplet(y));

        // int[][] matxx = {
        //     {1, 1, -1, 1, 1},
        //     {1, 0, 0, -1, 1},
        //     {1, 1, 1, 1, -1},
        //     {-1, -1, 1, 1, 1},
        //     {1, 1, -1, -1, 1}
        // };

        // System.out.println("@#@#@#@#@#@#@#@#@#@#");
        // System.out.println("expected 9: " + findMaximum(matxx));

        // matxx[0][0] = -1;
        // System.out.println("expected -1: " + findMaximum(matxx));
        // System.out.println("@#@#@#@#@#@#@#@#@#@#");

        // int[][] mmm = {{0, 0, 0},
        // {0, 0, 0},
        // {0, 0, 0}};

        // int[] dif = {5, 7, -2, 10};

        // System.out.println("expected 2 : " + average(dif));

        // int[][] neg = {{-1, -1, -1, -1, -1, -1, -1},
        // {-1, -1, -1, -1, 0, 0, 0},
        // {-1, -1, -1, -1, 0, 0, 0},
        // {-1, -1, -1, 0, 0, 0, 0},
        // {0, 0, 0, 0, 0, 0, 0}};

        // System.out.println("expected 18:" + howManyNegativeNumbers(neg));

        // int mat[][] = {
        //     {1, 2, 3, 2, 0, 1, 2},
        //     {0, 1, 0, 0, 0, 3, 0},
        //     {0, 0, 1, 0, 0, 0, 0},
        //     {5, 0, 0, 1, 0, 0, 0},
        //     {7, 0, 0, 0, 1, 0, 0},
        //     {8, 0, 0, 0, 0, 1, 0},
        //     {1, 0, 0, 0, 0, 0, 0}
        // };

        // System.out.println("expected true : " + isIdentity(mat, 2, 3));
        // System.out.println("expected false : " + isIdentity(mat, 0, 2));
        // System.out.println("expected 3 : " + maxMatrix(mat));

        // int[] j = {6, 6, 18, 18, -4, -4, 9, 9, 10, 10, 2, 4, 4};

        // System.out.println("expected 2 : " + findSingle(j));

        // int[][] matZ = {
        //     {3, 13, 15, 28, 30},
        //     {55, 54, 53, 27, 26},
        //     {54, 12, 52, 51, 50},
        //     {50, 10, 8, 53, 11}
        // };

        // System.out.println("expected 6: " + longestSlope(matZ, 1));
        // System.out.println("expected 3: " + longestSlope(matZ, 2));

        // int[] od = {0, 1, 1, 1, 1, 1, 0, 1, 0, 0};

        // System.out.println("expected 8 : " + what(od));

        // int[] dd = {2, 4, 5, 3, 5, 1};
        // int[] dd1 = {1, 1, 1, 2, 2, 2, 2};

        // System.out.println("expected 5: " + findD(dd));
        // System.out.println("expected 1 or 2: " + findD(dd1));

        // int[] x1 = {3, 3, 2, -7, 2, 1, 1, -2, -2};
        // System.out.println("expected: 3 \n" + longestSubarray(x1));

        // System.out.println("expected true : " + sumPower3(37));
        // System.out.println("expected false : " + sumPower3(38));
        // System.out.println("expected true : " + sumPower3(82));

        // String s1 = "saturday";
        // String s2 = "sunday";

        // // System.out.println("expected 4: " + edit(s1, s2));
        // int[] px = {1, 3, 4, 5, 7};
        // int[] xp = {-2, 0, 1, 3};

        // System.out.println("***");
        // System.out.println("expected 2: " + cT(xp, 2));

        // int[] pyy = {1, 3, 4, 5, 6};

        // System.out.println("expected true: " + py(pyy));
        
        // System.out.println("expected 5: " + countPairs(3));


        // int mOfMax[][] = {
        //     {4, 5, 8, 2},
        //     {3, 12,16, 7},
        //     {13, 1, 10, 14},
        //     {15, 11, 9, 6},
        // };
        // System.out.println("expected 12: " + minOfmax(mOfMax));

    // }

    private static int maxPath(int[][] mat, int i, int j) {

        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length) {
            return Integer.MIN_VALUE;
        }

        if (i == mat.length - 1 && j == mat[0].length - 1) {
            return mat[i][j];
        }

        int tens = mat[i][j] / 10;
        int ones = mat[i][j] % 10;

        int opt1 = mat[i][j] + maxPath(mat, i + ones, j + tens);
        int opt2 = mat[i][j] + maxPath(mat, i + tens, j + ones);

        return Math.max(opt1, opt2);

    }

    public static int maxPath(int[][] mat) {

        return maxPath(mat, 0, 0);

    }

    private static int longestPalindrome(int[] a, int low, int high, int count) {

        if (low >= high) {
            return count;
        }

        if (a[low] == a[high]) {
            return longestPalindrome(a, low + 1, high - 1, count + 2);
        }

        int opt1 = longestPalindrome(a, low + 1, high, count);
        int opt2 = longestPalindrome(a, low, high - 1, count);

        int max = Math.max(opt1, opt2);

        return max;

    }

    public static int longestPalindrome(int[] a) {

        return longestPalindrome(a, 0, a.length - 1, 0);

    }

    private static int lengthPath(char[][] mat, String p, int i, int j) {

        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length) {
            return 0;
        }

        if (p.indexOf(mat[i][j]) == -1) {
            return 0;
        }

        char temp = mat[i][j];
        mat[i][j] = '*';

        int up = lengthPath(mat, p, i - 1, j);
        int down = lengthPath(mat, p, i + 1, j);
        int left = lengthPath(mat, p, i, j - 1);
        int right = lengthPath(mat, p, i, j + 1);

        mat[i][j] = temp;

        int max = Math.max(Math.max(up, down), Math.max(left, right));

        return 1 + max;

    }

    public static int lengthPath(char[][] mat, String p) {
        return lengthPath(mat, p, 0, 0);
    }

    public static int maxPath(char[][] mat, String pattern) {
        return maxPath(mat, pattern, 0, 0, -2);
    }

    private static int maxPath(char[][] mat, String p, int i, int j, int count) {

        if (j >= mat[0].length) {
            j = 0;
            i++;
        }

        if (i >= mat.length) {
            return count;
        }

        int temp = lengthPath(mat, p, i, j); // (1)

        if (temp > count) {
            count = temp;
        }

        return maxPath(mat, p, i, j + 1, count);

    }

    public static int calc(int num, int result, int maxOp) {
        return calc(num, result, maxOp, num, "");
    }

    private static int calc(int num, int result, int maxOp, int sum, String s) {

        if (sum == result) {
            System.out.println(s + num + " = " + result);
            return 1;
        }

        if (maxOp == 0) {
            return 0;
        }

        int plus, minus, divide, multi;

        plus = calc(num, result, maxOp - 1, sum + num, s + num + "+");
        minus = calc(num, result, maxOp - 1, sum - num, s + num + "-");
        divide = calc(num, result, maxOp - 1, sum / num, s + num + "/");
        multi = calc(num, result, maxOp - 1, sum * num, s + num + "*");

        return plus + minus + divide + multi;

    }

    public static boolean isJump(String s1, String s2, int step) {

        if (s1.length() < s2.length()) {
            return false;
        }

        if (s1.charAt(0) != s2.charAt(0)) {
            return false;
        }

        if (s2.length() == 1 && s1.charAt(0) == s2.charAt(0)) {
            return true;
        }

        return isJump(s1.substring(step), s2.substring(1), step);

    }

    private static int strStep(String s1, String s2, int step) {

        int max = (s1.length() / s2.length()) + 1;

        if (step > max) {
            return -1;
        }

        if (isJump(s1, s2, step) == true) {
            return step;
        }

        return strStep(s1, s2, step + 1);

    }

    public static int strStep(String s1, String s2) {
        return strStep(s1, s2, 1);
    }

    public static int findMissingIndex(int[] a) {

        int low, mid, high, missingValue;

        missingValue = 0;
        high = a.length - 1;
        low = 0;

        int d = Math.min((a[1] - a[0]), (a[2] - a[1]));

        while (low < high) {

            mid = (low + high) / 2;

            int eq = a[0] + (mid * d);

            if (eq == a[mid]) {
                low = mid + 1;
            } else {
                missingValue = eq;
                high = mid;
            }

        }

        return missingValue;

    }

    public static void sortmod(int[] a, int k) {

        int n = 0;
        for (int i = 0; i < k; i++) {

            for (int j = 0; j < a.length; j++) {

                if (a[j] % k == i) {
                    int temp = a[n];
                    a[n] = a[j];
                    a[j] = temp;
                    n++;
                }

            }

        }

    }

    public static boolean isSum(int[] a, int num) {

        if (num == 0) {
            return true;
        }

        return isSum(a, num, 0, 0, 0);

    }

    private static boolean isSum(int[] a, int num, int sum, int seq, int i) {

        if (seq > 2 || sum > num) {
            return false;
        }

        if (sum == num) {
            return true;
        }

        if (i >= a.length) {
            return false;
        }

        boolean add = isSum(a, num, sum + a[i], seq + 1, i + 1);
        boolean skip = isSum(a, num, sum, 0, i + 1);

        return add || skip;

    }

    public static int shortestRoad(int[] road1, int[] road2) {

        int sum = 0;
        for (int i = 0; i < road1.length; i++) {
            sum += road1[i];
        }

        int temp = Integer.MAX_VALUE;

        for (int i = 0; i < road1.length; i++) {
            temp = Math.min(temp, sum);
            sum = sum - road1[i] + road2[i];

        }

        return temp;

    }

    public static int cheapRt(int[] a, int step1, int step2, int limit) {
        return cheapRt(a, step1, step2, limit, 0, 0, "");
    }

    private static int cheapRt(int[] a, int step1, int step2, int limit, int i, int sum, String s) {

        if (i >= a.length) {
            return Integer.MAX_VALUE;
        }

        if (i == a.length - 1) {
            System.out.println(s + i + " = " + (sum + a[i]));
            return a[i];
        }

        int opt1 = Integer.MAX_VALUE, opt2 = Integer.MAX_VALUE;

        opt1 = cheapRt(a, step1, step2, limit, i + step1, sum + a[i], s + i + "\t");

        if (limit > 0) {
            opt2 = cheapRt(a, step1, step2, limit - 1, i + step2, sum + a[i], s + i + "\t");
        }

        if (opt2 == Integer.MAX_VALUE && opt1 == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return Math.min(opt1, opt2) + a[i];

    }

    public static int findTriplet(int[] a) {

        int big1, big2, big3;
        int small1, small2;

        big1 = a[0];
        big2 = Integer.MIN_VALUE;
        big3 = Integer.MIN_VALUE;
        small1 = a[0];
        small2 = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {

            if (a[i] > big1) {
                big3 = big2;
                big2 = big1;
                big1 = a[i];
            } else if (a[i] > big2) {
                big3 = big2;
                big2 = a[i];
            } else if (big3 < a[i]) {
                big3 = a[i];
            }

            if (a[i] < small1) {
                small2 = small1;
                small1 = a[i];
            } else if (small2 > a[i]) {
                small2 = a[i];
            }

        }

        int res1, res2;

        res1 = big1 * big2 * big3;
        res2 = small1 * small2 * big1;

        return Math.max(res1, res2);

    }

    private static int findMaximum(int[][] mat, int i, int j, int sum) {

        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length) {
            return sum;
        }

        if (mat[i][j] == -1) {
            return sum;
        }

        int temp = mat[i][j];
        mat[i][j] = -1;

        int up = Integer.MIN_VALUE, down = Integer.MIN_VALUE, left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;

        if (i % 2 == 0) {
            down = findMaximum(mat, i + 1, j, sum + temp);
            right = findMaximum(mat, i, j + 1, sum + temp);
        } else {
            down = findMaximum(mat, i + 1, j, sum + temp);
            left = findMaximum(mat, i, j - 1, sum + temp);
        }

        mat[i][j] = temp;

        return Math.max(down, Math.max(left, right));

    }

    public static int findMaximum(int[][] mat) {

        if (mat[0][0] == -1) {
            return -1;
        }

        return findMaximum(mat, 0, 0, 0);

    }

    private static int totalWay(int[][] a, int k, int i, int j, char lastStep) {

        if (i < 0 || j < 0 || i >= a.length || j >= a[0].length || k < 0) {
            return 0;
        }

        if (a.length - 1 == i && a[0].length - 1 == j) {

            if (k == 0) {
                return 1;
            }
            return 0;
        }

        if (lastStep == 'D') {
            return totalWay(a, k, i + 1, j, 'D') + totalWay(a, k - 1, i, j + 1, 'R');
        }

        if (lastStep == 'R') {
            return totalWay(a, k - 1, i + 1, j, 'D') + totalWay(a, k, i, j + 1, 'R');
        }

        int down = totalWay(a, k, i + 1, j, 'D');
        int right = totalWay(a, k, i, j + 1, 'L');

        return right + down;

    }

    public static int average(int[] a) {

        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        double sub1, sub2, diff, temp = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < a.length - 1; i++) {

            sub1 = a[i] / (i + 1);
            sub2 = (sum - a[i]) / (a.length - 1 - i);

            diff = Math.abs(sub1 - sub2);

            if (temp < diff) {
                temp = diff;
                index = i;
            }

        }

        return index;

    }

    public static int howManyNegativeNumbers(int[][] mat) {

        int low = 0;
        int high = mat[0].length - 1;
        int count = 0;
        while (high >= 0 && mat[low][0] < 0) {

            if (mat[low][high] < 0) {
                count += (high + 1);
                low++;
            } else {
                high--;
            }
        }

        return count;
    }

    private static boolean isIdentity(int[][] mat, int x, int size, int i, int j) {

        if (j == x + size) {
            j = x;
            i++;
        }

        if (i == x + size) {
            return true;
        }

        if (i != j && mat[i][j] != 0) {
            return false;
        } else if (i == j && mat[i][j] != 1) {
            return false;
        }

        return isIdentity(mat, x, size, i, j + 1);

    }

    public static boolean isIdentity(int[][] mat, int x, int size) {
        return isIdentity(mat, x, size, x, x);
    }

    //B
    public static int maxMatrix(int[][] mat) {
        return maxMatrix(mat, mat.length / 2, 1);
    }

    private static int maxMatrix(int[][] mat, int x, int size) {

        if (isIdentity(mat, x, size) == false || x < 0) {
            return size - 2;
        }

        return maxMatrix(mat, x - 1, (size + 2));

    }

    public static int findSingle(int[] a) {

        int low = 0, high = a.length - 1;

        int mid;
        while (low <= high) {

            if (low + high % 2 == 0) {
                mid = (low + high) / 2;
            } else {
                mid = ((low + high) / 2) + 1;
            }

            if (a[mid] != a[mid - 1] && a[mid] != a[mid + 1]) {
                return a[mid];
            } else if (a[mid] == a[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return a[low];

    }

    public static int longestSlope(int[][] mat, int num) {

        return longestSlope(mat, num, 0, 0, 0);

    }

    private static int longestSlope(int[][] mat, int num, int i, int j, int count) {

        if (j == mat[0].length) {
            j = 0;
            i++;
        }

        if (i == mat.length) {
            return count;
        }

        int temp = findPAth(mat, num, i, j, mat[i][j] + num);
        return longestSlope(mat, num, i, j + 1, Math.max(temp, count));
    }

    public static int findPAth(int[][] mat, int num, int i, int j, int prev) {

        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length) {
            return 0;
        }

        if (lastStep - mat[i][j] != num) {
            return 0;
        }

        int temp = mat[i][j];
        mat[i][j] = Integer.MAX_VALUE;

        int up, down, left, right;

        up = findPAth(mat, num, i - 1, j, temp);
        down = findPAth(mat, num, i + 1, j, temp);
        left = findPAth(mat, num, i, j - 1, temp);
        right = findPAth(mat, num, i, j + 1, temp);

        mat[i][j] = temp;

        int max = Math.max(Math.max(up, down), Math.max(left, right));

        return 1 + max;

    }


    public static int what(int[] a) {

        int firstOdd = Integer.MAX_VALUE, lastOdd = 0;
        int oddCount = 0;

        for (int i = 0; i < a.length; i++) {

            if (a[i] % 2 == 1) {
                oddCount++;
                lastOdd = i;
            }

            if (firstOdd > i && a[i] % 2 == 1) {
                firstOdd = i;
            }

        }

        // if oddCount is odd:
        if (oddCount % 2 == 1) {
            return a.length;
        }

        // if oddCount is even:
        int res1 = a.length - (firstOdd + 1);
        int res2 = lastOdd;

        int max = Math.max(res1, res2);

        return max;

    }

    public static void printClosest(int[] a, int[] b, int x) {

        int i = 0, j = 0, temp = Integer.MAX_VALUE, diff;
        int index1 = 0, index2 = 0;

        while (i < a.length && j < b.length) {

            diff = Math.abs(a[i] - b[j]);

            if (diff > x) {

                if (a[i] > b[j]) {
                    j++;
                } else {
                    i++;
                }

            } else {
                if (a[i] > b[j]) {
                    i++;
                } else {
                    j++;
                }
            }

            if (diff < temp) {
                temp = diff;
                index1 = i;
                index2 = j;
            }

        }

        System.out.println(index1 + " and " + index2);

    }

    public static int findD(int[] a) {

        for (int i = 0; i < a.length; i++) {

            int temp = a[i];
            a[i] = a[a[i]];
            a[a[i]] = temp;

        }

        for (int i = 0; i < a.length; i++) {

            if (a[i] != i) {
                return a[i];
            }

        }

        return -1;

    }

    public static int longestSubarray(int[] a) {

        int index = 0, temp = 0, count = 1;

        for (int i = 0; i < a.length - 1; i++) {

            if (a[i] * a[i + 1] < 0) {
                count++;
            } else {
                count = 1;
            }

            if (temp < count) {
                temp = count;
                index = i + 1;
            }

        }

        System.out.println("Starting index = " + ((index - temp) + 1) + " Ending index = " + index);

        return temp;

    }

    public static void printTri(int[] a, int num) {
        int low = 0, mid = 1, high = a.length - 1, res = 0;

        while (low < a.length - 2) {

            if (mid == high) {
                low++;
                mid = low + 1;
            }

            res = a[low] * a[mid] * a[high];

            if (res == num) {
                System.out.println(a[low] + "\t" + a[mid] + "\t" + a[high]);
                low++;
                mid = low + 1;
            } else if (res > num) {
                high--;
            } else {
                mid++;
            }

        }

    }

    public static boolean sumPower3(int num) {
        return sumPower3(num, 0, 0);
    }

    private static boolean sumPower3(int num, int i, int sum) {

        if (sum > num) {
            return false;
        }

        if (sum == num) {
            return true;
        }

        if (Math.pow(3, i) > num) {
            return false;
        }

        boolean opt1, opt2;

        opt1 = sumPower3(num, i + 1, sum + (int) Math.pow(3, i));
        opt2 = sumPower3(num, i + 1, sum);

        return opt1 || opt2;

    }

    public static int edit(String s1, String s2) {

        if (s1.length() == 0) {
            return s2.length();
        }

        if (s2.length() == 0) {
            return s1.length();
        }

        if (s1.charAt(0) == s2.charAt(0)) {
            return edit(s1.substring(1), s2.substring(1));
        }

        int fix1 = edit(s1.substring(1), s2);
        int fix2 = edit(s1, s2.substring(1));

        return 1 + Math.min(fix1, fix2);

    }

    public static int cT(int[] a, int num) {

        int low, mid, high;
        int count = 0;

        for (int i = 0; i < a.length - 2; i++) {
            low = i;
            mid = i + 1;
            high = a.length - 1;

            while (mid < high) {
                int res = a[low] + a[mid] + a[high];

                if (res < num) {
                    count += high - mid;
                    mid++;
                } else {
                    high--;
                }

            }

        }

        return count;

    }

    public static boolean py(int[] a) {

        int low, mid, high;

        for (int i = 0; i < a.length - 2; i++) {

            low = i;
            mid = i + 1;
            high = a.length - 1;

            while (mid < high) {

                int x = (a[low] * a[low]) + (a[mid] * a[mid]);
                int y = a[high] * a[high];

                if (x == y) {
                    return true;
                } else if (x < y) {
                    high--;
                } else {
                    mid++;
                }

            }

        }

        return false;

    }

    public static int countPairs(int n) {
        return countPairs(n,0,0,"");
    }

    private static int countPairs(int n, int len1, int len2, String s) {

        if (len1 > n || len2 > len1) {
            return 0;
        }

        if (len1 == len2 && len1 == n) {
            System.out.println(s);
            return 1;
        }

        int left = countPairs(n, len1 + 1, len2, s + "(");
        int right = countPairs(n, len1, len2 + 1, s + ")");
        
        return left + right;
        
    }

// -----------------------------------------------------------------------------------------------------

public static int minPoints(int [][] m){
    return minPoints(m, m.length-1, m[0].length-1, 0);
    
}
public static int minPoints(int [][] m, int i, int j, int num){
    if(i == 0 && j == 0 && num > 0){
        if (num==0){
            num=num+1;
        }
        return num;
    }
    if (i<0 || j < 0) {
        return Integer.MAX_VALUE;
    }
    if (num <= 0){
        num += num + m[i][j]+1;
    }
    int left = minPoints(m, i - 1, j, num + m[i][j]);
    int right = minPoints(m, i, j - 1, num + m[i][j]);
    return Math.min(left, right);
}

// --------------------------------------------------------------------------------------

public static int minOfmax(int[][]m){
    return minOfmax(m, 0, 0, 0);
}

public static int minOfmax(int[][]m, int i, int j, int max){
    if (i<0 || j < 0 || i >= m.length || j >= m[0].length || m[i][j] < 0) {
        return Integer.MAX_VALUE;
    }
    int temp= m[i][j];
    m[i][j]=-1;
    if(temp>max){
        max=temp;
    }
    
    if(i == m.length-1 && j == m[0].length-1){
         m[i][j]=temp;
        return max;
    }
    int up= minOfmax(m, i+1,  j,  max);
    int down=minOfmax(m,  i-1,  j,  max);
    int left=minOfmax(m,  i,  j-1,  max);
    int right=minOfmax(m,  i,  j+1,  max);
    m[i][j]=temp;
    int[] arr = {up, down, right, left};
    return getMin(arr, 0);
}

public static int getMin(int []arr, int min) {
    if(min == arr.length-1){
        return arr[min];
    }
    return Math.min(arr[min], getMin(arr, min+1));
}

// ------------------------------------------------

// public static boolean superInc(int[] arr, int k) {
//     int high= arr.length-1;
//     while(high>=0 && k>0){
//         if(arr[high]<=k){
//             k-=arr[high];
//         }
//         high--;
//     }
//     return k==0;
// }


// public static int count(int sum){
//     if(sum==0){
//         return 1;
//     }
//     return count(sum, 1);
// }

// public static int count(int sum, int i){
//     if (sum==0){
//         return 1;
//     }
//     if (i>sum){
//         return 0;
//     }
//     return count(sum-i,i+1) + count(sum, i+1);

// }
public static void minNumWithSum(int[] arr, int s) {
    if (arr == null || s < arr.length || s > 9 * arr.length)
        return;

    for (int i = arr.length - 1; i >= 0; i--) {
        arr[i] = Math.min(9, s - i);
        s -= arr[i];
    }
}

public static int longestAlmostPalindrome(int[] arr){
    return longestAlmostPalindrome(arr,0,0,0);
}
//first recursive is to reach all sub arrays
    //starting at 0-0, 0-1, 0-2... 0..arr.length-1 and then increment the first index (i)
    //1-1, 1-2,1-3.... and so on
    //until first index (i) reached the end of the array
    public static int longestAlmostPalindrome(int[] arr, int i, int j, int longest) {
        if (i == arr.length) {
            return longest;//finished, returning longest
        }
        if (j == arr.length) {//second index reached the end of the array
            return longestAlmostPalindrome(arr, i + 1, i + 1, longest);//increasing first index and second index with same value
        }
        //for each subarray, we want to check if it's an almost palindrome sub array
        if (arr[i] == arr[j]//the indexes in edges must be the same, as stated in question
                && isAlmostPalinrome(arr,i,j, false)){//starting flag of found fault to false
            int length = j-i+1;//calculating the length of the sub array
            longest = Math.max(longest, length);//updating longest, if necessary
        }
        return longestAlmostPalindrome(arr, i, j + 1, longest);//moving on with second index
    }

    public static boolean isAlmostPalinrome(int[] arr, int i, int j, boolean foundFault) {
        if (i >= j){//i passed ort equals to j and didn't return false so far, we have almost palindrome
            return true;
        }
        if (arr[i] != arr[j]){//2 numbers in the opposite sides don't match
            if (foundFault){//if not for the first time, game over
                return false;
            }
            foundFault = true;//first time, yellow card
        }
        return isAlmostPalinrome(arr, i+1, j-1, foundFault);//increasing i and decreasing j, continuing to check if palindrome
    }




    // public static int findFirstMissing(int[] arr) {
    //     int n = arr.length;
        
    //     // סידור המספרים במקומם המתאים
    //     for (int i = 0; i < n; i++) {
    //         while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
    //             // החלפת arr[i] עם הערך הנכון שלו
    //             int temp = arr[arr[i] - 1];
    //             arr[arr[i] - 1] = arr[i];
    //             arr[i] = temp;
    //         }
    //     }
        
    //     //   חיפוש המספר הראשון החסר
    //     for (int i = 0; i < n; i++) {
    //         if (arr[i] != i + 1) {
    //             return i + 1;
    //         }
    //     }
        
    //     // אם כל המספרים בין 1 ל-n קיימים, המספר החסר הבא הוא n+1
    //     return n + 1;
    
    // }
  

    public static int findSmallest(int[] arr) {
        int minSum = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - minSum > 0)
                return minSum;
            minSum += arr[i];
        }
        return minSum;
    }
// ------------------------------------------------------------------------------------

public static int findFirstMissing(int[] arr) {
    for(int i=0; i<arr.length; i++){
        if(arr[i]>0 && arr[i]<=arr.length){
            int index= arr[i];
            int temp= arr[index-1];
            arr[i] = temp;
            arr[index-1]= index;
            //  index--;
        }
        
    }
    for(int i=0; i<arr.length; i++){
        if(arr[i] != i+1)
            return i+1;       
    }
    return arr.length+1;
    
}

// ----------------------------------------------------------------------------------------

public static int passingCars(int[] a) {
    int countEast = 0, passing = 0; 
    for (int i = 0; i < a.length; i++) {
        if (a[i] == 1) {
            passing += countEast;
        } else countEast++;
    } 
    return passing;
   } 
   
  


// ---------------------


}//end of class
