import org.w3c.dom.ranges.Range;

public class Main {
    public static void main(String[] args) {




        
    }


//region מבחני 2016

    //region שאלה 1 מבחן 2016א' מועד 87

    public static int minDiff(int[] arr) {
        return minDiff(arr, 0, 0, 0);
    }

    public static int minDiff(int[] arr, int index, int sum1, int sum2) {
        if (index >= arr.length)
            return Math.abs(sum1 - sum2);
        return Math.min(minDiff(arr, index + 1, sum1 + arr[index], sum2), minDiff(arr, index + 1, sum1, sum2 + arr[index]));
    }

    // public static int minDiff(int[] arr) {
    //     return minDiff(arr, 0, 0, 0);
    //    } 
    //    private static int minDiff(int[] arr, int i, int sum1, int sum2) {
    //     if (i == arr.length) {
    //     return Math.abs(sum1 - sum2);
    //     } else { 
    //     int set1 = minDiff(arr, i + 1, sum1 + arr[i], sum2);
    //     int set2 = minDiff(arr, i + 1, sum1, sum2 + arr[i]);
    //     return Math.min(set1, set2);
    //     } 
    //    } 
       



    //endregion

    //region שאלה 2 מבחן 2016א' מועד 87


    public static int passingCars(int[] a) {
        int easters = 0, passing = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0)
                easters++;
            if (a[i] == 1)
            passing += easters;
        }
        return passing;
    }

    // public static int passingCars(int[] a) {
    //     int countEast = 0, passing = 0; 
    //     for (int i = 0; i < a.length; i++) {
    //     if (a[i] == 1) {
    //     passing += countEast;
    //     } else countEast++;
    //     } 
    //     return passing;
    //    } 
       

    //endregion

    //region שאלה 1 מבחן 2016א' מועד 92



    //    char[][] minChess = {
//            {'0','0','0','0'},
//            {'0','0','0','0'},
//            {'0','0','K','0'},
//            {'H','0','0','0'}
//    };
//char[][] minChess = {
//        {'0','0','0','0'},
//        {'0','0','K','0'},
//        {'0','0','0','0'},
//        {'H','0','0','0'}
//};
//char[][] minChess = {
//        {'0','0','K','0'},
//        {'0','0','0','0'},
//        {'0','0','0','0'},
//        {'H','0','0','0'}
//};
    public static int minPath(char[][] minChess, int i, int j) {
        int minPath = minPath(minChess, i, j, 0);
        if (minPath == Integer.MAX_VALUE)
            return -1;
        return minPath;
    }

    public static int minPath(char[][] minChess, int i, int j, int minSteps) {
        if (i < 0 || j < 0 || i >= minChess.length || j >= minChess.length || minChess[i][j] == 'W')
            return Integer.MAX_VALUE;
        if (minChess[i][j] == 'K')
            return minSteps;
        char temp = minChess[i][j];
        minChess[i][j] = 'W';
        int opt1 = minPath(minChess, i - 2, j + 1, minSteps + 1);
        int opt2 = minPath(minChess, i - 1, j + 2, minSteps + 1);
        int opt3 = minPath(minChess, i + 1, j + 2, minSteps + 1);
        int opt4 = minPath(minChess, i + 2, j + 1, minSteps + 1);
        int opt5 = minPath(minChess, i + 2, j - 1, minSteps + 1);
        int opt6 = minPath(minChess, i + 1, j - 2, minSteps + 1);
        int opt7 = minPath(minChess, i - 1, j - 2, minSteps + 1);
        int opt8 = minPath(minChess, i - 2, j - 1, minSteps + 1);
        minChess[i][j] = temp;
        int[] arr = {opt1, opt2, opt3, opt4, opt5, opt6, opt7, opt8};
        return getMin(arr);
    }


    //endregion

    //region שאלה 2 מבחן 2016א' מועד 92
    // סיבוכיות זמן:   O(log n)
    //  סיבוכיות מקום: O(n)


    public static int[] findUFO(Space tmp) {
        int row = 0, col = 0, low = 0, high = tmp.getSize() - 1, mid = 0;
        int[] check;
        while (low <= high) {
            mid = (low + high) / 2;
            check = tmp.ask(mid, 0);
            if (check[0] == 0)
                break;
            if (check[0] > 0)
                low = mid + 1;
            else if (check[0] < 0)
                high = mid - 1;
        }
        row = mid;
        low = 0;
        high = tmp.getSize() - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            check = tmp.ask(0, mid);
            if (check[1] == 0)
                break;
            if (check[1] > 0)
                low = mid + 1;
            else if (check[1] < 0)
                high = mid - 1;
        }
        col = mid;
        int[] found = {row, col};
        return found;
    }

    //endregion

    //region שאלה 1 מבחן 2016ב' מועד 82


    // int[] vec = {5, 6, 1, 2, 8};
    public static int where(int[] vec) {
        return where(vec, 0, 0, vec.length);
    }

    public static int where(int[] vec, int left, int p, int right) {
        if (p == vec.length)
            return -1;
        if (sum(vec, left, p) == sum(vec, p, right))
            return p;
        return where(vec, left, p + 1, right);
    }

//    int[] vec = {1, 2, 2, 1, 3, 2, 1, 3, 4, -1, 3, 3};
//    int[] vec = {1, 2, 2, 1, 3, 2, 1, 3, 4, -1, 4, 2};

    public static boolean isBalanced(int[] vec, int k) {
        return isBalanced(vec, k, 0, vec.length, where(vec));
    }

    public static boolean isBalanced(int[] vec, int k, int left, int right, int current) {
        if (k == 0)
            return true;
        if (current < 0)
            return false;
        return isBalanced(vec, k - 1, 0, current - 1, where(vec, 0, 0, current)) &&
                isBalanced(vec, k - 1, current, vec.length, where(vec, current, 0, vec.length));
    }


    //endregion;

    //region שאלה 2 מבחן 2016ב' מועד 82


//    Range A1 = new Range(3, 5);
//    Range A2 = new Range(12, 12);
//    Range A3 = new Range(19, 20);
//    Range A4 = new Range(100, 104);
//    Range[] A = {A1, A2, A3, A4};
//     

    public static boolean isSum(Range[] a, int x) {
        int low = 0, high = a.length - 1;
        boolean inLowRange, inHighRange, isSumInTowRanges;
        while (low < high) {

            inLowRange = x >= a[low].getSmallest() * 2 + 1 && x <= a[low].getLargest() * 2 - 1;
            inHighRange = x >= a[high].getSmallest() * 2 + 1 && x <= a[high].getLargest() * 2 - 1;
            isSumInTowRanges = x >= a[low].getSmallest() + a[high].getSmallest() && x <= a[low].getLargest() + a[high].getLargest();
            if (inLowRange || inHighRange || isSumInTowRanges)
                return true;
            else if (x - a[high].getSmallest() < 0)
                high--;
            else low++;
        }
        return false;
    }

    //endregion

    //region שאלה 1 מבחן 2016ב' מועד 87



    public static int count(int sum) {
        return count(sum, 1, "");
    }

    public static int count(int sum, int d, String str) {
        if (sum == 0) {
            System.out.println(str);
            return 1;
        }
        if (d > sum)
            return 0;
        return count(sum - d, d + 1, str + d + " ") + count(sum, d + 1, str);
    }


    //endregion

    //region שאלה 2 מבחן 2016ב' מועד 87



//    String s = "abcbcabcacabcc";
//    String s = "abcbc";
//    String s = "abcbcabcacab";

    public static int subStrC(String s, char c) {
        int index = 0, count = 0, current = -1;
        while (index < s.length()) {
            if (s.charAt(index) == c) {
                current++;
                if (current == 2) {
                    count += 1;
                    current--;
                }
            }
            index++;
        }
        return count;
    }

    public static int subStrMaxC(String s, char c, int k) {
        int index = 0, count = 0, current = -1;
        while (index < s.length()) {
            if (s.charAt(index) == c) {
                current++;
                if (current > 0)
                    count += current;
                if (current > k)
                    current--;
            }
            index++;
        }
        return count;
    }


    //endregion

//endregion

//region מבחני 2017

    //region שאלה 1 מבחן 2017א' מועד 86


    public static int edit(String str1, String str2) {
        return edit(str1, str2, 0, 0, 0);
    }

    public static int edit(String str1, String str2, int index1, int index2, int count) {
        if (index1 == str1.length() && index2 < str2.length())
            return count + str2.length() - index2;
        if (index2 == str2.length() && index1 < str1.length())
            return count + str1.length() - index1;
        if (index2 == str2.length() && index1 == str1.length())
            return count;
        if (str1.charAt(index1) != str2.charAt(index2))
            return Math.min(edit(str1, str2, index1 + 1, index2, count + 1), edit(str1, str2, index1, index2 + 1, count + 1));
        return edit(str1, str2, index1 + 1, index2 + 1, count);

    }

    // public static int edit(String s1, String s2) {

    //     if (s1.length() == 0) {
    //         return s2.length();
    //     }

    //     if (s2.length() == 0) {
    //         return s1.length();
    //     }

    //     if (s1.charAt(0) == s2.charAt(0)) {
    //         return edit(s1.substring(1), s2.substring(1));
    //     }

    //     int fix1 = edit(s1.substring(1), s2);
    //     int fix2 = edit(s1, s2.substring(1));

    //     return 1 + Math.min(fix1, fix2);

    // }


    //endregion

    //region שאלה 2 מבחן 2017א' מועד 86


//int[] arr = {-2, 0, 1, 3};
//int[] arr = {1, 3, 4, 5, 7};
// O(n^2)

    public static int countTriplets(int[] arr, int num) {
        int count = 0, sum, k, j;
        for (int i = 0; i < arr.length - 2; i++) {
            k = arr.length - 1;
            j = i + 1;
            while (j < k) {
                sum = arr[i] + arr[j] + arr[k];
                if (sum < num) {
                    count += k - j;
                    j++;
                } else k--;
            }
        }
        return count;
    }

    // public static int countTriplets(int[] arr, int num) {
    //     int count = 0;
    //     int n = arr.length;

    //     for (int i = 0; i < n - 2; i++) { 
    //         int left = i + 1, right = n - 1; 

    //         while (left < right) {
    //             int sum = arr[i] + arr[left] + arr[right];

    //             if (sum < num) {
    //                 count += (right - left);
    //                 left++;
    //             } else {
    //                 right--;
    //             }
    //         }
    //     }

    //     return count;
    // }


    //endregion

    //region שאלה 1 מבחן 2017א' מועד 87


    //    int[] arr = {7,2,3};
//    int[][] mat = {
//            {1,5,7},
//            {3,2,9},
//            {1,2,3}
//    };
    public static boolean covers(int[][] mat, int[] arr, int k) {
        return covers(mat, arr, k, 0);
    }

    public static boolean covers(int[][] mat, int[] arr, int k, int row) {
        if (allZero(arr))
            return true;
        if (k == 0 || row >= mat.length)
            return false;
        int[] temp = new int[arr.length];
        copy(temp, arr);
        xZero(arr, mat[row]);
        boolean take = covers(mat, arr, k - 1, row + 1);
        copy(arr, temp);
        boolean noTake = covers(mat, arr, k, row + 1);
        return take || noTake;
    }

    //endregion

    //region שאלה 2 מבחן 2017א' מועד 87


//    int[] arr = {1, 3, 4, 5, 6};
//    int[] arr2 = {4, 5, 6, 10, 12};
//      O(n^2)

    // public static boolean isPythagorean(int[] arr) {
    //     double a, b, c, d;
    //     int j, k;
    //     for (int i = 0; i < arr.length - 2; i++) {
    //         j = i + 1;
    //         k = arr.length - 1;
    //         while (j < k) {
    //             a = Math.pow(arr[i], 2.0);
    //             b = Math.pow(arr[j], 2.0);
    //             c = Math.pow(arr[k], 2.0);
    //             d = c;
    //             if (k - 1 != j)
    //                 d = Math.pow(arr[k - 1], 2.0);
    //             if (a + b == c)
    //                 return true;
    //             else if (a + b < d) {
    //                 j++;
    //             } else
    //                 k--;
    //         }
    //     }
    //     return false;
    // }

    public static boolean isPythagorean(int[] arr)
    {
        for (int i = arr.length - 1; i >= 0; i--)
        {
            int c = arr[i];
            int low = 0;
            int high = i - 1;
            while (low < high)
            {
                int a = arr[low];
                int b = arr[high];
                if (c * c == a * a + b * b)
                {
                    return true;
                }
                if (a * a + b * b < c * c)
                {
                    low++;
                }
                else
                {
                    high--;
                }
            }
        }

        return false;
    }

    //endregion

    //region שאלה 1 מבחן 2017א' מועד 90



    //    Item i1 = new Item(10,60);
    //    Item i2 = new Item(20,100);
    //    Item i3 = new Item(30,120);
    //    Item i4 = new Item(15,200);
    //    Item[] items = {i1, i2, i3, i4};

    public static int knapSack(Item[] items, int w) {
        return knapSack(items, w, 0, 0, 0);
    }

    public static int knapSack(Item[] items, int w, int index, int totalValue, int totalWeight) {
        if (index >= items.length)
            return totalValue;
        if (totalWeight + items[index].getWeight() > w)
            return knapSack(items, w, index + 1, totalValue, totalWeight);
        int take = knapSack(items, w, index + 1, totalValue + items[index].getValue(), totalWeight + items[index].getWeight());
        int noTake = knapSack(items, w, index + 1, totalValue, totalWeight);
        return Math.max(take, noTake);
    }


    //endregion

    //region שאלה 2 מבחן 2017א' מועד 90


    public static int findSmallest(int[] arr) {
        int minSum = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - minSum > 0)
                return minSum;
            minSum += arr[i];
        }
        return minSum;
    }

    //endregion

    //region שאלה 1 מבחן 2017ב' מועד 84

    public static int ways(int k, int n) {
        return ways(k, n, 0, 0);
    }

    public static int ways(int k, int n, int right, int left) {
        if (right - left > k)
            return 0;
        if (right + left == n && right - left == k)
            return 1;
        int rightStep = ways(k, n, right + 1, left);
        int leftStep = ways(k, n, right, left - 1);
        return rightStep + leftStep;
    }


    //endregion

    //region שאלה 2 מבחן 2017ב' מועד 84
    //    int[] a = {95,70,-5,3,48,49,52};

    public static boolean findSum(int[] a, int sum) {
        int min = 0, high = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[min] > a[i])
                min = i;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[high] < a[i])
                high = i;
        }
        while (high != min) {
            if (a[min] + a[high] == sum)
                return true;
            else if (a[min] + a[high] > sum)
                high--;
            else min++;
            if (high < 0)
                high = a.length - 1;
            if (min == a.length)
                min = 0;
        }
        return false;
    }

    //endregion

    //region שאלה 1 מבחן 2017ב' מועד 85


    public static int oneFiveSeven(int n) {
        return oneFiveSeven(n, 0);
    }

    public static int oneFiveSeven(int n, int operations) {
        if (n < 0)
            return Integer.MAX_VALUE;
        if (n == 0)
            return operations;
        int takeSeven = oneFiveSeven(n - 7, operations + 1);
        int takeFive = oneFiveSeven(n - 5, operations + 1);
        int takeOne = oneFiveSeven(n - 1, operations + 1);
        int[] arr = {takeSeven, takeFive, takeOne};
        return getMin(arr);
    }

    // public static int oneFiveSeven(int n) {
    //     if (n < 0) {
    //     return Integer.MAX_VALUE; 
    //     } 
    //     if (n == 0) {
    //     return 0; 
    //     } 
    //     int one = 1 + oneFiveSeven(n - 1);
    //     int five = 1 + oneFiveSeven(n - 5);
    //     int seven = 1 + oneFiveSeven(n - 7);
    //     int sum = one; 
    //     if (five < sum && five >= 0) {
    //     sum = five; 
    //     } 
    //     if (seven < sum && seven >= 0) {
    //     sum = seven; 
    //     } 
    //     return sum;
    //    }

    //endregion

    //region שאלה 2 מבחן 2017ב' מועד 85


    //    int[] a = {0,4,6,11,11};
    //    int[] b = {10,20,30,40};
    //     O(n)
    //region דרך 1

    // public static void printClosest(int[] a, int[] b, int x) {
    //     int left = 0, right = b.length - 1, finalA = 0, finalB = 0, differnce = 0, min = Integer.MAX_VALUE, sum = 0;
    //     while (left < b.length && right >= 0) {
    //         sum = a[left] + b[right];
    //         differnce = Math.abs(sum - x);
    //         if (differnce < min && differnce != 0) {
    //             min = differnce;
    //             finalA = a[left];
    //             finalB = b[right];
    //         }
    //         if (sum >= x && right >= 0)
    //             right--;
    //         else if (left < b.length) {
    //             left++;
    //         }
    //     }
    //     System.out.println(finalA + " and " + finalB);
    // }

    public static void printClosest(int[] a, int[] b, int x) {
        int minDiff = Integer.MAX_VALUE;
        String print = "";
        // int minI = 0, minJ = 0;
        int i = 0, j = b.length - 1;
        while (i < a.length && j >= 0) {
            if (Math.abs((a[i] + b[j]) - x) < minDiff){
            minDiff = Math.abs((a[i] + b[j]) - x);
            print = a[i] + " and " + b[j];
            // minI = i;
            // minJ = j;
            }
            if (a[i] + b[j] > x){
                j --;
            }else{
                i++;
            }
            System.out.println(print);
            // System. out.println(minI + " and " + minJ);
        }
    }

    //endregion

    //region דרך 2
//    public static void printClosest(int[] a, int[] b, int x)
//    {
//        int index1 = 0, index2 = 0, final1 = 0, final2 = 0,min = Integer.MAX_VALUE, sum = 0, sum1 = 0, sum2 = 0, differnce, differnce1 = 0, differnce2 = 0, next1 = 0, next2 = 0;
//        while (index1 < a.length || index2 < b.length){
//            next1 = index1 + 1;
//            next2 = index2 + 1;
//            sum = a[index1] + b[index2];
//            differnce = Math.abs(sum - x);
//            if(next1 < a.length)
//             {
//                sum1 = a[next1] + b[index2];
//                differnce1 = Math.abs(sum1 - x);
//            }
//            if (next2 < b.length)
//            {
//                sum2 = a[index1] + b[next2];
//                differnce2 = Math.abs(sum2 - x);
//            }
//            if(differnce < min && differnce != 0){
//                final1 = index1;
//                final2 = index2;
//                min = differnce;
//            }
//            if(differnce == 1){
//                System.out.println(a[final1] + " and " + b[final2]);
//                break;
//            } else if (differnce1 < differnce2 && differnce1 != 0 && differnce1 < min) {
//                index1++;
//            }else if (differnce2 < differnce1 && differnce2 != 0 && differnce2 < min)
//                index2++;
//            else {
//                System.out.println(a[final1] + " and " + b[final2]);
//                break;
//            }
//        }
//    }
    //endregion

    // public static void printClosest(int[] a, int[] b, int x) {
    //     int i = 0, j = b.length - 1;
    //     int closestSum = Integer.MAX_VALUE;
    //     int bestA = 0, bestB = 0;

    //     while (i < a.length && j >= 0) {
    //         int sum = a[i] + b[j];
    //         if (Math.abs(x - sum) < Math.abs(x - closestSum)) {
    //             closestSum = sum;
    //             bestA = a[i];
    //             bestB = b[j];
    //         }
    //         if (sum < x) {
    //             i++;
    //         } else {
    //             j--;
    //         }
    //     }

    //     System.out.println(bestA + " and " + bestB);
    // }

    //endregion

    //region שאלה 1 מבחן 2017ב' מועד 93


    //boolean[][] mat ={
//            {false, false, false, false, true},
//            {false, true, true, true, false},
//            {false, false, true, true, false},
//            {true, false, false, false, false},
//            {true, true, false, false, false}
//    };

    

    public static int cntTrueReg(boolean[][] mat) {
        return cntTrueReg(mat, 0, 0, 0);
    }

    // public static int cntTrueReg(boolean[][] mat, int row, int col, int count) {
    //     if (row >= mat.length || col >= mat[0].length)
    //         return count;
    //     if (mat[row][col]) {
    //         makeRegFalse(mat, row, col);
    //         count++;
    //     }
    //     int right = cntTrueReg(mat, row, col + 1, count);
    //     int down = cntTrueReg(mat, row + 1, col, 0);
    //     return down + right;
    // }

    public static int cntTrueReg(boolean[][] mat, int row, int col, int count) {
        if(col>=mat[0].length){
            row++;
            col=0;
        }
        if(row>=mat.length){
            return count;
        }
        if(mat[row][col]){
            count++;
            makeRegFalse(mat, row, col);
        }
        return cntTrueReg(mat, row, col+1, count);
    }

    public static void makeRegFalse(boolean[][] mat, int row, int col) {
        if (row < 0 || col < 0 || row >= mat.length || col >= mat[0].length || !(mat[row][col]))
            return;
        mat[row][col] = false;
        makeRegFalse(mat, row + 1, col);
        makeRegFalse(mat, row - 1, col);
        makeRegFalse(mat, row, col + 1);
        makeRegFalse(mat, row, col - 1);
    }  

    // public static int cntTrueReg (boolean[][]mat){
    //     return cntTrueReg(mat, 0, 0,0);
    // }
        
    // public static int cntTrueReg (boolean[][]mat, int i, int j, int cnt) {
    //     if(i>mat.length-1) 
    //         return cnt;
        
    //     if(j>mat[0].length-1){
    //     return cntTrueReg(mat, i+1,0,cnt);
    //     }
    //     if(mat[i][j]){
    //         cnt++;
    //         fill(mat,i,j);
    //     }
    //     return cntTrueReg(mat, i, j+1,cnt);
    //     }

    //     private static void fill(boolean[][]mat, int i, int j ) {
    //     if(!mat[i][j]){
    //         return;
    //     }
        
    //     mat[i][j]=false;
    //         if(i+1<mat.length)
    //             fill(mat,i+1,j);
    //         if(i-1>=0)
    //             fill(mat,i-1,j);
    //         if(j+1<mat[0].length)
    //             fill(mat,i,j+1);
    //         if(j-1>=0)
    //             fill(mat, i,j-1);
    //     }


    // public static int cntTrueReg(int[][] mat)
	// {
	// 	return cntTrueReg(mat, 0, 0);
	// }

	// private static int cntTrueReg(int[][] mat, int i, int j)
	// {
	// 	if (i == mat.length)
	// 	{
	// 		return 0;
	// 	}
	// 	if (j == mat[0].length)
	// 	{
	// 		return cntTrueReg(mat, i + 1, 0);
	// 	}

	// 	if (mat[i][j] == 1)
	// 	{
	// 		cntTrueReg(i, j, mat);
	// 		return 1 + cntTrueReg(mat, i, j + 1);
	// 	}

	// 	return cntTrueReg(mat, i, j + 1);
	// }

	// private static int cntTrueReg(int[][] mat, int i, int j, int count)
	// {
	// 	if (i == mat.length)
	// 	{
	// 		return count;
	// 	}
	// 	if (j == mat[0].length)
	// 	{
	// 		return cntTrueReg(mat, i + 1, 0, count);
	// 	}

	// 	if (mat[i][j] == 1)
	// 	{
	// 		cntTrueReg(i, j, mat);
	// 		count++;
	// 	}

	// 	return cntTrueReg(mat, i, j + 1, count);
	// }

	// private static void cntTrueReg(int i, int j, int[][] mat)
	// {
	// 	if (i < 0 || i >= mat.length || j < 0 || j >= mat[i].length)
	// 	{
	// 		return;
	// 	}
	// 	if (mat[i][j] == 1)
	// 	{
	// 		mat[i][j] = 0;
	// 		cntTrueReg(i + 1, j, mat);
	// 		cntTrueReg(i - 1, j, mat);
	// 		cntTrueReg(i, j - 1, mat);
	// 		cntTrueReg(i, j + 1, mat);
	// 	}
	// }
        


    //endregion

    //region שאלה 2 מבחן 2017ב' מועד 93

//    Range A = new Range(4, 1);
//    Range B = new Range(12, 0);
//    Range C = new Range(20, 1);
//    Range D = new Range(102, 2);
//    Range[] rangeA = {A, B, C, D};
// O(log n)

   public static int findNum(Range[] rangeA, int num) {
       int low = 0, high = rangeA.length - 1, mid;
       while (low <= high) {
           mid = (low + high) / 2;
           if (num >= (rangeA[mid].getCenter() - rangeA[mid].getRadius()) && num <= (rangeA[mid].getCenter() + rangeA[mid].getRadius()))
               return mid;
           else if (num < (rangeA[mid].getCenter() - rangeA[mid].getRadius())) {
               high = mid - 1;
           } else low = mid + 1;
       }
       return -1;
   }

    //endregion

//endregion

//region מבחני 2018



    //region שאלה 1 מבחן 2018א' מועד 85


    //    int[][] mat = {
//            {3,13,15,28,30},
//            {55,54,53,27,26},
//            {54,12,52,51,50},
//            {50,10,8,53,11}
//    };


    // public static int longestSlope(int[][] mat, int num) {
    //     return longestSlope(mat, num, 0, 0, 0);
    // }

    // public static int longestSlope(int[][] mat, int num, int row, int col, int slope) {
    //     if (col == mat[0].length && row == mat.length)
    //         return slope;
    //     if (col == mat[0].length)
    //         return longestSlope(mat, num, row + 1, 0, slope);
    //     slope = Math.max(slope, getSlope(mat, num, row, col, 1, Integer.MIN_VALUE));
    //     return longestSlope(mat, num, row, col + 1, slope);


    // }

    // public static int getSlope(int[][] mat, int num, int row, int col, int slope, int last) {
    //     if (row < 0 || col < 0 || row >= mat.length || col >= mat[0].length || mat[row][col] == Integer.MIN_VALUE)
    //         return slope;
    //     int temp = mat[row][col];
    //     if (last - temp == num)
    //         slope++;
    //     else if (last > Integer.MIN_VALUE) {
    //         return slope;
    //     }
    //     mat[row][col] = Integer.MIN_VALUE;
    //     int takeRight = getSlope(mat, num, row, col + 1, slope, temp);
    //     int takeDown = getSlope(mat, num, row + 1, col, slope, temp);
    //     int takeLeft = getSlope(mat, num, row, col - 1, slope, temp);
    //     int takeUp = getSlope(mat, num, row - 1, col, slope, temp);
    //     mat[row][col] = temp;
    //     int[] arr = {takeRight, takeDown, takeLeft, takeUp};
    //     return getMax(arr);

    // }

    public static int longestSlope(int[][]mat, int num){
        return longestSlope(mat, num, 0,0,1);
    }

    private static int longestSlope(int[][] mat, int num, int i, int j, int max) {
        if (j == mat[0].length){
            return longestSlope(mat, num, i+1, 0, max);
        } else if (i==mat.length){
            return max;
        } else {
            int newPath = findPAth(mat, num, i, j, mat[i][j]+num);
            return longestSlope(mat,num, i, j+1, Math.max(max, newPath));
        }
    }
        
    private static int findPAth(int[][] mat, int num, int i, int j, int prev) {
        if(i<0 || j<0 || i>=mat.length || j>=mat[0].length) {
            return 0;
        }
        if(prev - mat[i][j] != num) {
            return 0;
        }
        int up = findPAth(mat, num, i-1, j, mat[i][j]+1);
        int down = findPAth(mat, num, i+1, j, mat[i][j]+1);
        int left = findPAth(mat, num, i, j-1, mat[i][j]+1);
        int right = findPAth(mat, num, i, j+1, mat[i][j]+1);
        return Math.max(Math.max(up,down),Math.max(left, right));

    }

    //endregion

    //region שאלה 2 מבחן 2018א' מועד 85
    // O(n)


    // public static int what(int[] a) {
    //     int start = 0, end = a.length - 1, sum = 0, maxLen = 0;
    //     for (int i = 0; i < a.length; i++) {
    //         sum += a[i];
    //     }
    //     int temp = sum;
    //     while (end >= 0 && temp % 2 != 1) {
    //         temp -= a[end];
    //         end--;
    //     }
    //     maxLen = end - start + 1;
    //     end = a.length - 1;
    //     temp = sum;
    //     while (start < a.length && temp % 2 != 1) {
    //         temp -= a[start];
    //         start++;
    //     }
    //     maxLen = Math.max(maxLen, end - start + 1);
    //     if (temp == 0)
    //         maxLen = 0;
    //     return maxLen;
    // }

    public static int what(int[] a) {
        int low=0, high=a.length-1, sum=0, len=a.length;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            }
        if(sum%2==1){
            return len;
        }
        len--;
        while(low<=high){
            if(sum%2==1){
                return len;
            }
        if(a[low]%2==1 || a[high]%2==1){
            return len;
        }    
        low++;
        high--;
        len--;
        }
        return 0;
    }
    


    //endregion

    //region שאלה 1 מבחן 2018א' מועד 91


    //int[] stations = {2,8,3,4,7,1,3,2};
    public static int cheapestRoute(int[] stations) {
        return cheapestRoute(stations, 0, 0);
    }

    public static int cheapestRoute(int[] stations, int index, int sum) {
        if (index > stations.length - 1)
            return Integer.MAX_VALUE;
        if (index == stations.length - 1)
            return sum + stations[index];
        int take = cheapestRoute(stations, index + 1, sum + stations[index]);
        int takeNext = cheapestRoute(stations, index + 2, sum + stations[index]);
        return Math.min(take, takeNext);
    }

    // public static int cheapestRoute(int[] stations){
    //     return cheapestRoute(stations, 0);
    // }
    // private static int cheapestRoute(int[] stations, int i) {
    //     if(i>= stations.length){
    //         return Integer.MAX_VALUE;
    //     }
    //     if (i==stations.length-1){
    //         return stations[i];
    //     }   
    //     return station[i] + Math.min(cheapestRoute(stations, i+1), cheapestRoute(stations,i+2);
    // }
    

    //endregion

    //region שאלה 2 מבחן 2018א' מועד 91

    //  int[] a = {35, 17, 13, 252, 4, 128, 7, 3, 81};

    public static void sortMod(int[] a, int k) {
        int i = 0, j = 0, l = 0, temp;
        while (i < a.length) {
            if (a[j] % k == l) {
                temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                i++;
            }
            j++;
            if (j == a.length) {
                j = i;
                l++;
            }
        }
    }

    // public static void sortMod(int[] a, int k) {
    //     int index=0, temp;
    //     for (int i = 0; i < k; i++) {
    //         for (int j = index; j < a.length; j++) {
    //             if (a[j] % k == i) {
    //                 int temp = a[index];
    //                 a[index] = a[j];
    //                 a[j]=temp;
    //                 index++;
    //             }
    //         }
    //     }
    // }


    //endregion

    //region שאלה 1 מבחן 2018ב' מועד 83

//    int[][] drm = {
//            {2, 0, 1, 2, 3},
//            {2, 3, 5, 5, 4},
//            {8, -1, 6, 8, 7},
//            {3, 4, 7, 2, 4},
//            {2, 4, 3, 1, 2}
//    };

    public static int prince(int[][] drm, int i, int j) {
        return prince(drm, i, j, drm[i][j]);
    }

    public static int prince(int[][] drm, int i, int j, int prev) {
        if (i >= drm.length || i < 0 || j >= drm[0].length || j < 0 || drm[i][j] == -2)
            return Integer.MAX_VALUE;
        if (drm[i][j] == -1)
            return 1;
        if (drm[i][j] - prev > 1 || prev - drm[i][j] > 2)
            return Integer.MAX_VALUE;
        int temp = drm[i][j];
        drm[i][j] = -10;
        int right = 1 + prince(drm, i, j + 1, temp);
        int left = 1 + prince(drm, i, j - 1, temp);
        int down = 1 + prince(drm, i + 1, j, temp);
        int up = 1 + prince(drm, i - 1, j, temp);
        drm[i][j] = temp;
        int[] arr = {right, left, down, up};
        return getMin(arr);
    }

    // public static int prince(int[][] drm, int i, int j) {
    //     int steps =  prince(drm, i, j, drm[i][j])+1;
    //         if (steps >=Integer.MAX_VALUE){
    //             return -1;
    //         }
    //         return steps;
    // }

    // public static int prince(int[][] drm, int i, int j, int prev) {
    //     if (i >= drm.length-1 || i < 0 || j >= drm[0].length-1 || j < 0)
    //         return Integer.MAX_VALUE;
    //     if (drm[i][j] == -1)
    //         return 0;
    //     if ( prev - drm[i][j]  > 2 || prev - drm[i][j] < -1){
    //         return Integer.MAX_VALUE;
    //     }
    //     int temp = drm[i][j];
    //     drm[i][j] = -10;
    //     int right = prince(drm, i, j + 1, temp)+1;
    //     int left = prince(drm, i, j - 1, temp)+1;
    //     int down = prince(drm, i + 1, j, temp)+1;
    //     int up = prince(drm, i - 1, j, temp)+1;
    //     drm[i][j] = temp;
    //     return Math.min(Math.min(up,down),Math.min(right,left));
    // }

    //endregion

    //region שאלה 2 מבחן 2018ב' מועד 83


//    int[] a = {6, 6, 18, 18, -4, -4, 12, 9, 9};
//    int[] b = {8, 8, -7, -7, 3, 3, 0, 0, 10, 10, 5, 5, 4};
//    int[] c = {5};

    // public static int findSingle(int[] a) {
    //     int current = 0, last = 0;
    //     while (current < a.length) {
    //         if (current % 2 != 0 && a[current] != a[last])
    //             return a[last];
    //         last = current;
    //         current++;
    //     }
    //     return a[last];
    // }

    public static int findSingle(int[] a) {
        if (a.length==1){
            return a[0];
        }
        int low = 0, high = a.length-1, mid;
        while(low<high){
            mid = (low+high)/2;
            if (a[mid]==a[mid+1]){
                if((mid-low)%2==0){
                    low=mid;
                } else {
                    high=mid-1;
                }
            }else if (a[mid]==a[mid-1]){
                if((high-mid)%2==0){
                    high=mid;
                } else{
                    low=mid+1;
                }
            }else{
                return a[mid];
            }
        }
        return a[low];
    }

    // private static int findSingle(int[] a)
	// {
	// 	int low = 0;
	// 	int high = a.length - 1;
	// 	while (low < high)
	// 	{
	// 		int mid = (low + high) / 2;
	// 		if ((mid == low || a[mid] != a[mid - 1]) && (mid == high || a[mid] != a[mid + 1]))
	// 		{
	// 			// a[mid] != a[mid-1] && a[mid] != a[mid+1]
	// 			return mid;
	// 		}
	// 		if (a[mid] == a[mid + 1])
	// 		{
	// 			if (mid - low % 2 == 0)
	// 			{
	// 				low = mid + 2;
	// 			}
	// 			else
	// 			{
	// 				high = mid - 1;
	// 			}
	// 		}
	// 		else
	// 		{
	// 			if (mid - low % 2 == 0)
	// 			{
	// 				high = mid - 2;
	// 			}
	// 			else
	// 			{
	// 				low = mid + 1;
	// 			}
	// 		}
	// 	}

	// 	return low;
	// }

    //endregion

//endregion

//region מבחני 2019


    //region שאלה 1 מבחן 2019א' מועד 84


    // public static boolean sumPower3(int num) {
    //     return sumPower3(num, 0);
    // }

    // public static boolean sumPower3(int num, int pow) {
    //     if (num == 0)
    //         return true;
    //     if (num < 0 || Math.pow(3, pow) > num)
    //         return false;
    //     boolean take = sumPower3((int) (num - Math.pow(3, pow)), pow + 1);
    //     boolean noTake = sumPower3(num, pow + 1);
    //     return take || noTake;
    // }

    // public static boolean sumPower3(int num) {
    //     return sumPower3(num, 0,0);
    // }
    // public static boolean sumPower3(int num,int sum, int k){
    //     if (num == sum){
    //         return true;
    //     }
    //     if (sum > num || Math.pow(3, k) > num){
    //         return false;
    //     }
    //     return sumPower3(num, sum + (int) Math.pow(3, k), k + 1) || sumPower3(num, sum, k+1);
    // }

    public static boolean sumPower3(int num) {
        return sumPower3(num, 0);
    }
    public static boolean sumPower3(int num, int k){
        if (num == 0){
            return true;
        }
        if (num < 0 || Math.pow(3, k) > num){
            return false;
        }
        return sumPower3(num - (int) Math.pow(3, k), k + 1) || sumPower3(num,k+1);
    }


    //endregion


    //region שאלה 2 מבחן 2019א' מועד 84


//    int[] arr = {5, 7, -2, 10};
//    sliding window 

    public static int average(int[] arr) {
        double sum1 = 0, sum2 = 0, average1, average2, maxAverage = 0;
        int num1 = arr.length - 1, num2 = 0, index = 0;
        for (int i = 1; i < arr.length; i++) {
            sum1 += arr[i];
        }
        sum2 += arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            average1 = sum1 / num1;
            average2 = sum2 / i;
            if (Math.abs(average2 - average1) > maxAverage) {
                maxAverage = Math.abs(average2 - average1);
                index = i;
            }
            sum1 -= arr[i];
            num1--;
            sum2 += arr[i];
        }
        return index;
    }



    //endregion

    //region שאלה 1 מבחן 2019א' מועד 85


    public static int longestPalindrome(int[] arr) {
        return longestPalindrome(arr, 0);
    }

    public static int longestPalindrome(int[] arr, int i) {
        if (i >= arr.length)
            return 0;
        return Math.max(longestPalindromeFromI(arr, i, arr.length - 1), longestPalindrome(arr, i + 1));
    }

    public static int longestPalindromeFromI(int[] arr, int i, int end) {
        if (palindrome(arr, i, end))
            return end - i + 1;
        return longestPalindromeFromI(arr, i, end - 1);
    }

    public static boolean palindrome(int[] arr, int start, int end) {
        if (start >= end)
            return true;
        if (arr[start] != arr[end])
            return false;
        return palindrome(arr, start + 1, end - 1);
    }


    //endregion

    //region שאלה 2 מבחן 2019א' מועד 85
    // O(log n)


    public static int missingValue(int[] arr) {
        int size = arr.length;
        int commonDiff = (arr[size - 1] - arr[0]) / size;

        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == arr[0] + mid * commonDiff) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return arr[0] + left * commonDiff;
    }

    //endregion

    //region שאלה 1 מבחן 2019א' מועד 83

    //    int[][] mat = {
//            {1, 1, 1, 1, 1, 1, 1},
//            {1, 1, 0, 1, 0, 0, 1},
//            {1, 1, 1, 1, 0, 1, 1}
//    };
    public static int longestPath(int[][] mat, int x, int y) {
        return longestPath(mat, x, y, 0, 0);
    }

    public static int longestPath(int[][] mat, int x, int y, int row, int col) {
        if (row < 0 || row >= mat.length || col < 0 || col >= mat[0].length || mat[row][col] == 0)
            return Integer.MIN_VALUE;
        if (row == x && col == y)
            return 1;
        int temp = mat[row][col];
        mat[row][col] = 0;
        int left = longestPath(mat, x, y, row, col - 1) + 1;
        int right = longestPath(mat, x, y, row, col + 1) + 1;
        int down = longestPath(mat, x, y, row + 1, col) + 1;
        int up = longestPath(mat, x, y, row - 1, col) + 1;
        mat[row][col] = temp;
        int[] arr = {left, right, down, up};
        return getMax(arr);
    }
    //endregion

    //region שאלה 2 מבחן 2019א' מועד 83

//    int[][] array = {
//            {-99, -72, -64, -55, -28, -10, -5},
//            {-72, -53, -46, -38,  11,  13, 22},
//            {-63, -48, -27, -12,  14,  16, 23},
//            {-44, -29, -10,   0,  18,  20, 28},
//            {  0,  12,  14,  20,  28,  30, 35}
//    };

//    O(n+m)

    // public static int howManyNegativeNumbers(int[][] arr) {
    //     int row = arr.length - 1, col = 0, negativeNumbers = 0;
    //     while (col < arr[0].length) {
    //         while (row >= 0) {
    //             if (arr[row][col] == 0) {
    //                 negativeNumbers += row;
    //                 break;
    //             }
    //             if (arr[row][col] < 0) {
    //                 negativeNumbers += row + 1;
    //                 break;
    //             }
    //             row--;
    //         }
    //         col++;
    //     }
    //     return negativeNumbers;
    // }

    public static int howManyNegativeNumbers(int[][] arr) {
        int i = 0, j = arr[0].length - 1, count = 0; 
        while (i < arr.length && j > -1) {
        if (arr[i][j] < 0) {
        count += j + 1; 
        i++;
        } else j--; 
        } 
        return count;
       } 

    //endregion

    //region שאלה 1 מבחן 2019ב' מועד 86


    //    int[][] mat = {
//            {1, 3, 1, 6},
//            {2, 8, 1, 2},
//            {6, 2, 7, 5},
//            {2, 4, 1, 3}
//    };
    public static int howManyPaths(int[][] mat) {
        return howManyPaths(mat, 0, 0);
    }

    public static int howManyPaths(int[][] mat, int row, int col) {
        if (row < 0 || row >= mat.length || col < 0 || col >= mat[0].length || mat[row][col] == 0)
            return 0;
        if (row == mat.length - 1 && col == mat[0].length - 1)
            return 1;
        int k = mat[row][col];
        mat[row][col] = 0;
        int right = howManyPaths(mat, row, col + k);
        int left = howManyPaths(mat, row, col - k);
        int down = howManyPaths(mat, row + k, col);
        int up = howManyPaths(mat, row - k, col);
        mat[row][col] = k;
        return right + left + down + up;
    }


    //endregion

    //region שאלה 2 מבחן 2019ב' מועד 86


//    int[] a = {19, 19, 16, 15, 15, 15, 13, 5};
//    int[] b = {0, 12, 13, 14, 14, 15, 15, 19, 25, 30, 35};

    public static int meetingPoint(int[] a, int[] b) {
        int low = 0, high = Math.min(a.length, b.length) - 1, mid, min = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == b[mid]) {
                min = mid;
                high = mid - 1;
            } else if (a[mid] > b[mid]) {
                low = mid + 1;
            } else high = mid - 1;
        }
        return min;
    }

    // public static int meetingPoint(int[] a, int[] b) {
    //     int low = 0, high = Math.min(a.length, b.length) - 1, mid=-1;
    //     while (low < high) {
    //         mid = (low + high) / 2;
    //         if (a[mid] == b[mid]) {
    //             high = mid;
    //         } else if (a[mid] > b[mid]) {
    //             low = mid + 1;
    //         } else {
    //             high = mid - 1;
    //         }
    //     }
    //     if (a[high]!=b[high]){
    //         return -1;
    //     }
    //     return mid;
    // }
    //endregion

    //region שאלה 1 מבחן 2019ב' מועד 93

    //int[] a = {5 , 4 , 2 , 1, 3};
    public static boolean isSum(int[] a, int num) {
        return isSum(a, num, 0, 1, 0);
    }

    public static boolean isSum(int[] a, int num, int index, int neighbors, int sum) {
        if (sum == num)
            return true;
        if (index >= a.length || neighbors >= 3)
            return false;
        boolean take = isSum(a, num, index + 1, neighbors + 1, sum + a[index]);
        boolean noTake = isSum(a, num, index + 1, 1, sum);
        return take || noTake;
    }

    //endregion

    //region שאלה 2 מבחן 2019ב' מועד 93


    //int[] road1 = {5,4,5,8,12,9,9,3};
    //int[] road2 = {7,3,3,12,10,2,10,7};
    // O(n)


    // public static int shortestRoad(int[] road1, int[] road2) {
    //     int sum1 = 0, sum2 = 0, N = road1.length, r1 = 0, r2 = 0, min;
    //     for (int i = 0; i < N; i++) {
    //         sum1 += road1[i];

    //     }
    //     min = Math.min(sum1, sum2);
    //     for (int i = 0; i < N; i++) {
    //         r1 += road1[i];
    //         sum2 += road2[i];
    //         r2 += road2[i];
    //         sum1 -= road1[i];
    //         sum2 -= road2[i];
    //         if (min > r1 + sum2 || min > r2 + sum1)
    //             min = Math.min(r1 + sum2, r2 + sum1);
    //     }
    //     return min;
    // }

    // public static int shortestRoad(int[] road1, int[] road2) {
    //     int N = road1.length;
    //     int min = Integer.MAX_VALUE;
        
    //     for (int i = 1; i < N; i++) {
    //         road1[i] += road1[i - 1];
    //         road2[i] += road2[i - 1];
    //     }
    //     min = Math.min(road1[N - 1], road2[N - 1]);
        
    //     for (int i = 1; i < N; i++) {
    //         int cross1 = road1[i - 1] + (road2[N - 1] - road2[i - 1]);
    //         int cross2 = road2[i - 1] + (road1[N - 1] - road1[i - 1]);
    //         min = Math.min(min, Math.min(cross1, cross2));
    //     }

    //     return min;
    // }

    public static int shortestRoad(int[] road1, int[] road2) {
        int n = road1.length;
        int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;
    
        // חישוב סכומים מצטברים
        for (int i = 1; i < n; i++) {
            road1[i] += road1[i - 1];
            road2[i] += road2[i - 1];
        }
    
        // חיפוש הדרך הקצרה ביותר
        for (int i = 0; i < n; i++) {
            int remainA = road1[n - 1] - road1[i];
            int remainB = road2[n - 1] - road2[i];
    
            if (minA > road1[i] + remainB) {
                minA = road1[i] + remainB;
            }
            if (minB > road2[i] + remainA) {
                minB = road2[i] + remainA;
            }
        }
    
        return Math.min(minA, minB);
    }
    
    //endregion

//endregion

//region מבחני 2020

    //region שאלה 1 מבחן 2020א' מועד 85



//    int[][] mat = {
//            { 1,  1, -1,  1,  1},
//            { 1,  0,  0, -1,  1},
//            { 1,  1,  1,  1, -1},
//            { -1, -1,  1,  1,  1},
//            { 1,  1, -1, -1,  1}
//    };


    public static int findMaximum(int[][] mat) {
        if(mat[0][0]==-1){
            return -1;
        }
        return findMaximum(mat, 0, 0, 0);
    }

    public static int findMaximum(int[][] mat, int row, int col, int sum) {
        if (row < 0 || row >= mat.length || col < 0 || col >= mat[0].length || mat[row][col] == -1)
            return sum;
        int temp = mat[row][col];
        mat[row][col] = -1;
        int right = 0, left = 0, down = 0;
        if (row % 2 == 0)
            right = findMaximum(mat, row, col + 1, sum + temp);
        else
            left = findMaximum(mat, row, col - 1, sum + temp);
        down = findMaximum(mat, row + 1, col, sum + temp);
        mat[row][col] = temp;
        return Math.max(right, Math.max(left, down));

    }

    // public static int findMaximum(int[][] mat)
	// {
	// 	if (mat[0][0] == -1)
	// 	{
	// 		return -1;
	// 	}
	// 	return findMaximum(mat, 0, 0, 0);
	// }

	// private static int findMaximum(int[][] mat, int i, int j, int steps)
	// {
	// 	if (i == mat.length || j < 0 || j == mat[i].length || mat[i][j] == -1)
	// 	{
	// 		return steps;
	// 	}
	// 	int r0 = findMaximum(mat, i, (i % 2 == 0) ? j + 1 : j - 1, steps + mat[i][j]);
	// 	int r1 = findMaximum(mat, i + 1, j, steps + +mat[i][j]);

	// 	return Math.max(r0, r1);
	// }


    //endregion

    //region שאלה 2 מבחן 2020א' מועד 85


//    int[] a = {1, 2, 4, 4, 5};
//    int[] a = {1, 3, 2};
//    int[] a = {5, 4, 3, 2, 1};
//    O(n)

    public static int strictlyIncreasing(int[] a) {
        int count = 0, sum = 0;
        for (int i = 1; i < a.length; i++){
            if (a[i+1] > a[i]){
                count++;
                sum+=count;
            }else{
                count = 0;
            }
            
        }
        return sum;
    }

    // binary search - logn
	// sliding window - O(n)

	// public static int strictlyIncreasing(int[] a)
	// {
	// 	int low = 0;
	// 	int high = 1;
	// 	int count = 0;
	// 	while (high < a.length)
	// 	{
	// 		if (a[high] > a[high-1]){
	// 			count += high-low;
	// 			high++;
	// 		}else{
	// 			low = high;
	// 			high++;
	// 		}
	// 	}

	// 	return count;
	// }

    //endregion

    //region  שאלה 1 מבחן 2020א' מועד 87

    //int[][] mat = {
//            {1, 2, 3},
//            {4, 5, 6},
//            {7, 8, 9},
//    };
    // public static int totalWays(int[][] mat, int k) {
    //     return totalWays(mat, k, 0, 0, '0', '0');
    // }

    // public static int totalWays(int[][] mat, int k, int row, int col, char prev, char curr) {
    //     if (prev == 'R' && curr == 'D' || prev == 'D' && curr == 'R')
    //         k--;
    //     if (row < 0 || row >= mat.length || col < 0 || col >= mat[0].length || k < 0)
    //         return 0;
    //     if (row == mat.length - 1 && col == mat[0].length - 1) {
    //         if (k == 0)
    //             return 1;
    //         return 0;
    //     }
    //     int right = totalWays(mat, k, row, col + 1, curr, 'R');
    //     int down = totalWays(mat, k, row + 1, col, curr, 'D');
    //     return right + down;

    // }


    public static int totalWays(int[][] mat, int k) {
        return totalWays(mat, k, 0, 0, 0);
    }

    public static int totalWays(int[][] mat, int k, int i, int j, int lastI) {
        if (i>= mat.length || j>mat[0].length || k < 0){
            return 0;
        }
        if(i==mat.length && j==mat[0].length && k==0){
            return 1;
        }
        if(i==0 && j==0){
            return totalWays(mat,k,i+1,j,i)+ totalWays(mat,k,i,j+1,i);
        }
        if (lastI == i){
            return totalWays(mat, k-1, i+1, j, i) + totalWays(mat, k, i, j+1, i);
        }else{
            return totalWays(mat, k, i+1, j, i) + totalWays(mat, k-1, i, j+1, i);
        }
    }

    //endregion

    //region  שאלה 2 מבחן 2020א' מועד 87


//    int[] a = {1, 2, 3, 4, 5, 7, 8, 9}; O(n^2)

    // public static void printTriplets(int[] a, int num) {
    //     int triple = 0;
    //     for (int i = 0; i < a.length - 2; i++) {
    //         int j = i + 1;
    //         int k = a.length - 1;
    //         while (j < k) {
    //             triple = a[i] * a[j] * a[k];
    //             if (triple == num) {
    //                 System.out.println(a[i] + "\t" + a[j] + "\t" + a[k]);
    //                 break;
    //             } else if (triple < num)
    //                 j++;
    //             else k--;
    //         }
    //     }

    // }

    public static void printTriplets(int[] a, int num) {
        if(a.length<3){
            return;
        }
        int low, high, mul;
        for (int i = 0; i < a.length - 2; i++) {
             low = i + 1;
             high = a.length - 1;
             while (low < high) {
                mul = a[i] * a[low] * a[high];
                if (mul == num && low!=i && high!=i){
                    System.out.println(a[i] + "\t" + a[low] + "\t" +a[high]);
                    break;
                } else if (mul>num){
                    high--;
                } else{
                    low++;
                }
            }
        }
    }

    //endregion


    //region שאלה 1 מבחן 2020ב' מועד 81


//    int[] a = {2, 5, 10, 20, 50};

    // public static int makeSum(int[] lengths, int k, int num) {
    //     return makeSum(lengths, k, num, 0, "");
    // }

    // public static int makeSum(int[] lengths, int k, int num, int index, String str) {
    //     if (k == 0) {
    //         System.out.println(str);
    //         return 1;
    //     }
    //     if (index >= lengths.length || num <= 0 || k < 0)
    //         return 0;
    //     int take = makeSum(lengths, k - lengths[index], num - 1, index, str + lengths[index] + "\t");
    //     int noTake = makeSum(lengths, k, num, index + 1, str);
    //     return take + noTake;
    // }

    // public static int makeSum(int[] lengths, int k, int num) {
    //     return makeSum(lengths, k, num, 0);
    // }

    // public static int makeSum(int[] lengths, int k, int num, int i) {
    //     if (k == 0 && num>=0) {
    //         return 1;
    //         }
    //     if(i==lengths.length){
    //         return 0;
    //     }
    //     if(num < 0){
    //         return 0;
    //     }
    //     return makeSum(lengths, k - lengths[i], num - 1, i) + makeSum(lengths, k, num, i + 1);
    // }
    
    public static int makeSum(int[] lengths, int k, int num) {
        return makeSum(lengths, k, num, 0);
    }
    
    private static int makeSum(int[] lengths, int k, int num, int i) {
        return (k<0|| num<0 || i >= lengths.length && num != 0) ? 0 : (num == 0) ? 1 : 
        makeSum(lengths, k - lengths[i], num - 1, 1) + makeSum(lengths,k,num, i + 1);
    }

    //endregion

    //region שאלה 2 מבחן 2020ב' מועד 81



//    int[] a = {10, 4, 2, 5, 6, 3, 8, 1, 5, 9}; O(n)

    // public static void minimumSubK(int[] arr, int k) {
    //     int start = 0, end = k - 1, min = 0;
    //     for (int i = 0; i < k; i++) {
    //         min += arr[i];
    //     }
    //     int sum = min;
    //     for (int i = k; i < arr.length; i++) {
    //         sum += arr[i];
    //         sum -= arr[i - k];
    //         if (sum < min) {
    //             start = i - k + 1;
    //             end = i;
    //             min = sum;
    //         }
    //     }
    //     System.out.println("Minimum sum sub-array is (" + start + ", " + end + ")");
    // }

    public static void minimumSubK(int[] arr, int k) {
        int start = 0, end = k - 1, sum=0, min = 0, sumMin, i,len=arr.length;
        for(i=0; i<k; i++){
            min+=arr[i];
        }
        sumMin = min;
        for(i=k; i<len; i++){
            sum+=arr[i]-arr[i-k];
            if(sum<sumMin){
                sumMin=sum;
                end=i;
                start=i-k+1;
            }
        }
        System.out.println("Minimum sum sub-array is (" + start + ", " + end + ")");

    }

    // public static void minimumSubK(int[] a, int k){
    //     if (k > a.length){
    //         return;
    //     }
    //     int sum = 0;
    //     for (int i = 0; i < k; i++){
    //         sum += a[i];
    //     }
    //     int minSum = sum;
    //     int leftIndex = 0;
    //     int rightIndex = k - 1;
    //     for (int i = 0; i < a.length - k; i++){
    //         sum -= a[i];
    //         sum += a[i + k];
    //         if (sum < minSum){
    //             minSum = sum;
    //             leftIndex = i + 1;
    //             rightIndex = i + k;
    //         }
    //     }
    //     System.out.println(leftIndex + ", " + rightIndex);
    //     }

    // public static void minimumSubK(int[] arr, int k)
	// {
	// 	int sum = 0;
	// 	for (int i = 0; i < k; i++)
	// 	{
	// 		sum += arr[i];
	// 	}

	// 	int minSum = sum;
	// 	int low = 0;
	// 	int high = k - 1;
	// 	for (int i = 0; i < arr.length - k; i++)
	// 	{
	// 		sum -= arr[i];
	// 		sum += arr[i + k];
	// 		if (sum < minSum)
	// 		{
	// 			low = i + 1;
	// 			high = i + k;
	// 			minSum = sum;
	// 		}
	// 	}

	// 	System.out.println("The sum sub-array is (" + low + ", " + high + ")");

	// }


    //endregion

    //region שאלה 1 מבחן 2020ב' מועד 84

    //    char[][] grid = {
//            {'t', 'z', 'x', 'c', 'd'},
//            {'s', 'h', 'a', 'z', 'x'},
//            {'h', 'w', 'l', 'o', 'm'},
//            {'o', 'r', 'n', 't', 'n'},
//            {'a', 'b', 'r', 'i', 'n'}
//    };
    public static void findWord(char[][] arr, String word) {
        int[][] temp = new int[arr.length][arr[0].length];
        boolean found = findWord(arr, word, temp, 0, 0);
        if (found)
            print2DArray(temp);
        else
            System.out.println("No Such Word");
    }

    public static boolean findWord(char[][] arr, String word, int[][] temp, int row, int col) {
        if (row == arr.length && col == arr[0].length)
            return false;
        if (col == arr[0].length)
            return findWord(arr, word, temp, row + 1, 0);
        if (word(arr, word, temp, row, col, 0, false))
            return true;
        return findWord(arr, word, temp, row, col + 1);
    }

    public static boolean word(char[][] arr, String word, int[][] temp, int row, int col, int index, boolean found) {
        if (found || index == word.length())
            return true;
        if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length || arr[row][col] == '0' || word.charAt(index) != arr[row][col])
            return false;
        char t = arr[row][col];
        arr[row][col] = '0';
        temp[row][col] = index + 1;
        boolean right = word(arr, word, temp, row, col + 1, index + 1, found);
        boolean left = word(arr, word, temp, row, col - 1, index + 1, right);
        boolean down = word(arr, word, temp, row + 1, col, index + 1, left);
        boolean up = word(arr, word, temp, row - 1, col, index + 1, down);
        if (!up)
            temp[row][col] = 0;
        arr[row][col] = t;
        return right || left || down || up;
    }

    // public static void findWord(char[][] arr, String word) {
    //     int[][] mat = new int[arr.length][arr[0].length];
    //     findIndex(arr, word, 0, 0, mat);
    // }

    // private static void findIndex(char[][] arr, String word, int i, int j, int[][] mat) {
    //     if (j >= arr.length) {
    //         i += 1;
    //         j = 0;
    //     }
    //     if (i == mat.length) {
    //         System.out.println("No such word");
    //         return;
    //     }
    //     if (findWord(arr, word, i, j, mat, 0)) {
    //         return;
    //     }
    //     findIndex(arr, word, i, j + 1, mat);
    // }

    // public static boolean findWord(char[][] arr, String word, int i, int j, int[][] mat, int charIndex) {
    //     if (charIndex == word.length()) {
    //         printNumberedIndices(mat);
    //         return true;
    //     }
    //     if (i >= mat.length || i < 0 || j >= mat[0].length || j < 0 || word.charAt(charIndex) != arr[i][j] || mat[i][j] != 0)
    //         return false;
    //     mat[i][j] = charIndex + 1;
    //     boolean rightLeft = findWord(arr, word, i, j + 1, mat, charIndex + 1) || findWord(arr, word, i, j - 1, mat, charIndex + 1) ||
    //             findWord(arr, word, i - 1, j, mat, charIndex + 1) || findWord(arr, word, i + 1, j, mat, charIndex + 1);
    //     mat[i][j] = 0;
    //     return rightLeft;
    // }

    //endregion
//------------------------------------------------------------------------------------------------------------------ 
    // private static boolean findWord(char[][] arr, String word, int i, int j, int[][] pathMat,int wordIndex){
    //     if (wordIndex == word.length()){
    //         return true;
    //     }
    //     if (i < 0 || i >= arr.length || j < 0 || j >= arr[i].length || pathMat[i][j] > 0 || arr[i][j] != word.charAt(wordIndex)){
    //         return false;
    //     }

    //     pathMat[i][j] = wordIndex + 1;
    //     if (!findWord(arr, word, i + 1, j, pathMat, wordIndex + 1)){
    //         if(!findWord(arr, word, i - 1, j, pathMat, wordIndex + 1)){
    //             if (!findWord(arr, word, i, j + 1, pathMat, wordIndex + 1)){
    //                 if (!findWord(arr, word, i, j - 1, pathMat, wordIndex + 1)){
    //                     pathMat[i][j] = 0;  
    //                     return false;
    //                 }    
    //             }
    //         }
    //     }
    // }


    // private static boolean findWord(char[][] arr, String word, int i, int j, int[][] pathMat){
    //     if (i == arr.length){
    //         return false;
    //     }
    //     if (j == arr[i].length){
    //         return findWord(arr, word, i + 1, 0, pathMat);
    //     }
    //     if (findWord(arr, word, i, j+1, pathMat)){
    //         printArr(pathMat);
    //         return true;
    //     }
    //     return findWord(arr, word, i, j + 1, pathMat);
    // }

    // private static void printArr(int[][] pathMat){
    //     for (int i = 0; i < pathMat.length; i++){
    //         for (int j = 0; j < pathMat[i].length; j++){
    //             System.out.print(pathMat[i][j]);
    //         }
    //         System.out.println();
    //     }
    // }
// --------------------------------------------------------------------------------------------------------------------------------

    //region שאלה 2 מבחן 2020ב' מועד 84
    // binary search

    public static void findFactors(int n) {
        int low = 1, high = n, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (n % mid == 0)
                break;
            else if (isHighFactorInRange(n, low, mid))
                high = mid - 1;
            else if (isHighFactorInRange(n, mid, high)) {
                low = mid + 1;
            }
        }
        System.out.println(n / mid + " * " + mid + " = " + n);
    }

    //endregion

    // public static boolean isHighFactorInRange(int n, int low, int high) {
    //     // Check each integer within the range [low, high]
    //     for (int i = high; i >= low; i--) {
    //         // Skip 1 because it's not considered a "high factor"
    //         if (n % i == 0) {
    //             return true; // A divisor is found within the range
    //         }
    //     }
    //     return false; // No divisor found in the range
    // }

    // public static void findFactors(int n) {
    //     int low = 1;
    //     int high = n - 1;
    //     int mid = high / 2;
    //     while (low < high) {
    //         if (isHighFactorInRange(n, mid + 1, high)) {
    //             low = mid + 1;
    //         } else if (isHighFactorInRange(n, low, mid)) {
    //             high = mid;
    //         }
    //         mid = (high + low) / 2;
    //     }
    //     System.out.println(mid + " * " + (n / mid) + " = " + n);
    // }

    //region שאלה 1 מבחן 2020ב' מועד 96


//    int[][] mat = {
//            {4, 5, 6, 7, 1},
//            {3, 5, 1, 7, 4},
//            {4, 5, 6, 5, 8},
//            {3, 4, 7, 7, 9},
//            {6, 2, 2, 7, 6}
//    };

    public static int maxSumKnight(int[][] mat) {
        return maxSumKnight(mat, 0, 0, mat[0][0], 0);
    }

    public static int maxSumKnight(int[][] mat, int row, int col, int prev, int sum) {
        if (row < 0 || row >= mat.length || col < 0 || col >= mat[0].length || mat[row][col] == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        int temp = mat[row][col];
        if (Math.abs(temp - prev) > 1)
            return Integer.MIN_VALUE;
        if (row == mat.length - 1 && col == mat[0].length - 1)
            return sum + temp;
        mat[row][col] = Integer.MIN_VALUE;
        int upRight = maxSumKnight(mat, row - 2, col + 1, temp, sum + temp);
        int rightUp = maxSumKnight(mat, row - 1, col + 2, temp, sum + temp);
        int rightDown = maxSumKnight(mat, row + 1, col + 2, temp, sum + temp);
        int downRight = maxSumKnight(mat, row + 2, col + 1, temp, sum + temp);
        int downLeft = maxSumKnight(mat, row + 2, col - 1, temp, sum + temp);
        int leftDown = maxSumKnight(mat, row + 1, col - 2, temp, sum + temp);
        int leftUp = maxSumKnight(mat, row - 1, col - 2, temp, sum + temp);
        int upLeft = maxSumKnight(mat, row - 2, col - 1, temp, sum + temp);
        int[] arr = {upRight, rightUp, rightDown, downRight, downLeft, leftDown, leftUp, upLeft};
        mat[row][col] = temp;
        return getMax(arr);
    }
    //endregion

    //region שאלה 2 מבחן 2020ב' מועד 96


//    Range A = new Range(-7, -3);
//    Range B = new Range(-1, -1);
//    Range C = new Range(4, 6);
//    Range D = new Range(20, 22);
//
//    Range[] rangeA = {A, B, C, D}; O(log n)
    
    public static int minimalPositive(Range[] rangeA) {
        int low = 0, high = rangeA.length - 1, mid, min = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (rangeA[mid].getSmall() <= 0 && rangeA[mid].getBig() > 0)
                return 1;
            else if (rangeA[mid].getSmall() > 0) {
                min = rangeA[mid].getSmall();
                high = mid - 1;
            } else if (rangeA[mid].getBig() <= 0) {
                low = mid + 1;
            } else high = mid - 1;
        }
        return min;
    }

    // public static int minimalPositive(Range[] rangeA) {
    //     int low=0, high = rangeA.length - 1, mid;
    //     while (low <= high) {
    //         mid = (low + high) / 2;
    //         if (rangeA[mid].getBig <=0){
    //             low=mid+1;
    //             }else{
    //                 high=mid;
    //             }
    //             int numSmall=rangeA[high].getSmall();
    //             int numBig=rangeA[high].getBig();
    //             if(numBig<=0){
    //                 return -1;
    //             }
    //             if(numSmall<=0){
    //                 return 1;
    //             }
    //             return numSmall;
    //         }
    //     }




    //endregion

//endregion

//region מבחני 2021


    //region שאלה 1 מבחן 2021א' מועד 85
//    int[][] mat = {
//            {0, 15, 80, 90},
//            {-1, 0, 40, 50},
//            {-1, -1, 0, 70},
//            {-1, -1, -1, 0}
//    };

    public static int minPrice(int[][] mat) {
        return minPrice(mat, 0, 0, 0);
    }

    // public static int minPrice(int[][] mat, int row, int col, int price) {
    //     if (col == mat[0].length - 1)
    //         return price + mat[row][col];
    //     if (row >= mat.length || mat[row][col] == -1)
    //         return Integer.MAX_VALUE;
    //     int take = minPrice(mat, row + 1, col, price + mat[row][col]);
    //     int noTake = minPrice(mat, row, col + 1, price);
    //     return Math.min(take, noTake);
    // }

    public static int minPrice(int[][] mat, int row, int col, int price) {
        if (col == mat[0].length - 1)
            return price + mat[row][col];
        if (col==row){
            return minPrice(mat, row, col+1, price);
        }
        return Math.min(minPrice(mat, col, col, price + mat[row][col]),minPrice(mat, row, col+1, price));
    }

    //endregion

    //region שאלה 2 מבחן 2021א' מועד 85

//    int[] a = {2, 3, 8, 14, 15, 35}; O(n)

    // public static boolean findAverage(int[] arr, double x) {
    //     int from = 0, to = arr.length - 1, sum = 0, count = arr.length;
    //     double average = 0;
    //     for (int i = 0; i < arr.length; i++) {
    //         sum += arr[i];
    //     }
    //     while (from <= to) {
    //         count = to - from + 1;
    //         average = (double) sum / count;
    //         if (average == x) {
    //             System.out.println(from + " ---> " + to);
    //             return true;
    //         } else if (average < x) {
    //             sum -= arr[from];
    //             from++;
    //         } else {
    //             sum -= arr[to];
    //             to--;
    //         }
    //     }
    //     return false;
    // }

    // public static boolean findAverage(int[] arr, double x) {
    //     int i;
    //     for (i = 0; i < arr.length && arr[i]<x; i++) {
    //         int right=i;
    //         int left=i;
    //         double sum = arr[i];
    //         double avg;
    //         int len = arr.length;
    //         while(left>=0 && right<len){
    //             avg=sum/(right-left+1);
    //             if(avg>x){
    //                 left--;
    //                 if(left>=0)
    //                     sum+=arr[left];
    //             }else if(avg<x){
    //                 right++;
    //                 if(right<len)
    //                     sum+=arr[right];
    //             } else {
    //                 System.out.println(left+"---"+right);
    //                 return true;
    //             }

    //         }
    //     }
    //     return false;
    // }

    public static boolean findAverage(int[] arr, double x) {
        double sum =0;
        for(int i=0; i<arr.length-1; i++){
            sum+=arr[i];
        }
        double avg = sum / arr.length;
        int i=0, j=arr.length-1, len=arr.length;
            while(i <= j){
                if(avg == x){
                    System.out.println(i+ " -- " + j + " avg " + x);
                    return true;
                }
                if(avg < x){
                    sum-=arr[i];
                    i++;
                    len--;
                    }else{
                        sum+=arr[j];
                        j--;
                        len--;
                    }
                    avg = sum/len;
            }
            return false;
        }


                // public static boolean findAverage(int[] arr, double x)
        // {
        //     int sum = 0;
        //     for (int i = 0; i < arr.length; i++)
        //     {
        //         sum += arr[i];
        //     }
    
        //     int low = 0;
        //     int high = arr.length - 1;
    
        //     while (low <= high)
        //     {
        //         double avg = sum / (high - low + 1.0);
        //         if (x == avg)
        //         {
        //             return true;
        //         }
        //         if (avg < x)
        //         {
        //             sum -= arr[low];
        //             low++;
        //         }
        //         else
        //         {
        //             sum -= arr[high];
        //             high--;
        //         }
        //     }
    
        //     return false;
        // }


    //endregion

    //region שאלה 1 מבחן 2021ב' מועד 60


//    int[] arr = {8, 4, 7, 1, 2, 3, 5};
//    int[] arr2 = {4, 7, 1, 2, 3, 5};

    public static boolean split3(int[] arr) {
        return split3(arr, 0, 0, 0, 0);
    }

    public static boolean split3(int[] arr, int index, int sum1, int sum2, int sum3) {
        if (index == arr.length && sum1 == sum2 && sum2 == sum3)
            return true;
        if (index >= arr.length)
            return false;
        return split3(arr, index + 1, sum1 + arr[index], sum2, sum3) ||
                split3(arr, index + 1, sum1, sum2 + arr[index], sum3) ||
                split3(arr, index + 1, sum1, sum2, sum3 + arr[index]);
    }
    

    //endregion

    //region שאלה 2 מבחן 2021ב' מועד 60

//    int[] a = {1, 4, 13, 6, 0, 19};
//    O(n)

    // public static int smallestSub(int[] a, int k) {
    //     int start = 0, end = 0, startF = 0, endF = 0, sum = 0, len = 0, minLen = a.length + 1;
    //     while (end < a.length) {
    //         sum += a[end];
    //         while (sum > k && start <= end) {
    //             len = end - start + 1;
    //             if (len < minLen) {
    //                 minLen = len;
    //                 startF = start;
    //                 endF = end;
    //             }
    //             sum -= a[start];
    //             start++;
    //         }
    //         end++;
    //     }
    //     return minLen;
    // }

    public static int smallestSub(int[] a, int k) {
        int start = 0, end = 0, sum =0, len=a.length, minLen = len+1;
        while(end<len){
            while(sum<=k && end<len){
                sum+=a[end];
                end++;
            }
            while(sum>k && start<end){
                minLen= Math.min(minLen,end-start);
                sum-=a[start];
                start++;
                }
            }
            return minLen;
        }

    //endregion

    //region שאלה 1 מבחן 2021ב' מועד 62


//    int[] arr1 = {-3, 5, 12, 14, -9, 13};
//    int[] arr2 = {-3, 5, -12, 14, -9, 13};
//    int[] arr3 = {-3, 5, -12, 14, -9};

    // public static boolean equalSplit(int[] arr) {
    //     return equalSplit(arr, 0, 0, 0, 0, 0);
    // }

    // public static boolean equalSplit(int[] arr, int index, int count1, int sum1, int count2, int sum2) {
    //     if (index == arr.length && count1 == count2 && sum1 == sum2)
    //         return true;
    //     if (index >= arr.length)
    //         return false;
    //     return equalSplit(arr, index + 1, count1 + 1, sum1 + arr[index], count2, sum2) ||
    //             equalSplit(arr, index + 1, count1, sum1, count2 + 1, sum2 + arr[index]);
    // }
        
    public static boolean equalSplit(int[ ] arr){
        return equalSplit(arr, 0, 0, 0, 0,0);
    }

    public static boolean equalSplit(int[] arr, int i, int sum1, int sum2, int size1, int size2){
    if (i == arr.length) {
        return sum1 == sum2 && size1 == size2;
    }
    return equalSplit(arr, i+1, sum1+arr[i], sum2, size1+1, size2) || equalSplit(arr, i+1, sum1, sum2+arr[i], size1, size2+1);
    }



    //endregion

    //region שאלה 2 מבחן 2021ב' מועד 62


    //    int[][] mat = {
//            {1, 3, 7, 9},
//            {6, 4, 15, 11},
//            {36, 50, 21, 22},
//            {60, 55, 30, 26}
//    };
//  O(log n)
    public static boolean search(int[][] mat, int num) {
        int row = 0, col = 0, n = mat.length;
        while (n > 1) {
            if (num <= mat[row + n / 2 - 1][col]) {
                row = row;
                col = col;
            } else if (num <= mat[row + n / 2 - 1][col + n / 2]) {
                col += n / 2;
            } else if (num <= mat[row + n - 1][col + n / 2]) {
                row += n / 2;
                col += n / 2;
            } else if (num <= mat[row + n - 1][col]) {
                row += n / 2;
            }
            if (num == mat[row][col]) {
                System.out.println("row = " + row);
                System.out.println("col = " + col);
                return true;
            }
            n /= 2;
        }
        return false;
    }

    // public static boolean search(int[][] mat, int num) {
    //     int len = mat.length;
    //     int row=len-1;
    //     int col=0;
    //     int value=num-1;//מייצג את הרביע
    //     int quarter1, quarter2, quarter3, quarter4; 
    //     int halfSize= len/2;
    //     if(row==0){
    //       if(num==mat[row][col]){
    //         System.out.println("row = " + row + "col = " + col);
    //         return true;
    //       }
    //       return false;  
    //     }
    //     while(num!=value && halfSize>0){
    //         quarter1=mat[row-halfSize][col];
    //         quarter2=mat[row-halfSize][col+halfSize];
    //         quarter3=mat[row][col+halfSize];
    //         quarter4=mat[row][col];
    //         if(quarter1>=num){
    //             value=quarter1;
    //             row-=halfSize;
    //         }else if (quarter2>=num){
    //             value=quarter2;
    //             row-=halfSize;
    //             col+=halfSize;
    //         }else if(quarter3>=num){
    //             value=quarter3;
    //             col+=halfSize;
    //         }else if (quarter4>=num){
    //             value=quarter4;
    //         }else{
    //             return false;
    //         }
    //         halfSize/=2;
    //     }
    //     if(num==value){
    //         System.out.println("row = " + row + "col = " + col);
    //         return true;
    //     }
    //     return false;
    // }


     // public static boolean search(int[][] mat, int num) {
    //     int startI = 0, startJ = 0, endI = mat.length - 1, endJ = mat[0].length - 1;
    //     while (!(startI == endI && startJ == endJ)) {
    //         if (num >= mat[startI][startJ] && num <= mat[(endI + startI) / 2][startJ]) {
    //             endI = (endI + startI) / 2;
    //             endJ = (endJ + startJ) / 2;
    //         } else if (num >= mat[startI][(endJ + startJ) / 2 + 1] && num <= mat[(endI + startI) / 2][(endJ + startJ) / 2 + 1]) {
    //             startJ = (endJ + startJ) / 2 + 1;
    //             endI = (endI + startI) / 2;
    //         } else if (num >= mat[(endI + startI) / 2 + 1][(endJ + startJ) / 2 + 1] && num <= mat[endI][(endJ + startJ) / 2 + 1]) {
    //             startI = (endI + startI) / 2 + 1;
    //             startJ = (endJ + startJ) / 2 + 1;
    //         } else if (num >= mat[(endI + startI) / 2 + 1][startJ] && num <= mat[endI][startJ]) {
    //             startI = (endI + startI) / 2 + 1;
    //             endJ = (endJ + startJ) / 2;
    //         } else
    //             return false;
    //     }
    //     System.out.println("row = " + startI + "\n" + "col = " + startJ);
    //     return true;
    // }


    //endregion

    //region שאלה 1 מבחן 2021ב' מועד 92


//    int[] arr = {1, 3, 6, 2};

    public static int printExpr(int[] arr, int num) {
        return printExpr(arr, num, 0, 0, "");
    }

    public static int printExpr(int[] arr, int num, int index, int sum, String str) {
        if (sum == num) {
            System.out.println(str + " = " + num);
            return 1;
        }
        if (index >= arr.length)
            return 0;
        int takePlus = printExpr(arr, num, index + 1, sum + arr[index], " + " + arr[index] + str);
        int taleMinus = printExpr(arr, num, index + 1, sum - arr[index], " - " + arr[index] + str);
        int noTake = printExpr(arr, num, index + 1, sum, str);
        return takePlus + taleMinus + noTake;
    }


    //endregion

    //region שאלה 2 מבחן 2021ב' מועד 92


//    int[] a = {1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0};

    public static int longestSequence(int[] a, int k) {
        int start = 0, end = 0, len = 0, maxLen = 0, zeros = 0;
        while (end < a.length) {
            if (a[end] == 0)
                zeros++;
            len = end - start + 1;
            if (maxLen < len && zeros <= k)
                maxLen = len;
            while (zeros > k && start <= end) {
                if (a[start] == 0)
                    zeros--;
                start++;
            }
            end++;
        }
        return maxLen;
    }

    //endregion

//endregion

//region מבחני 2022


    //region שאלה 1 מבחן 2022א' מועד 67


    //    int[][] mat = {
//            {1, 2, 3, 2, 0, 1, 2},
//            {0, 1, 0, 0, 0, 3, 0},
//            {0, 0, 1, 0, 0, 0, 0},
//            {5, 0, 0, 1, 0, 0, 0},
//            {7, 0, 0, 0, 1, 0, 0},
//            {8, 0, 0, 0, 0, 1, 0},
//            {1, 0, 0, 0, 0, 0, 0}
//    };

    // public static boolean isIdentity(int[][] mat, int x, int size) {
    //     return isIdentity(mat, x + size, x, x);
    // }

    // public static boolean isIdentity(int[][] mat, int size, int row, int col) {
    //     if (row >= size || col >= size)
    //         return true;
    //     if (row == col && mat[row][col] != 1 || row != col && mat[row][col] != 0)
    //         return false;
    //     if (col == size - 1)
    //         return isIdentity(mat, size, row + 1, 0);
    //     return isIdentity(mat, size, row, col + 1);
    // }

    // public static int maxMatrix(int[][] mat) {
    //     return maxMatrix(mat, 0, mat.length);
    // }

    // public static int maxMatrix(int[][] mat, int x, int size) {
    //     if (size < 0)
    //         return 0;
    //     if (isIdentity(mat, x, size))
    //         return x;
    //     return maxMatrix(mat, x + 1, size - 2);
    // }

    public static boolean isIdentity(int[][] mat, int x, int size) {
        return isIdentity(mat, x , size, x, x);
    }

    public static boolean isIdentity(int[][] mat,int x, int size, int i, int j) {
        if(i==j){
           if(mat[i][j]==1){
            return isIdentity(mat, x, size,i+1,j) && isIdentity(mat, x, size,i,j+1);
           }else{
            return false;
           }
        }
        if(i== x+size && j == x+size){
            return true;
        }
        if(mat[i][j]==0){
            return isIdentity(mat, x, size,i+1,j) && isIdentity(mat, x, size,i,j+1);
        } else{
            return false;
        }
    }

    public static int maxMatrix(int[][] mat) {
        return maxMatrix(mat, 0, mat.length);
    }

    private static int maxMatrix(int[][] mat, int start, int size){
        if(size<=0){
            return 0;
        }
        if(isIdentity(mat,start,size)){
            return size;
        }
        return maxMatrix(mat, start + 1, size - 2);
    }


    //endregion

    //region שאלה 2 מבחן 2022א' מועד 67



//    int[] a1 = {22, 24, 26, 32, 34, 36, 38, 40};
//    int[] a2 = {22, 26, 28};
//    int[] a3 = {2, 4, 6, 8, 10};
//    O(log n)

    // public static int findMissingIndex(int[] a) {
    //     int jump = Math.min(Math.abs(a[1] - a[0]), Math.abs(a[a.length - 1] - a[a.length - 2]));
    //     if (a[1] < a[0])
    //         jump = -jump;
    //     int low = 0, high = a.length - 1, mid = 0, miss = a.length;
    //     while (low <= high) {
    //         mid = (low + high) / 2;
    //         if (a[mid] != a[0] + jump * mid) {
    //             high = mid - 1;
    //             miss = mid;
    //         } else if (a[mid] == a[0] + jump * mid) {
    //             low = mid + 1;
    //         }
    //     }
    //     return miss;
    // }

    public static int findMissingIndex(int[] a) {
        int low=0, high=a.length-1, mid;
        int diff=Math.min(a[1]-a[0],a[2]-a[1]);
        while(low<high-1){
            mid=(low+high)/2;
            if(a[low]+diff*(mid-low)!=a[mid]){
                high=mid;
        }else if(a[mid]+diff*(high-mid)!=a[high]){
            low=mid;
        }else{
            return a.length;
            }
        }
        return high;
    }

    // public static int findMissingIndex(int[] a) {
    //     int low = 0;
    //     int high = a.length - 1;
    //     int mid = (low + high) / 2;
    //     int jump = Math.min(a[a.length - 1] - a[a.length - 2], a[1] - a[0]);
    //     while (low <= high) {
    //         if (a[mid] > a[low] + jump * (mid - low)) {
    //             high = mid;
    //         } else {
    //             low = mid + 1;
    //         }
    //         mid = (low + high) / 2;
    //         if (mid >= 1 && a[mid] - a[mid - 1] > jump) {
    //             return mid;
    //         }
    //     }
    //     return a.length;
    // }

    //endregion

    //region שאלה 1 מבחן 2022א' מועד 87


//    String str1 = "adbrcfa";
//    String str2 = "abc";
//    String str12 = "cbdadbrcfa";
//    String str13 = "adcfbaagcxabcd";
//    String str14 = "abcfbaagcxabcd";

    public static boolean isJump(String str1, String str2, int step) {
        if (str2.length() == 0)
            return true;
        if (str1.length() < str2.length() || str1.charAt(0) != str2.charAt(0) || step > str1.length())
            return false;
        return isJump(str1.substring(step), str2.substring(1), step);
    }

    public static int strStep(String str1, String str2) {
        return strStep(str1, str2, 1);
    }

    public static int strStep(String str1, String str2, int step) {
        if (step > str1.length())
            return -1;
        if (isJump(str1, str2, step))
            return step;
        return strStep(str1, str2, step + 1);
    }

    //endregion

    //region שאלה 2 מבחן 2022א' מועד 87


//    int[] a1 = {-1, 1, -1, -5, 2, 2};
//    int[] a2 = {3, 3, 2, -7, 2, 1, 1, -2, -2};
//    int[] a3 = {1, 2, 3, 4, 5, 4};
//    int[] a4 = {1, -2, 3, -4, -5, 4, 2, -4, 6, -2};
//    O(n)

    // public static int longestSubarray(int[] a) {
    //     int start = 0, end = 1, startF = 0, endF = 0, sequence = 1, maxSequence = 1, prev = a[0];
    //     while (end < a.length) {
    //         if (a[end] * prev < 0)
    //             sequence++;
    //         else {
    //             sequence = 1;
    //             while (start < end)
    //                 start++;
    //         }
    //         if (sequence > maxSequence) {
    //             maxSequence = sequence;
    //             startF = start;
    //             endF = end;
    //         }
    //         prev = a[end];
    //         end++;
    //     }
    //     System.out.println("Starting index = " + startF + " Ending index = " + endF);
    //     return maxSequence;
    // }

    public static int longestSubarray(int[] a) {
        int start = 0, end = 0, startMax = 0, endMax=0, arrMax = Integer.MIN_VALUE;
        boolean positive;
            if(a[0]>0){
                positive=true;
            }else{
                positive=false;
            }
            while (end < a.length-1){
                if(a[end]>0 && positive || a[end]<0 && !positive){
                    end++;
                }else{
                    if(arrMax<end-start){
                        arrMax=end-start;
                        startMax=start;
                        endMax=end;
                    }
                    start=end;
                }
                positive=!positive;
            }
            if(arrMax<end-start){
                System.out.println("Starting index = " + start + " Ending index = " + (end-1));
                return end-start;
        }
        System.out.println("Starting index = " + startMax + " Ending index = " + (endMax-1));
        return arrMax;
    }

    // public static boolean Subarray(int[] arr, int num) {
    //     int sum = 0, i = 0, j = 0;
    //     while (j < arr.length) {
    //         if (sum < num) {
    //             sum += arr[j];
    //             j++;
    //         } else if (sum > num) {
    //             sum -= arr[i];
    //             i++;
    //         }
    //         if (sum == num) {
    //             System.out.println("Subarray found [" + i + "-" + (j - 1) + "]");
    //             return true;
    //         }
    //     }
    //     System.out.println("No subarray exists");
    //     return false;
    // }

    //endregion

    //region שאלה 1 מבחן 2022א' מועד 94

//    char[][] mat = {
//            {'a', 'c', 'b', 'c', '@', 'a'},
//            {'b', 'x', 'z', 'c', 's', 'a'},
//            {'?', 'c', 'd', '*', 'c', 'd'},
//            {'b', 'c', 'a', '8', 'b', 'b'},
//            {'c', '2', 'x', '+', 'b', 'c'}
//    };

    //    char[][] mat = {
//            {'a', 'd', 'e', 's', '@', 'a'},
//            {'3', 'a', 'z', 'a', 's', 'a'},
//            {'?', 'c', 'b', 'b', 'c', 'd'},
//            {'b', 'c', 'a', '8', 'b', 'b'},
//            {'c', '2', 'x', '+', 'b', 'c'}
//    };
    public static int lengthPath(char[][] mat, String pattern) {
        return lengthPath(mat, pattern, 0, 0);
    }

    public static int lengthPath(char[][] mat, String pattern, int row, int col) {
        if (row < 0 || row >= mat.length || col < 0 || col >= mat[0].length || mat[row][col] == '0' ||
                !isInPattern(mat[row][col], pattern))
            return 0;
        char temp = mat[row][col];
        mat[row][col] = '0';
        int right = 1 + lengthPath(mat, pattern, row, col + 1);
        int left = 1 + lengthPath(mat, pattern, row, col - 1);
        int down = 1 + lengthPath(mat, pattern, row + 1, col);
        int up = 1 + lengthPath(mat, pattern, row - 1, col);
        mat[row][col] = temp;
        int[] arr = {right, left, down, up};
        return getMax(arr);
    }

    public static boolean isInPattern(char c, String pattern) {
        if (pattern.indexOf(c) >= 0)
            return true;
        return false;
    }

    public static int maxPath(char[][] mat, String pattern) {
        return maxPath(mat, pattern, 0, 0, 0);
    }

    public static int maxPath(char[][] mat, String pattern, int max, int row, int col) {
        if (row == mat.length)
            return max;
        int temp = lengthPath(mat, pattern, row, col);
        if (temp > max)
            max = temp;
        if (col == mat[0].length - 1)
            return maxPath(mat, pattern, max, row + 1, 0);
        return maxPath(mat, pattern, max, row, col + 1);
    }


    //endregion

    //region שאלה 2 מבחן 2022א' מועד 94


    int[] a1 = {2, 4, 5, 3, 5, 1};
    int[] a2 = {1, 1, 1, 2, 2, 2, 2};

    // public static int findDuplicate(int[] a) {
    //     int temp1 = 0, temp2 = 0;
    //     while (a[temp1] != a[a[temp1]]) {
    //         temp2 = a[temp1];
    //         a[temp1] = a[temp2];
    //         a[temp2] = temp2;
    //     }
    //     return a[temp1];
    // }

    // public static int findDuplicate(int[] a) {
    //     int i = 0;
    //     while (i < a.length) {
    //         if (a[i] != i + 1) {
    //             if (a[a[i] - 1] == a[i]) {
    //                 return a[i];
    //             }
    //             int temp = a[i];
    //             a[i] = a[temp - 1];
    //             a[temp - 1] = temp;
    //         } else {
    //             i++;
    //         }
    //     }
    //     return -1;
    // }

    public static int findDuplicate(int[] a)
	{
		while (a[a[0]] != a[0])
		{
			int temp = a[a[0]];
			a[a[0]] = a[0];
			a[0] = temp;
		}

		return a[0];
	}

    //endregion

    //region שאלה 1 מבחן 2022ב' מועד 86


//    int[][] mat = {
//            {12, 22, 23, 54, 11},
//            {43, 35, 21, 20, 30},
//            {34, 23, 43, 22, 30},
//            {25, 31, 2, 20, 34},
//            {10, 22, 10, 11, 10},
//            {40, 13, 3, 1, 23}
//    };

    public static int maxPath(int[][] mat) {
        return maxPath(mat, 0, 0, 0);
    }

    public static int maxPath(int[][] mat, int row, int col, int sum) {
        if (row >= mat.length || col >= mat[0].length)
            return Integer.MIN_VALUE;
        if (row == mat.length - 1 && col == mat[0].length - 1)
            return sum + mat[row][col];
        int current = mat[row][col];
        int opt1 = maxPath(mat, row + current / 10, col + current % 10, sum + current);
        int opt2 = maxPath(mat, row + current % 10, col + current / 10, sum + current);
        return Math.max(opt1, opt2);
    }
    //endregion

    //region שאלה 2 מבחן 2022ב' מועד 86
    // O(Kn)


    public static void sortmod(int[] a, int k) {
        int temp;
        int ptr = 0;
        for (int i = 0; i < k; i++) {
            for (int j = ptr; j < a.length; j++) {
                if (a[j] % k == i) {
                    temp = a[ptr];
                    a[ptr] = a[j];
                    a[j] = temp;
                    ptr++;
                }
            }
        }
    }

    //endregion

    //region שאלה 1 מבחן 2022ב' מועד 91


//    int[] stations = {2, 4, 8, 3, 10, 1, 12, 3, 2};

    public static int cheapRt(int[] stations, int step1, int step2, int limit) {
        return cheapRt(stations, step1, step2, limit, 0, 0, "");
    }

    public static int cheapRt(int[] stations, int step1, int step2, int limit, int index, int sum, String str) {
        if (index == stations.length - 1 && limit>=0) {
            System.out.println(str + index + " = " + (sum + stations[index]));
            return sum + stations[index];
        }
        if (index >= stations.length || limit < 0)
            return Integer.MAX_VALUE;
        int stp1 = cheapRt(stations, step1, step2, limit, index + step1, sum + stations[index], str +" "+ index + "\t");
        int stp2 = cheapRt(stations, step1, step2, limit - 1, index + step2, sum + stations[index], str +" "+ index + "\t");
        return Math.min(stp1, stp2);
    }
    //endregion

    //region שאלה 2 מבחן 2022ב' מועד 91


//    int[] arr = {-4, 1, -8, 9, 6};
// O(n)

    public static int findTriplet(int[] arr) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int num=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        int product1 = max1 * max2 * max3;
        int product2 = max1 * min1 * min2;
        if (product1 > product2) {
            System.out.println(max1 + " " + max2 + " " + max3);
            return product1;
        }
        System.out.println(max1 + " " + min1 + " " + min2);
        return product2;
    }

    // public static int findTriplet(int[] arr) {
    //     int smallest = 0, smallest_2 = 0, biggest = 0, biggest_2 = 0, biggest_3 = 0;
    //     for (int i = 0; i < arr.length; i++) {
    //         smallest_2 = arr[i] <= smallest ? smallest : Math.min(arr[i], smallest_2);
    //         smallest = Math.min(arr[i], smallest);
    //         biggest_3 = arr[i] >= biggest ? biggest_2 : arr[i] >= biggest_2 ? biggest_2 : Math.max(arr[i], biggest_3);
    //         biggest_2 = arr[i] >= biggest ? biggest : Math.max(biggest_2, arr[i]);
    //         biggest = Math.max(arr[i], biggest);
    //     }
    //     if (biggest * biggest_2 * biggest_3 > smallest * smallest_2 * biggest) {
    //         System.out.println(biggest + " " + biggest_2 + " " + biggest_3);
    //         return biggest * biggest_2 * biggest_3;
    //     }
    //     System.out.println(biggest + " " + smallest_2 + " " + smallest);
    //     return smallest * smallest_2 * biggest;
    // }

    //endregion

    //region שאלה 1 מבחן 2022ב' מועד 96


    public static int calc(int num, int res, int maxOp) {
        return calc(num, res, maxOp, 3, num + "");
    }

    public static int calc(int num, int res, int maxOp, int target, String str) {
        if (target == res) {
            System.out.println(str + " = " + target);
            return 1;
        }
        if (maxOp == 0)
            return 0;
        int plus = calc(num, res, maxOp - 1, target + num, str + " + " + num);
        int minus = calc(num, res, maxOp - 1, target - num, str + " - " + num);
        int multiplication = calc(num, res, maxOp - 1, target * num, str + " * " + num);
        int division = calc(num, res, maxOp - 1, target / num, str + " / " + num);
        return plus + minus + multiplication + division;
    }

    //endregion

    //region שאלה 2 מבחן 2022ב' מועד 96


    //    int[] a = {3, 0, 0, 4, 7, 9, 0, 0, 0, 0, 11, 15, 0, 19, 20, 0, 0, 31, 40, 0};
    //    O(log n)
    // public static int kAlmostSearch(int[] a, int num) {
    //     int low = 0, high = a.length - 1, mid, left, right;
    //     while (low <= high) {
    //         mid = (low + high) / 2;
    //         if (a[mid] == 0) {
    //             left = mid;
    //             right = mid;
    //             while (a[left] == 0 && left > 0)
    //                 left--;
    //             while (a[right] == 0 && right < a.length)
    //                 right++;
    //             if (a[right] == num)
    //                 return right;
    //             else if (a[right] < num) {
    //                 low = right + 1;
    //             } else if (a[left] == num)
    //                 return left;
    //             else if (a[left] > num) {
    //                 high = left - 1;
    //             } else low = right + 1;
    //         } else if (a[mid] == num) {
    //             return mid;
    //         } else if (a[mid] < num) {
    //             low = mid + 1;
    //         } else high = mid - 1;
    //     }
    //     return -1;
    // }

    public static int kAlmostSearch(int[] a, int num) {
        int low=0, high=a.length-1, mid, value,left,right;
        while (low<=high) {
            mid=(low+high)/2;
            value=a[mid];
            if (value==0){
                left=mid-1;
                right=mid+1;
                while (left>=low || right<=high) {
                    if(a[right]!=0 && right<=high){ 
                        mid=right;
                        value=a[mid];
                        break;
                    }
                    if(a[left]!=0 && left>=low){
                        mid=left;
                        value=a[mid];
                        break;
                    }
                    left--;
                    right++;
                }
                if (value==0){
                    return -1;
                }
            }
            if (value==num) {
                return mid;
            } else if (value < num) {
                low = mid + 1;
            } else if (value > num) {
                high = mid - 1;
            }
        }
        return -1;
    }
         
    // public static int kAlmostSearch(int[] a, int num)
	// {
	// 	int low = 0;
	// 	int high = a.length - 1;

	// 	while (low <= high)
	// 	{
	// 		int mid = (low + high) / 2;
	// 		while (mid <= high && a[mid] == 0)
	// 		{
	// 			mid++;
	// 		}
	// 		if (mid > high)
	// 		{
	// 			mid--;
	// 			while (mid >= low && a[mid] == 0)
	// 			{
	// 				mid--;
	// 			}

	// 			if (mid < low)
	// 			{
	// 				return -1;
	// 			}
	// 		}

	// 		if (a[mid] == num)
	// 		{
	// 			return mid;
	// 		}

	// 		if (a[mid] < num)
	// 		{
	// 			low = (low + high) / 2 + 1;
	// 		}
	// 		else
	// 		{
	// 			high = (low + high) / 2 - 1;
	// 		}

	// 	}

	// 	return -1;
	// }


    //endregion

//endregion

//region מבחני 2023


    //region שאלה 1 מבחן 2023א' מועד 65

    public static int countPairs(int n) {
        return countPairs(n, 0, 0, "");
    }

    public static int countPairs(int n, int left, int right, String str) {
        if (n == 0 && left == right) {
            System.out.println(str);
            return 1;
        }
        if(left<right || right>n || left>n){
            return 0;
        }
        return countPairs(n, left+1, right, str+"(")+countPairs(n, left, right+1, str+")");
    }

    // public static int countPairs(int n) {
    //     return countPairs(n, 0, 0, "");
    // }

    // public static int countPairs(int n, int left, int right, String string) {
    //     if (n < 0 || right > left)
    //         return 0;
    //     if (n == 0 && left == right) {
    //         System.out.println(string);
    //         return 1;
    //     }
    //     int leftBracket = countPairs(n - 1, left + 1, right, string + "(");
    //     int rightBracket = countPairs(n, left, right + 1, string + ")");
    //     return leftBracket + rightBracket;

    // }

    // public static int countPairs(int n) {
    //     return countPairsHelper(0, 0, n);
    // }

    // private static int countPairsHelper(int open, int close, int n) {
    //     if (open == n && close == n) {
    //         return 1; 
    //     }
        
    //     int count = 0;
        
    //     if (open < n) { 
    //         count += countPairsHelper(open + 1, close, n); 
    //     }
        
    //     if (close < open) { 
    //         count += countPairsHelper(open, close + 1, n);
    //     }
        
    //     return count;
    // }

    //endregion

    // public static int countPairs(int num) {
    //     return countPairs(num, "", 0, 0);
    //   }
      
    //   public static int countPairs(int num, String expression, int open, int close) {
    //     if (open > num || close > open) return 0;
    //     if (close == num) {
    //       System.out.println(expression);
    //       return 1;
    //     }
    //     return countPairs(num, expression + "(", open + 1, close) +
    //       countPairs(num, expression + ")", open, close + 1);
    //   }

    // public static int countPairs (int n) {
    //     return countPairs(n, 0, 0, "");
    // }
    // private static int countPairs (int n, int open, int close, String str) {
    //     if(open < close || n < 0 ) {
    //     return 0;
    //     }
    //     if(n == 0 && open == close){
    //     System.out.println(str);
    //     return 1;
    //     }
    //     int openR = countPairs(n-1, open+1, close,str+"(");
    //     int closeR = countPairs(n,open, close+1,str+")");
    //     return openR + closeR;
        
    //     }

    //region שאלה 2 מבחן 2023א' מועד 65


//    int[] arr = {2, 3, 8, 27};
//    O(n)

    public static boolean superInc(int[] arr, int k) {
        int high= arr.length-1;
        while(high>=0 && k>0){
            if(arr[high]<=k){
                k-=arr[high];
            }
            high--;
        }
        return k==0;
    }

    // public static boolean superInc(int[] arr, int k) {
    //     int low = 0, high = arr.length - 1, mid;
    //     while (low <= high) {
    //         mid = (low + high) / 2;
    //         if (arr[mid] == k)
    //             return true;
    //         else if (arr[mid] > k)
    //             high = mid - 1;
    //         else low = mid + 1;
    //     }
    //     while (high >= 0 && k > 0) {
    //         if (arr[high] <= k)
    //             k -= arr[high];
    //         high--;
    //     }
    //     return k == 0;
    // }

    // public static boolean superInc(int[] arr, int k) {
    //     int sum=0;
    //     int high= arr.length-1;
    //     while(high>=0){
    //         sum+=arr[high];
    //             if(sum==k){
    //                 return true;
    //             }
    //             if(sum>k){
    //                 sum-=arr[high];
    //                 high--;
    //             }
    //             else if(sum<k){
    //                 high--;
    //             }
    //             }
    //         return false;
    //     }

    //endregion
    
    
    // public static boolean superInc(int[] nums, int target) {
    //     for (int i = nums.length - 1; i >= 0 && target > 0; i--) {
    //     if (target >= nums[i]) {
    //         target -= nums[i];
    //     }
    //     }
    //     return target == 0;
    // }


    //region שאלה 1 מבחן 2023א' מועד 72


    //    int[][] mat = {
//            {0, 1, 0, 0, 0, 1, 1, 0, 0, 0},
//            {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
//            {0, 1, 0, 0, 0, 1, 1, 0, 0, 1},
//            {0, 1, 0, 0, 0, 0, 1, 1, 0, 0},
//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//            {1, 0, 1, 0, 0, 0, 0, 1, 1, 0},
//            {1, 0, 1, 1, 0, 0, 0, 1, 1, 0},
//            {0, 0, 0, 1, 0, 1, 1, 0, 0, 1},
//            {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
//            {0, 1, 1, 0, 1, 0, 0, 1, 0, 0}
//    };
    public static int friends3(int[][] mat) {
        return friends3(mat, 0, 1, 2, 0);
    }

    public static int friends3(int[][] mat, int i, int j, int k, int count) {
        if (k == mat.length) {
            j++;
            k=j+1;
        }
        if (j == mat.length - 1) {
            i++;
            j=i+1;
            k=j+1;
        }
        if (i == mat.length-2) {
            return count;
        }
        if (mat[i][j] == 1 && mat[j][k] == 1 && mat[k][i] == 1) {
            System.out.println(i + " " + j + " " + k);
            count++;
        }
        return friends3(mat, i, j, k + 1, count);
    }

    // public static int friends3(int[][] mat, int i, int j, int k, int count) {
    //     if (i == mat.length - 2) {
    //         return count;
    //     }
    //     if (j == mat.length - 1) {
    //         return friends3(mat, i + 1, i + 2, i + 3, count);
    //     }
    //     if (k == mat.length) {
    //         return friends3(mat, i, j + 1, j + 2, count);
    //     }
    //     if (mat[i][j] == 1 && mat[j][k] == 1 && mat[k][i] == 1) {
    //         System.out.println(k + " " + j + " " + i);
    //         count++;
    //     }
    //     return friends3(mat, i, j, k + 1, count);
    // }



    //endregion

    // public static int threeFriends(int[][] matrix) {
    //     return threeFriends(matrix, 0, 0, 0, new int[3], 0);
    //   }
      
    //   private static int threeFriends(int[][] matrix, int i, int j, int k, int[] circle, int count) {
    //     if (i == matrix.length) {
    //       return count;
    //     }
    //     if (j == matrix.length) {
    //       return threeFriends(matrix, i + 1, 0, 0, circle, count);
    //     }
    //     if (k == matrix.length) {
    //       return threeFriends(matrix, i, j + 1, 0, circle, count);
    //     }
    //     if (i < j && j < k && matrix[i][j] == 1 && matrix[j][k] == 1 && matrix[k][i] == 1) {
    //       circle[0] = i;
    //       circle[1] = j;
    //       circle[2] = k;
    //       System.out.println(circle[0] + " " + circle[1] + " " + circle[2]);
    //       count++;
    //     }
    //     return threeFriends(matrix, i, j, k + 1, circle, count);
    //   }

    //region שאלה 2 מבחן 2023א' מועד 72


//    int[] arr1 = {5, 10, 20, 15};
//    int[] arr2 = {10, 20, 15, 2, 23, 90, 67};
//    int[] arr3 = {10, 20, 15, 2, 90, 90, 67};
//    int[] arr4 = {1, 2, 3, 4, 5};
//      O(log n)

    // public static int findPeak(int[] arr) {
    //     int low = 0, high = arr.length - 1;
    //     while (low <= high) {
    //         int mid = (low + high) / 2;
    //         if ((mid == 0 || arr[mid - 1] <= arr[mid]) &&
    //                 (mid == arr.length - 1 || arr[mid + 1] <= arr[mid])) {
    //             return arr[mid];
    //         } else if (mid > 0 && arr[mid - 1] > arr[mid]) {
    //             high = mid - 1;
    //         } else {
    //             low = mid + 1;
    //         }
    //     }
    //     return -1;
    // }

    public static int findPeak(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == 0 && arr[mid]>=arr[mid+1]) ||
             (mid == arr.length-1 && arr[mid]>=arr[mid-1]) ||
              (arr[mid]>=arr[mid+1] && arr[mid]>=arr[mid-1])){
               return arr[mid]; 
            }
            if (mid<arr.length-1 && arr[mid] < arr[mid+1]){
                low = mid + 1;
            } else if(mid>0){
                high = mid - 1;
            }
        }
        return 0;//It's not getting here.
    }

    // public static int findPeak(int[] arr)
	// {
	// 	int low = 0;
	// 	int high = arr.length - 1;
	// 	while (low < high)
	// 	{
	// 		int mid = (low + high) / 2;
	// 		if ((mid == low || arr[mid] >= arr[mid - 1]) && arr[mid] >= arr[mid + 1])
	// 		{
	// 			return mid;
	// 		}

	// 		if (arr[mid - 1] > arr[mid])
	// 		{
	// 			high = mid - 1;
	// 		}
	// 		else
	// 		{
	// 			low = mid + 1;
	// 		}
	// 	}

	// 	return low;
	// }

    // public static int findPeak(int[] arr)
	// {
	// 	int low = 0;
	// 	int high = arr.length;
	// 	while (low < high)
	// 	{
	// 		int mid = (low + high) / 2;
	// 		if ((mid == low || arr[mid] >= arr[mid-1]) && (mid == high || arr[mid] >= arr[mid+1])){
	// 			return mid;
	// 		}

	// 		if (a[mid-1] > a[low]){
	// 	}
	// }



    //endregion

    //region שאלה 1 מבחן 2023א' מועד 54
    // System.out.println(selectedPrimes(819819000,2));


    // public static int selectedPrimes(int num, int x) {
    //     return selectedPrimes(num, x, 0, 0, 2);
    // }

    // public static int selectedPrimes(int num, int x, int target, int count, int current) {
    //     if (target == x && num % current != 0) {
    //         System.out.println(current);
    //         count++;
    //     }
    //     if (num == 1)
    //         return count;
    //     if (num % current == 0)
    //         return selectedPrimes(num / current, x, target + 1, count, current);
    //     return selectedPrimes(num, x, 0, count, nextPrime(current));
    // }


    public static int selectedPrimes(int num, int x) {
        if(num<1){
            return 0;
        }
        return selectedPrimes(num, x, 2, 0, 0);
    }

    public static int selectedPrimes(int num, int x, int prime, int count, int power) {
        if(num==1){
            if(power==x){
                System.out.println(prime);
                count++;
            }
            return count;
        }
        if(num%prime==0){
            return selectedPrimes(num/prime,x,prime,count,power+1);
        }
        if(power==x){
            System.out.println(prime);
            count++;
        }
        return selectedPrimes(num,x,nextPrime(prime),count,0);
    }

    //endregion

    // public static int selectedPrimes(int num, int target) {
    //     return selectedPrimes(num, target, 2, 0, 0);
    //   }
      
    //   public static int selectedPrimes(int num, int target, int currentPrime, int count, int power) {
    //     if (num == 1) {
    //       if (power == target) {
    //         count++;
    //         System.out.println(currentPrime);
    //       }
    //       return count;
    //     }
    //     if (num % currentPrime == 0) {
    //       return selectedPrimes(num / currentPrime, target, currentPrime, count, power + 1);
    //     }
    //     if (power == target) {
    //       count++;
    //       System.out.println(currentPrime);
    //     }
    //     int nextPrime = nextPrime(currentPrime);
    //     return selectedPrimes(num, target, nextPrime, count, 0);
    //   }





    // private static boolean isPrime(int number) {
    //     if (number <= 1) {
    //         return false;
    //     }
    //     for (int i = 2; i <= Math.sqrt(number); i++){
    //         if (number % 1 == 0) {
    //     return false;
    //         }
    //     }
    //     return true;
    // }


    
    //region שאלה 2 מבחן 2023א' מועד 54


//    System.out.println(new int[] {10, 3, 40, 20, 50, 80},40));
//    System.out.println(new int[] {10, 3, 40, 20, 50, 80},60));
//    O(log n)

    // public static boolean isRightSwitched(int[] arr, int index) {
    //     if (index < arr.length - 1)
    //         return arr[index] > arr[index + 1];
    //     return false;
    // }

    // public static boolean isLeftSwitched(int[] arr, int index) {
    //     if (index > 0)
    //         return arr[index] < arr[index - 1];
    //     return false;
    // }

    // public static int findAlmostSorted(int[] arr, int num) {
    //     int low = 0, high = arr.length - 1, mid;
    //     boolean left, right;
    //     while (low <= high) {
    //         mid = (low + high) / 2;
    //         left = isLeftSwitched(arr, mid);
    //         right = isRightSwitched(arr, mid);
    //         if (arr[mid] == num)
    //             return mid;
    //         else if (arr[mid] < num) {
    //             if (left) {
    //                 if (arr[mid - 1] == num)
    //                     return mid - 1;
    //             }
    //             low = mid + 1;
    //         } else {
    //             if (right) {
    //                 if (arr[mid + 1] == num)
    //                     return mid + 1;
    //             }
    //             high = mid - 1;
    //         }
    //     }
    //     return -1;
    // }
    //endregion

    public static int findAlmostSorted(int[] arr, int num) {
        int low = 0, high = arr.length - 1, mid;
        while(low<=high){
            mid=(low+high)/2;
            if(arr[mid]==num){
                return mid;
            }else if(mid>0 && arr[mid-1]==num){
                return mid-1;
            }else if(mid<arr.length-1 && arr[mid+1]==num){
                return mid+1;
            }
            if(num>arr[mid]){
                low=mid+2;
            }else{
                high=mid-2;
            }
        }
        return -1;
    }

    // public static int findAlmostSorted(int[] nums, int target) {
    //     int low = 0, high = nums.length - 1, mid = 0;
    //     while (low <= high) {
    //       mid = (low + high) / 2;
    //       if (nums[mid] == target) {
    //         return mid;
    //       }
    //       if (mid > low && nums[mid - 1] == target) {
    //         return mid - 1;
    //       }
    //       if (mid < high && nums[mid + 1] == target) {
    //         return mid + 1;
    //       }
    //       if (nums[mid] < target) {
    //         low = mid + 2;
    //       } else {
    //         high = mid - 2;
    //       }
    //     }
    //     return -1;
    //   }

    //region שאלה 1 מבחן 2023ב' מועד 81


//    int[][] mat = {
//            {2, 3},
//            {4, 1}
//    };

    public static int[][] copy2dIntArray(int[][] copyFrom) {
        int[][] copyTo = new int[copyFrom.length][copyFrom[0].length];
        copy2dIntArray(copyFrom, copyTo, 0, 0);
        return copyTo;
    }

    public static void copy2dIntArray(int[][] copyFrom, int[][] copyTo, int row, int col) {
        if (row == copyFrom.length)
            return;
        if (col == copyFrom[0].length) {
            copy2dIntArray(copyFrom, copyTo, row + 1, 0);
            return;
        }
        copyTo[row][col] = copyFrom[row][col];
        copy2dIntArray(copyFrom, copyTo, row, col + 1);
    }

    public static int greatestRoute(int[][] mat) {
        int[][] matSum = copy2dIntArray(mat);
        return greatestRoute(mat, matSum, 0, 0, 0, "(0,0)");
    }

    public static int greatestRoute(int[][] mat, int[][] matSum, int row, int col, int sum, String path) {
        if (row < 0 | row >= mat.length || col < 0 || col >= mat[0].length || mat[row][col] == 0)
            return Integer.MIN_VALUE;
        if (row == mat.length - 1 && col == mat[0].length - 1) {
            sum += matSum[row][col];
            System.out.println(path + " = " + sum);
            return sum;
        }
        int temp = mat[row][col];
        mat[row][col] -= 1;
        int right = greatestRoute(mat, matSum, row, col + 1, sum + matSum[row][col], path + " --> " + "(" + row + "," + col + ")");
        int left = greatestRoute(mat, matSum, row, col - 1, sum + matSum[row][col], path + " --> " + "(" + row + "," + col + ")");
        int down = greatestRoute(mat, matSum, row + 1, col, sum + matSum[row][col], path + " --> " + "(" + row + "," + col + ")");
        int up = greatestRoute(mat, matSum, row - 1, col, sum + matSum[row][col], path + " --> " + "(" + row + "," + col + ")");
        mat[row][col] = temp;
        int[] arr = {right, left, down, up};
        return getMax(arr);
    }

    

    //endregion

    // public static int greatestRoute(int[][] matrix) {
    //     int[][] trackMat = new int[matrix.length][matrix[0].length];
    //     copyMatrix(matrix, trackMat, 0, 0);
    //     return greatestRoute(matrix, trackMat, 0, 0, "", 0, Integer.MIN_VALUE);
    //   }
      
    //   private static void copyMatrix(int[][] source, int[][] destination, int row, int col) {
    //     if (row >= source.length) {
    //       return;
    //     }
    //     destination[row][col] = source[row][col];
    //     int nextRow = row;
    //     int nextCol = col + 1;
    //     if (nextCol >= source[0].length) {
    //       nextRow++;
    //       nextCol = 0;
    //     }
    //     copyMatrix(source, destination, nextRow, nextCol);
    //   }
      
    //   private static int greatestRoute(int[][] mat, int[][] trackMat, int i, int j, String path, int sum, int max) {
    //     if (i == mat.length - 1 && j == mat[0].length - 1) { // if at destination
    //       sum += mat[i][j];
    //       System.out.println(path + " (" + i + "," + j + ")" + " = " + sum);
    //       max = Math.max(max, sum);
    //     } else if (trackMat[i][j] > 0) { // if cell can be visited
    //       sum += mat[i][j];
    //       path += "(" + i + "," + j + ") --> ";
    //       trackMat[i][j]--; // decrease visit count in tracking matrix
    //       if (i < mat.length - 1) // down
    //         max = greatestRoute(mat, trackMat, i + 1, j, path, sum, max);
    //       if (j > 0) // left
    //         max = greatestRoute(mat, trackMat, i, j - 1, path, sum, max);
    //       if (j < mat[0].length - 1) // right
    //         max = greatestRoute(mat, trackMat, i, j + 1, path, sum, max);
    //       if (i > 0) // up
    //         max = greatestRoute(mat, trackMat, i - 1, j, path, sum, max);
    //       trackMat[i][j]++; // restore visit count in tracking matrix for other paths
    //     }
    //     return max;
    //   }

    //region שאלה 2 מבחן 2023ב' מועד 81
    //    int[] arr = {2, 6, 0, 1, 9, 7, 3, 1, 4, 1, 8};
    //   sliding window

    public static void findSubarray(int[] arr, int target) {
        int start = 0, end = 0, sum = 0;
        while (end < arr.length) {
            sum += arr[end];
            while (sum > target && start < end) {
                sum -= arr[start];
                start++;
            }
            if (sum == target) {
                System.out.println("Subarray found between indexes " + start + " and " + end + " with sum of " + target);
                return;
            }
            end++;
        }
        System.out.println("No subarray found with sum " + target);
    }

    //endregion

    // public static void findSubarray(int[] nums, int target) {
//     int i = 0, j = 0, sum = nums[0];
//     while (j < nums.length) {
//       if (sum == target) {
//         System.out.println("Subarray found between indexes " + i +
//           " and " + j + " with sum " + target);
//         return;
//       } else if (sum < target) {
//         j++;
//         if (j < nums.length) sum += nums[j];
//       } else {
//         sum -= nums[i];
//         i++;
//       }
//     }
//     System.out.println("No subarray found with sum " + target);
//   }

        
    // public static void findSubarray(int[] nums, int target) {
    //     int i = 0, j = 0, sum = nums[0];
    //     while (j < nums.length) {
    //       if (sum == target) {
    //         System.out.println("Subarray found between indexes " + i +
    //           " and " + j + " with sum " + target);
    //         return;
    //       } else if (sum < target) {
    //         j++;
    //         if (j < nums.length) sum += nums[j];
    //       } else {
    //         sum -= nums[i];
    //         i++;
    //       }
    //     }
    //     System.out.println("No subarray found with sum " + target);
    //   }


    //region שאלה 1 מבחן 2023ב' מועד 83



    // public static String minimalSt(String st1, String st2) {
    //     return minimalSt(st1, st2, "");
    // }

    // public static String minimalSt(String st1, String st2, String both) {
    //     if (st1.length() == 0 && st2.length() == 0)
    //         return both;
    //     if (st1.length() == 0)
    //         return st2 + both;
    //     if (st2.length() == 0)
    //         return st1 + both;
    //     if (st1.charAt(st1.length() - 1) != st2.charAt(st2.length() - 1)) {
    //         String m1 = minimalSt(st1, st2.substring(0, st2.length() - 1), st2.charAt(st2.length() - 1) + both);
    //         String m2 = minimalSt(st1.substring(0, st1.length() - 1), st2, st1.charAt(st1.length() - 1) + both);
    //         if (m1.length() > m2.length())
    //             return m2;
    //         return m1;

    //     }

    //     return minimalSt(st1.substring(0, st1.length() - 1), st2.substring(0, st2.length() - 1), st2.charAt(st2.length() - 1) + both);

    // }

    // public static String minimalSt(String st1, String st2) {
    //     return minimalSt(st1, st2, 0, 0, "");
    // }

    // private static String minimalSt(String st1, String st2, int i, int j, String str) {
    //     if (i == st1.length()) return str + st2.substring(j);
    //     if (j == st2.length()) return str + st1.substring(i);

    //     return (st1.charAt(i) == st2.charAt(j)) ?
    //             minimalSt(st1, st2, i + 1, j + 1, str + st1.charAt(i)) :
    //             minStr(
    //                     minimalSt(st1, st2, i + 1, j, str + st1.charAt(i)),
    //                     minimalSt(st1, st2, i, j + 1, str + st2.charAt(j))
    //             );
    // }

    // private static String minStr(String s1, String s2) {
    //     return (s1.length() > s2.length()) ? s2 : s1;
    // }

   

	public static String minimalSt(String s1, String s2)
	{
		return minimalSt(s1, s2, 0, 0, "");
	}

	private static String minimalSt(String s1, String s2, int i1, int i2, String st)
	{
		if (i1 == s1.length() && i2 == s2.length())
		{
			System.out.println(st);
			return st;
		}
		if (i1 == s1.length())
		{
			return minimalSt(s1, s2, i1, i2 + 1, st + s2.charAt(i2));
		}
		if (i2 == s2.length())
		{
			return minimalSt(s1, s2, i1 + 1, i2, st + s1.charAt(i1));
		}
		if (s1.charAt(i1) == s2.charAt(i2))
		{
			return minimalSt(s1, s2, i1 + 1, i2 + 1, st + s1.charAt(i1));
		}

		String st1 = minimalSt(s1, s2, i1 + 1, i2, st + s1.charAt(i1));
		String st2 = minimalSt(s1, s2, i1, i2 + 1, st + s2.charAt(i2));

		if (st1.length() < st2.length()){
			return st1;
		}	 

		return st2;
	}

    // public static String minimalSt(String st1, String st2) {
    //     if (st1.isEmpty()) return st2;
    //     if (st2.isEmpty()) return st1;
    //     String s1 = st1.charAt(0) + minimalSt(st1.substring(1), st2);
    //     String s2 = st2.charAt(0) + minimalSt(st1, st2.substring(1));
    //     return (st1.charAt(0) == st2.charAt(0)) ?
    //             st1.charAt(0) + minimalSt(st1.substring(1), st2.substring(1)) : s1.length() > s2.length() ? s2 : s1;
    // }


    // private static String minimalSt(String st1, String st2, String str) {
    //     if (st1.isEmpty()) return str + st2;
    //     if (st2.isEmpty()) return str + st1;
    //     String s1 = minimalSt(st1.substring(1), st2, str + st1.charAt(0));
    //     String s2 = minimalSt(st1, st2.substring(1), str + st2.charAt(0));
    //     return (st1.charAt(0) == st2.charAt(0)) ?
    //             minimalSt(st1.substring(1), st2.substring(1), str + st1.charAt(0))
    //             : s1.length() > s2.length() ? s2 : s1;
    // }
    // ----------------------------


    // String minimalSt(String st1, String st2) {
    //     return minimalSt(st1, st2, 0, 0, "");
    // }

    // private static String minimalSt(String st1, String st2, int i, int j, String str) {
    //     if (i == st1.length()) return str + st2.substring(j);
    //     if (j == st2.length()) return str + st1.substring(i);

    //     return (st1.charAt(i) == st2.charAt(j)) ?
    //             minimalSt(st1, st2, i + 1, j + 1, str + st1.charAt(i)) :
    //             minStr(
    //                     minimalSt(st1, st2, i + 1, j, str + st1.charAt(i)),
    //                     minimalSt(st1, st2, i, j + 1, str + st2.charAt(j))
    //             );
    // }

    // private static String minStr(String s1, String s2) {
    //     return (s1.length() > s2.length()) ? s2 : s1;
    // }
    // System.out.println(minimalSt("AGGTAB", "GXTXAYB"));
    // }

     //endregion


    //region שאלה 2 מבחן 2023ב' מועד 83


//    int[] arr = {2, 6, 1, 9, 7, 3, 1, 4, 1, 8};
//    Sliding Window O(n)

    public static int findSmallestSubarrayLen(int[] arr, int num) {
        int start = 0, startF = 0, end = 0, endF = arr.length, len = 0, minLen = arr.length, sum = 0;
        while (end < arr.length) {
            sum += arr[end];
            while (sum > num && start < end) {
                System.out.println("Subarray found [" + start + "-" + end + "]");
                len = end - start + 1;
                if (len < minLen) {
                    startF = start;
                    endF = end;
                    minLen = len;
                }
                sum -= arr[start];
                start++;
            }
            end++;
        }
        if (minLen == arr.length) {
            System.out.println("No subarray exists");
            return 0;
        } else {
            System.out.println("Smallest subarray found [" + startF + "-" + endF + "]");
            return minLen;
        }
    }

    //endregion

    // public static int findSmallestSubarrayLen(int[] nums, int target) {
    //     int minLength = Integer.MAX_VALUE, currentSum = 0, start = 0;
    //     String smallestSubarray = "";
    //     for (int end = 0; end < nums.length; end++) {
    //       currentSum += nums[end];
    //       while (currentSum > target) {
    //         if (end - start + 1 < minLength) {
    //           minLength = end - start + 1;
    //           smallestSubarray = "[" + start + "-" + end + "]";
    //         }
    //         System.out.println("Subarray found [" + start + "-" + end + "]");
    //         currentSum -= nums[start];
    //         start++;
    //       }
    //     }
    //     if (minLength == Integer.MAX_VALUE) {
    //       System.out.println("No Subarray exists");
    //       return 0;
    //     } else {
    //       System.out.println("Smallest Subarray found " + smallestSubarray);
    //       return minLength;
    //     }
    //   }

    //region שאלה 1 מבחן 2023ב' מועד 79


//    int[] arr = {1, 1, 4, 10, 10, 4, 3, 10, 10};

    public static boolean isAlmostPalindrome(int[] arr, int start, int end, int limit, boolean first) {
        if (first && arr[start] != arr[end])
            return false;
        if (limit < 0)
            return false;
        if (start >= end)
            return true;
        if (arr[start] != arr[end])
            limit--;
        return isAlmostPalindrome(arr, start + 1, end - 1, limit, false);
    }

    public static int longestAlmostPalindrome(int[] arr) {
        return longestAlmostPalindrome(arr, 0, 0, 0);
    } 

    public static int longestAlmostPalindrome(int[] arr, int start, int end, int maxLen) {
        int len = end - start + 1;
        if (start == arr.length)
            return maxLen;
        if (end == arr.length)
            return longestAlmostPalindrome(arr, start + 1, start + 1, maxLen);
        if (isAlmostPalindrome(arr, start, end, 1, true) && len > maxLen)
            maxLen = len;
        return longestAlmostPalindrome(arr, start, end + 1, maxLen);

    }

    //endregion

    // public static int longestAlmostPalindrome(int[] arr) {
    //     if (arr == null || arr.length == 0) return 0;
    //     return longestAlmostPalindrome(arr, 2, 1, 0, 1);
    //   }
      
    //   private static int longestAlmostPalindrome(int[] arr, int size, int max, int i, int j) {
    //     if (size > arr.length) {
    //       return max;
    //     }
    //     if (j >= arr.length) {
    //       return longestAlmostPalindrome(arr, size + 1, max, 0, size);
    //     }
    //     if (arr[i] == arr[j]) {
    //       int temp = checkPalindrome(arr, 2, false, i + 1, j - 1);
    //       if (temp > max) {
    //         max = temp;
    //       }
    //     }
    //     return longestAlmostPalindrome(arr, size, max, i + 1, j + 1);
    //   }
    //   private static int checkPalindrome(int[] arr, int size, boolean hasMismatched, int i, int j) {
    //     if (j - i == 0) {
    //       return size + 1;
    //     }
    //     if (i > j) {
    //       return size;
    //     }
    //     if (arr[i] == arr[j]) {
    //       return checkPalindrome(arr, size + 2, hasMismatched, i + 1, j - 1);
    //     }
    //     if (!hasMismatched) {
    //       int skipI = checkPalindrome(arr, size + 1, true, i + 1, j);
    //       int skipJ = checkPalindrome(arr, size + 1, true, i, j - 1);
    //       return Math.max(skipI, skipJ);
    //     }
    //     return -1;
    //   }

    //region שאלה 2 מבחן 2023ב' מועד 79


//    int[] arr = {80, 70, 50, 40, 20, 10, 3};
//     O(log n)

    public static int findNumber(int[] arr) {
        int low = 0, high = arr.length - 1, mid, difference1 = 0, difference2 = 0;
        while (low < high - 1) {
            mid = (low + high) / 2;
            difference1 = arr[low] - arr[mid];
            difference2 = arr[mid] - arr[high];
            if (difference1 == difference2)
                if (high - mid > mid - low)
                    high = mid;
                else low = mid;
            else if (difference1 < difference2)
                low = mid;
            else
                high = mid;
        }
        if (arr[low] - arr[high] != 1)
            return (arr[low] + arr[high]) / 2;
        return Integer.MIN_VALUE;
    }

    //endregion

    // public static int findNumber(int[] nums) {
    //     int low = 0, high = nums.length - 1;
    //     while (low <= high) {
    //       int mid = (low + high) / 2;
    //       int expected = nums[0] - mid;
    //       if (nums[mid] != expected) {
    //         if (mid > 0 && nums[mid - 1] - nums[mid] > 1) {
    //           return nums[mid - 1] - 1;
    //         }
    //         high = mid - 1;
    //       } else {
    //         low = mid + 1;
    //       }
    //     }
    //     return Integer.MIN_VALUE;
    //   }

//endregion

//region מבחני 2024


    //region שאלה 1 מבחן 2024א' מועד 63


//    int[][] mat = {
//            {-2, -3, 3},
//            {-5, -10, 1},
//            {10, 30, -5}
//    };

    public static int minPoints(int[][] mat) {
        return minPoints(mat, mat.length - 1, mat[0].length - 1, 1, 1);
    }

    public static int minPoints(int[][] mat, int row, int col, int check, int number) {
        if (row < 0 || col < 0)
            return Integer.MAX_VALUE;
        if (check + mat[row][col] <= 0) {
            number = number - (check + mat[row][col]) + 1;
            check = check - (check + mat[row][col]) + 1;
        }
        if (row == 0 && col == 0)
            return number;
        int left = minPoints(mat, row, col - 1, check + mat[row][col], number);
        int up = minPoints(mat, row - 1, col, check + mat[row][col], number);
        return Math.min(left, up);

    }

    // public static int minPoints(int[][] mat) {
    //     return minPoints(mat, mat.length - 1, mat[0].length - 1, 0, 0);
    // }

    // public static int minPoints(int[][] mat, int i, int j, int min, int current) {
    //     if (i < 0 || j < 0)
    //         return Integer.MAX_VALUE;
    //     if (i == 0 && j == 0) {
    //         return Math.abs(Math.min(min, current + mat[0][0])) + 1;
    //     }
    //     return Math.min(minPoints(mat, i, j - 1, Math.min(min, current + mat[i][j]), current + mat[i][j]),
    //             minPoints(mat, i - 1, j, Math.min(min, current + mat[i][j]), current + mat[i][j]));
    //     }

    //endregion

    // public static int minPoints(int[][] m) {
    //     int row = m.length;
    //     int col = m[0].length;
    //     return minPoints(m, row - 1, col - 1, new int[row][col]);
    //   }
  
    //   private static int minPoints(int[][] m, int i, int j, int[][] copy) {
    //     // Base case: destination cell
    //     if (i == 0 && j == 0) {
    //       return Math.max(1, 1 - m[0][0]);
    //     }
  
    //     // Check if the result is already computed
    //     if (copy[i][j] != 0) {
    //       return copy[i][j];
    //     }
  
    //     int left = Integer.MAX_VALUE;
    //     int up = Integer.MAX_VALUE;
  
    //     // Calculate minimum number needed if coming from the left
    //     if (j > 0) {
    //       left = Math.max(1, minPoints(m, i, j - 1, copy) - m[i][j]);
    //     }
  
    //     // Calculate minimum number needed if coming from above
    //     if (i > 0) {
    //       up = Math.max(1, minPoints(m, i - 1, j, copy) - m[i][j]);
    //     }
  
    //     // Choose the path that requires the minimum initial number
    //     copy[i][j] = Math.min(left, up);
  
    //     return copy[i][j];
    //   }



    //region שאלה 2 מבחן 2024א' מועד 63


//    int[] a = {-1, 2, 4, 5, 7};
//    int[] b = {-1, 1, 5, 10, 17};

    public static int get(int[] b, int k) {
        if (k == 0)
            return b[k];
        return b[k] - b[k - 1];
    }

    public static int find(int[] b, int x) {
        int low = 0, high = b.length - 1, mid, val;
        while (low <= high) {
            mid = (low + high) / 2;
            val = get(b, mid);
            if (val == x)
                return mid;
            else if (val < x)
                low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    //endregion

    //region שאלה 1 מבחן 2024א' מועד 69


    // public static int count1(int sum) {
    //     return count(sum, 0, 1, "");
    // }

    // public static int count(int sum, int target, int count, String string) {
    //     if (target == sum) {
    //         System.out.println(string);
    //         return 1;
    //     }
    //     if (target > sum || count > sum)
    //         return 0;
    //     return count(sum, target + count, count + 1, string + " " + count) + count(sum, target, count + 1, string);

    // }

    // int sum=7;
    // System.out.println(count(sum));

    public static int count2(int sum){
        return count(sum, 1);
    }
    private static int count(int sum, int i){
        if(sum == 0){
            return 1;
        }
        if(i > sum ){
            return 0;
        }
        return count(sum-i, i+1) + count(sum, i+1);
    }
    //endregion

    //region שאלה 2 מבחן 2024א' מועד 69


    // int[] arr = new int[4];
    // minNumWithSum(arr, 14);
    // System.out.println(Arrays.toString(arr));


    //    int[] arr = new int[4]; 
    //    int s = 14;             
    //    O(n)
    // public static void minNumWithSum(int[] arr, int s) {
    //     if (arr == null || (double) (s) / (double) (arr.length) > 9 || (double) (s) / (double) (arr.length) < 1)
    //         return;
    //     int i = arr.length - 1, max;
    //     while (i >= 0) {
    //         max = s - i;
    //         if (max > 9)
    //             max = 9;
    //         arr[i] = max;
    //         s -= max;
    //         i--;
    //     }
    // }

    // public static void minNumWithSum(int[] arr, int s) {
    //     for (int i = 0; i < arr.length; i++) {
    //         for (int j = 1; j < 10; j++) {
    //             if ((arr.length - 1 - i) * 9 + j >= s) {
    //                 arr[i] = j;
    //                 break;
    //             }
    //         }
    //         s -= arr[i];
    //     }
    // }

    public static void minNumWithSum(int[] arr, int s) {
        if (arr == null || s < arr.length || s > 9 * arr.length)
            return;
    
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = Math.min(9, s - i);
            s -= arr[i];
        }
    }



    //endregion

    //region שאלה 1 מבחן 2024א' מועד 75


//    int[] a = {1, 2, 0, 3, -1};

    public static int countEqualDiff(int[] arr) {
        return countEqualDiff(arr, 0, 0, 0, "", 0, 0, "");
    }

    public static int countEqualDiff(int[] arr, int index, int sum1, int count1, String str1, int sum2, int count2, String str2) {
        if (index == arr.length) {
            if (Math.abs(sum1 - sum2) == Math.abs(count1 - count2)) {
                System.out.println(str1 + "\t" + "sum = " + sum1 + " count = " + count1);
                System.out.println(str2 + "\t" + "sum = " + sum2 + " count = " + count2);
                System.out.println();
                return 1;
            }
            return 0;
        }
        int takeSum1 = countEqualDiff(arr, index + 1, sum1 + arr[index], count1 + 1, str1 + arr[index] + " ", sum2, count2, str2);
        int takeSum2 = countEqualDiff(arr, index + 1, sum1, count1, str1, sum2 + arr[index], count2 + 1, str2 + arr[index] + " ");
        return takeSum1 + takeSum2;

    }

    // public static int countEqualDiff(int[] arr) {
    //     return countEqualDiff(arr, 0, 0, 0, 0, 0, "", "");
    // }

    // public static int countEqualDiff(int[] arr, int i, int sumA, int sumB, int countA, int countB, String strA, String strB) {
    //     if (i >= arr.length) {
    //         if (Math.abs(sumA - sumB) == Math.abs(countA - countB)) {
    //             System.out.println(strA + "\t sum = " + sumA + "count =" + countA + "\n" + strB + "\t sum = " + sumB + "count = " + countB + "\n");
    //             return 1;
    //         }
    //         return 0;
    //     }
    //     return countEqualDiff(arr, i + 1, sumA + arr[i], sumB, countA + 1, countB, strA + " " + arr[i], strB) + countEqualDiff(arr, i + 1, sumA, sumB + arr[i], countA, countB + 1, strA, strB + " " + arr[i]);
    // }

    // public static int countEqualDiff (int [] arr){
    //     return countEqualDiff(arr, 0, 0, 0, 0, 0, "", "");
    // }
    
    // private static int countEqualDiff (int [] arr, int aSum, int bSum, int aLength, int bLength, int i, String strA, String strB){
    //     if (i == arr.length){
    //         if (Math.abs(aSum - bSum) == Math.abs(aLength - bLength)){
    //             System.out.println(strA + "   " + "sum = " + aSum + " count = " + aLength);
    //             System.out.println(strB + "   " + "sum = " + bSum + " count = " + bLength);
    //             return 1;
    //         }
    //         else{
    //             return 0;
    //         }
    //     }
    //     if (i > arr.length){
    //         return 0;
    //     }
    //     //we have 2 options  - or to take from arr to array a, or to take to array b. we will try both of them
    //     int addToA = countEqualDiff(arr, aSum + arr[i], bSum, aLength + 1, bLength, i + 1, strA + arr[i] + " ", strB);
    //     int addToB = countEqualDiff(arr, aSum, bSum + arr[i], aLength, bLength + 1, i + 1, strA, strB + arr[i] + " ");
    //     return addToA + addToB;
    // }


    //endregion

    //region שאלה 2 מבחן 2024א' מועד 75



//    int[] arr = {1, -3, 6, 2, 0, 15};
//    int[] arr2 = {1, 1, 1, 1};
//    int[] arr3 = {1, 2, 3, 4};
//    int[] arr4 = {5, -1, 3, 1, 0, -2, 2};
//    int[] arr5 = {7, 8, 9, 11, 12, 14};
//     O(n) 

    // public static int findFirstMissing(int[] arr) {
    //     int n = arr.length;

    //     // Step 1: Move all non-positive numbers and numbers greater than n to the end of the array
    //     for (int i = 0; i < n; i++) {
    //         if (arr[i] <= 0 || arr[i] > n) {
    //             arr[i] = n + 1; // Marking such numbers with a value greater than n
    //         }
    //     }

    //     // Step 2: Use the array indices to mark the presence of numbers
    //     for (int i = 0; i < n; i++) {
    //         int num = Math.abs(arr[i]);
    //         if (num <= n) {
    //             arr[num - 1] = -Math.abs(arr[num - 1]); // Marking the index corresponding to the value as negative
    //         }
    //     }

    //     // Step 3: The first index which is positive is the missing number
    //     for (int i = 0; i < n; i++) {
    //         if (arr[i] > 0) {
    //             return i + 1;
    //         }
    //     }

    //     // If all numbers from 1 to n are present, return n + 1
    //     return n + 1;
        
//        int ptr = 0, right = 0, temp;
//        right = ptr;
//        while (right < arr.length) {
//            if (arr[right] > arr.length || arr[right] < 0)
//                arr[right] = 0;
//            right++;
//        }
//        while (ptr < arr.length) {
//            while (ptr < arr.length && arr[ptr] != ptr + 1 && arr[ptr] != 0) {
//                if (arr[arr[ptr] - 1] == arr[ptr]) {
//                    arr[ptr] = 0;
//                    ptr++;
//                } else {
//                    temp = arr[ptr];
//                    arr[ptr] = arr[temp - 1];
//                    arr[temp - 1] = temp;
//                }
//            }
//            ptr++;
//        }
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == 0)
//                return i + 1;
//        }
//        return arr.length + 1;
    // }

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

    // public static int findFirstMissing(int[] arr) {
    //     int length = arr.length;

    //     // modify all negative and zero values to be greater than maximum possible first
    //     for (int i = 0; i < length; i++) {
    //         if (arr[i] <= 0)
    //             arr[i] = length + 1;
    //     }

    //     // for every absolute value in [1, maxFirst] range
    //     // mark arr[value - 1] by modifying value to be negative
    //     for (int i = 0; i < length; i++) {
    //         int num = arr[i] < 0 ? -arr[i] : arr[i]; // absolute value

    //         if (num <= length)
    //             // mark appropriate index with negative value
    //             arr[num - 1] = arr[num - 1] > 0 ? -arr[num - 1] : arr[num - 1]; // negative value (if value is negative => value, if value is postive => -value)
    //     }

    //     // check the index of the first positive value
    //     // as the previous indexes were marked by the lighter positive values
    //     for (int i = 0; i < length; i++) {
    //         if (arr[i] > 0)
    //             return i + 1;
    //     }

    //     // if the array has only negative values
    //     // the maximum possible first is the answer
    //     return length + 1;
    // }

    // public static int findFirstMissing(int[] arr) {
    //     int length = arr.length;
    
    //     // שלב 1: הפיכת כל המספרים השליליים והאפסים לערכים חסרי משמעות (גדולים מ-n)
    //     for (int i = 0; i < length; i++) {
    //         if (arr[i] <= 0) {
    //             arr[i] = length + 1;
    //         }
    //     }
    
    //     // שלב 2: סימון המספרים הקיימים על ידי הפיכתם לשליליים במיקומם המתאים
    //     for (int i = 0; i < length; i++) {
    //         int num = Math.abs(arr[i]); // ערך מוחלט
    
    //         if (num <= length && arr[num - 1] > 0) {
    //             arr[num - 1] = -arr[num - 1]; // סימון כמספר שנמצא
    //         }
    //     }
    
    //     // שלב 3: מציאת המספר החיובי הראשון שחסר
    //     for (int i = 0; i < length; i++) {
    //         if (arr[i] > 0) {
    //             return i + 1;
    //         }
    //     }
    
    //     // אם כל המספרים בין 1 ל-n קיימים, המספר הבא הוא n+1
    //     return length + 1;
    // }

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


    //endregion

//endregion


    //region פונקציות עזר


    public static int getMax(int[] arr) {
        return getMax(arr, 0);
    }

    public static int getMax(int[] arr, int index) {
        if (index == arr.length - 1)
            return arr[index];
        return Math.max(arr[index], getMax(arr, index + 1));
    }

    public static boolean allZero(int[] x) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] != 0)
                return false;
        }
        return true;
    }

    public static void copy(int[] dest, int[] src) {
        for (int i = 0; i < src.length; i++) {
            dest[i] = src[i];
        }
    }

    public static void xZero(int[] x, int[] y) {
        for (int i = 0; i < y.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if (x[j] == y[i])
                    x[j] = 0;
            }

        }
    }

    public static int getMin(int[] arr) {
        return getMin(arr, 0);
    }

    public static int getMin(int[] arr, int index) {
        if (index == arr.length - 1)
            return arr[index];
        return Math.min(arr[index], getMin(arr, index + 1));
    }

    public static void printArray1D(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int sum(int[] vec, int lo, int hi) {
        int sum = 0;
        while (lo < hi) {
            sum += vec[lo];
            lo++;
        }
        return sum;
    }

    public static void print2DArray(int[][] arr) {
        System.out.println("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("  { ");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                if (j < arr[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print(" }");
            if (i < arr.length - 1) {
                System.out.println(",");
            } else {
                System.out.println();
            }
        }
        System.out.println("}");
    }

    public static boolean isHighFactorInRange(int n, int low, int high) {
        return (low <= getGreatestPrimeDivisor(n) && getGreatestPrimeDivisor(n) <= high);
    }

    public static int getGreatestPrimeDivisor(int n) {
        if (n <= 1) {
            throw new IllegalArgumentException("Input must be a natural number greater than 1.");
        }

        int greatestPrimeDivisor = 1;

        // Check for divisibility by 2 first
        while (n % 2 == 0) {
            greatestPrimeDivisor = 2;
            n /= 2;
        }

        // Check for divisibility by odd numbers from 3 onwards
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                greatestPrimeDivisor = i;
                n /= i;
            }
        }

        // If n is a prime number and greater than 2
        if (n > 2) {
            greatestPrimeDivisor = n;
        }

        return greatestPrimeDivisor;
    }

    public static int nextPrime(int num) {
        int candidate = num + 1;
        while (!isPrime(candidate)) {
            candidate++;
        }
        return candidate;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    // found NextPrime

    // public static int nextPrime(int NextPrime) {
    //     NextPrime++;
    //     while(!isPrime(NextPrime)){
    //         NextPrime++;
    //     } 
    //     return NextPrime;
    // }

    // private static boolean isPrime(int num) {
    //     if (num <= 1) {
    //         return false;
    //     }
    //     for( int i=2; i<Math.sqrt(num); i++){
    //         if(num %i==0){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    //endregion


//region general

    // --------------------------------------------------------------------------------------------------
    // 2024B-87
    // Q1

    // מעבר על כל המטריצה בשיטה נפרדת , נספר את כמות האחדים שיש במטריצה
    // עוד שיטה שמחסירה את האחדים שמצאנו ע"י מעבר רק ימינה ולמטה 
    // תנאים שלילים: יציאה מהמטריצה, לא לכל האחדים
    // תנאים חיבויים: הגעה לסוף המטריצה עם כל האחדים 
    //  בשיטה הראשית משנה עם המשיטה הראשונה ואז להחזיר את השיטה השנייה בוליאנית עם זה שונה מ0

       // int[][] mat= {{1,0,0,1,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,1}};//true-4
       // int[][] mat= {{1,0,0,1,0},{0,0,0,0,0},{0,0,1,0,0},{0,0,0,0,1}};//false-0
    
    public static boolean checkPath(int [][] mat){
        int sum = checkSum(mat, 0, 0, 0);//
        return checkSumPath(mat, 0, 0, sum) != 0; // if this !=0 so it's True
    }

    public static int checkSum( int [][] mat, int i, int j, int sum){// sum the ones in the mat
        if (j >= mat[0].length){
            i += 1;
            j = 0;
        }
        if ( i >= mat.length)
            return sum;
        return checkSum(mat, i, j+1, sum + mat[i][j]);
    }

    public static int checkSumPath(int [][] mat, int i, int j, int sum){
        if ( i >=mat.length || j >= mat[0].length)
            return 0;
        if ( i == mat.length-1 && j == mat[0].length -1 && sum -1 == 0)
            return 1;//if we reached the end with all ones + add 1 to the sum path
        return checkSumPath(mat, i, j+1, sum - mat[i][j]) + checkSumPath(mat, i+1, j, sum - mat[i][j]);
    }

    // 1b
    public static int countPathsThroughOnes(int [][] mat){
        int sum = checkSum(mat,0, 0, 0);
        return checkSumPath(mat, 0, 0, sum);
    }

    //endregion
    
    
    // Q2
    //  O(n)
    //           1   2   3  4  5  6  7  8
    // arr1[] = {4, -5, -3, 1, 2, 7, 0)//1 it is median, odd 
    // arr2[] = {4, -5, -3, 1, 2, 7, 9, 0)//2 it is median , Even

    public static void wigglyArr(int[] arr, int med){
        int i = 0, j=1;
        while (i< arr.length && j<arr.length){
            if (arr[i]<med && arr[j]>=med){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else if (arr[i] >=med){
            i+=2;
            }else if(arr[j]< med){
                j+=2;
            }
        }
    }

    // ----------------------------------------------------------------

    // 2014-85
    // O(log n)
    // Q2
    // int[]arr= {65,70,-5,3,48,49,52}

    public static int findMax(int[]arr){
        int low=0, high=arr.length-1, mid = high /2;
        while(low<high){
            if(arr[low]>arr[high]){
                high=mid;
                }
                else if(arr[high] > arr[low])
                    low=mid+1;
                    if(arr[mid]< arr[mid-1])
                        return mid-1;
                    mid = (high + low) / 2;
        }
            return -1;
                
    }

    // -----------------------------------------------------------------------------------------

    public static int findNum(int[]arr, int num){
        int low=0, high=arr.length-1, mid = high /2;
        while(low<high){
            if(num>arr[mid] && num< arr[high]){
                low=mid+1;
            }else {
                high=mid;
            }
            if(arr[mid]== num){
                return mid;
            }
            mid = (high + low) / 2;
            }
            return -1;
    }

    

    // --------------------------------------------------------------------

    // 2021a-70

    // int[] arr= {0,1,3,10,9,10,17,17,20};
    // System.out.println(findMaxPrice(arr, 8));

    // public static int findMaxPrice(int[] prices, int k) {
    //     return findMaxPrice(prices,k, 1);
    // }

    // private static int findMaxPrice(int[] prices, int n, int i) {
    //     if(i > n){
    //         return 0;
    //     }
    //     if(n==0){
    //         return 0;
    //     }
    //     return Math.max(prices[i]+ findMaxPrice(prices, n-i,i),findMaxPrice(prices,n,i+1));
    // }

    public static int findMaxPrice(int[] prices, int n)
	{
		return findMaxPrice(prices, n, 1, 0);
	}

	private static int findMaxPrice(int[] prices, int n, int i, int sum)
	{
		if (n < i)
		{
			return 0;
		}
		if (n == 0)
		{
			return sum;
		}
		int r0 = findMaxPrice(prices, n - i, i, sum + prices[i]);
		int r1 = findMaxPrice(prices, n, i + 1, sum);

		return Math.max(r0, r1);

	}


    // int []a = {1,12,15,26,38};
    // int []b = {12,13,18,30,45};
    // System.out.println(getMedian(a,b)); 
    //  O(n)

    public static int getMedian(int[]a, int[]b){
        int i=0, j=0, sum=0, count=0;
        while(count<a.length-1){
            if(a[i]<b[j]){
                    i++;
                } else{
                    j++;
                }
            count++;
        }
        if(i<a.length-1 && a[i+1]<b[j]){
            sum+=a[i]+a[i+1];
        }else if(j<b.length-1 && b[j+1]<a[i]){
            sum+=b[j]+b[j+1];
        }else{
            sum+=a[i]+b[j];
        }
        return sum/2;
    } 

    // -----------------------------------------------------------------------------------------------------------
    // 2023A
     
	// private void traverseMat(int[][] mat)
	// {
	// 	traverseMat(mat, 0, 0);
	// }

	// private void traverseMat(int[][] mat, int i, int j, int count)
	// {
	// 	if (i == mat.length)
	// 	{
	// 		return count;
	// 	}
	// 	if (j == mat[i].length)
	// 	{
	// 		traverseMat(mat, i + 1, 0);
	// 	}

	// 	traverseMat(mat, i, j + 1);
	// }

    // -----------------------------------------------------------------------------------------------------------
    // 2023A

    // 2023A

			// int[][] mat =
		    //     {
			// 	{ 3, 13, 15, 28, 30 },
			// 	{ 50, 51, 52, 29, 30 },
			// 	{ 51, 10, 53, 54, 55 },
			// 	{ 53, 12, 14, 53, 11 }, };



	public static int longestWorm(int[][] mat)
	{
		return longestWorm(0, 0, 0, mat);
	}

	private static int longestWorm(int[][] mat, int i, int j)
	{
		if (i == mat.length)
		{
			return 0;
		}
		if (j == mat[0].length)
		{
			return longestWorm(mat, i + 1, 0);
		}

		int r = longestWorm(mat, i, j, mat[i][j] - 1, 0);

		return Math.max(r, longestWorm(mat, i, j + 1));
	}

	private static int longestWorm(int i, int j, int longest, int[][] mat)
	{
		if (i == mat.length)
		{
			return longest;
		}
		if (j == mat[0].length)
		{
			return longestWorm(i + 1, 0, longest, mat);
		}

		int r = longestWorm(mat, i, j, mat[i][j] - 1, 0);

		longest = Math.max(r, longest);
		return longestWorm(i, j + 1, longest, mat);
	}

	private static int longestWorm(int[][] mat, int i, int j, int prev)
	{
		if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] != prev + 1)
		{
			return 0;
		}
		int r0 = longestWorm(mat, i + 1, j, mat[i][j]);
		int r1 = longestWorm(mat, i - 1, j, mat[i][j]);
		int r2 = longestWorm(mat, i, j + 1, mat[i][j]);
		int r3 = longestWorm(mat, i, j - 1, mat[i][j]);

		return 1 + Math.max(Math.max(r0, r1), Math.max(r2, r3));
	}

	private static int longestWorm(int[][] mat, int i, int j, int prev, int count)
	{
		if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] != prev + 1)
		{
			return count;
		}

		count++;
		int r0 = longestWorm(mat, i + 1, j, mat[i][j], count);
		int r1 = longestWorm(mat, i - 1, j, mat[i][j], count);
		int r2 = longestWorm(mat, i, j + 1, mat[i][j], count);
		int r3 = longestWorm(mat, i, j - 1, mat[i][j], count);

		return Math.max(Math.max(r0, r1), Math.max(r2, r3));
	}
   


      // -----------------------------------------------------------------------------------------------------------
    //

      // public static void main(String[] args) {
    //     int[][] mat = {{1, 3, 7, 9},
    //             {6, 4, 15, 11},
    //             {36, 50, 21, 22},
    //             {60, 55, 30, 26}};
    //     System.out.println(search(mat, 26));
    // }

	// public static boolean search(int[][] mat, int num)
	// {

	// 	int lowRow = 0;
	// 	int highRow = mat.length-1;
	// 	int lowCol = 0;
	// 	int highCol = mat.length-1;
	// 	while (lowRow < highRow){
	// 		int q1Min = mat[lowRow][lowCol];
	// 		int q1Max = mat[lowRow + 1 == highRow ? highRow :  (lowRow + highRow)/2][lowCol];
	// 		int q2Min = mat[lowRow][lowRow + 1 == highRow ? highCol : (lowCol+highCol)/2+1];
	// 		int q2Max = mat[lowRow + 1 == highRow ? highRow :  (lowRow + highRow)/2][lowRow + 1 == highRow ? highCol : (lowCol+highCol)/2+1];
	// 		int q3Min = mat[1 + (lowRow + 1 == highRow ? highRow :  (lowRow + highRow)/2)][lowRow + 1 == highRow ? highCol : (lowCol+highCol)/2+1];
	// 		int q3Max = mat[highRow][lowRow + 1 == highRow ? highCol : (lowCol+highCol)/2+1];
	// 		int q4Min = mat[1 + (lowRow + 1 == highRow ? highRow :  (lowRow + highRow)/2)][lowCol];
	// 		int q4Max = mat[highRow][lowCol];

	// 		if (num >= q1Min && num <= q1Max){
	// 			highRow = lowRow + 1 == highRow ? lowRow :  (lowRow + highRow)/2;
	// 			highCol = lowRow + 1 == highRow ? lowCol :  (lowCol + highCol)/2;
	// 		}
	// 	}

    

	// }


	
 
		// int[] a = { 4, 8, 8, -7, -7, 3, 3, 0, 0, 10, 10, 5, 5 };
		
		// int[] arr ={ 10, 50, 15, 14, 15, 12, 10 };
		
    // public static int kAlmostSearch(int[] a, int num)
    // {
	// 	int low = 0;
	// 	int high = a.length - 1;
	// 	while (low <= high)
	// 	{
	// 		int mid = (low + high) / 2;
	// 		while (mid <= high && a[mid] == 0){
	// 			mid++;}
	// 		}
	// 		if (mid > high)
	// 		{
	// 			mid--;
	// 			while (mid >= low && a[mid] == 0)
	// 			{
	// 				mid--;
	// 			}

	// 			if (mid < low)
	// 			{
	// 				return -1;
	// 			}
	// 		}
    //         if (a[mid] == num)
	// 		{
	// 			return mid;
	// 		}
	// 		if (a[mid] < num)
	// 		{
	// 			low = mid + 1;
	// 		}
	// 		else
	// 		{
	// 			high = mid - 1;
	// 		}
    //         return -1;

	// }

	
	
	public static void printPath(int[][] mat)
	{
		printPath(mat, 0, 0, mat[0][0] - 1, "");
	}

	private static boolean printPath(int[][] mat, int i, int j, int prev, String path)
	{
		if (i < 0 || i >= mat.length || j < 0 || j >= mat[i].length)
		{
			return false;
		}
		if (mat[i][j] <= prev)
		{
			return false;
		}
		path += "(" + i + "," + j + ")";
		if (isHill(mat, i, j))
		{
			System.out.println(path);
			return true;
		}
		if (!printPath(mat, i + 1, j, mat[i][j], path))
		{
			if (!printPath(mat, i - 1, j, mat[i][j], path))
			{
				if (!printPath(mat, i, j + 1, mat[i][j], path))
				{
					return printPath(mat, i, j - 1, mat[i][j], path);
				}
			}
		}

		return true;
	}

	private static boolean isHill(int[][] mat, int i, int j)
	{
		if (i > 0 && mat[i][j] <= mat[i - 1][j])
		{
			return false;
		}
		if (i < mat.length - 1 && mat[i][j] <= mat[i + 1][j])
		{
			return false;
		}
		if (j < mat[i].length - 1 && mat[i][j] <= mat[i][j + 1])
		{
			return false;
		}
		if (j > 0 && mat[i][j] <= mat[i][j - 1])
		{
			return false;
		}

		return true;
	}

	

    // -----------------------------------------------------------------------------------------------------------
    
    // 2024B 99 Q1
    // public static int heaviestPath(int [] arr){
    //     int heaviestPath = heaviestPath(arr, 0, 1, 0, "");
    //     if (heaviestPath == Integer.MIN_VALUE){
    //         return Integer.MAX_VALUE;
    //     }
    //     return heaviestPath;
    // }
    
    // private static int heaviestPath(int [] arr, int i, int step, int gold, String str){
    //     if (i < 0 || i >= arr.length || arr[i] == -1){
    //         return Integer.MIN_VALUE;
    //     }
    //     if (i == arr.length - 1){
    //         gold+=arr[i];
    //         System.out.println(str+i+"sum = " + gold);
    //         return gold;
    //     }
    //     int temp = arr[i];
    //     arr[i] = -1;
    //     int goRight = heaviestPath(arr, i+(temp+step), step+1, gold+temp, str+i+" -- ");
    //     int goLeft = heaviestPath(arr, i-(temp+step), step+1, gold+temp, str+i+" -- ");
    //     arr[i] = temp;
    //     return Math.max(goLeft, goRight);
    // }

    //     public static int heaviestPath(int [] arr){
    //         return heaviestPath(arr, 0, 1, 0, "");
    //     }
    //     public static int heaviestPath(int [] arr, int i, int step, int sum, String str){
    //         if(i == arr.length-1){
    //             sum+=arr[i];
    //             System.out.println(str + i + "sum =" + sum);
    //             return sum;
    //         }
    //         int maxValue = Integer.MIN_VALUE;
    //         int temp = arr[i];
    //         arr[i] = -1;
    //         if(IsValid(arr, i+(step+temp))){
    //             maxValue = Math.max(maxValue, heaviestPath(arr, i+(step+temp), step+1, sum+temp, str+i+"--"));
    //         }
    //         if(IsValid(arr, i-(step+temp))){
    //             maxValue = Math.max(maxValue, heaviestPath(arr, i-(step+temp), step+1, sum+temp, str+i+"--"));
    //         }
    //         arr[i] = temp;
    //         return (maxValue == Integer.MIN_VALUE) ? sum : maxValue;
    //     }
    //    public static boolean IsValid(int [] arr, int i){
    //         if(i < 0 || i >= arr.length || arr[i] == -1){
    //             return false;
    //         }
    //         return true;
    //     }

    // public static int heaviestPath(int[] arr){
    //     if(arr.length != 0){
    //     boolean[] visitted = new boolean[arr.length];
    //     return heaviestPath(arr,visitted,0,0,0+"",0);
    //     }
    //         else return Integer.MAX_VALUE;
    //     }
    //     private static int heaviestPath(int[] arr, boolean[] visitted, int i, int count, String st, int sumOfGold){
    //     //exit point
    //     if(i == arr.length-1){
    //         sumOfGold+=arr[i];
    //         st+=" - "+i+"\t\t sum = "+sumOfGold+"\n";
    //         System.out.println(st);
    //         return sumOfGold;
    //     }
    //     //error point
    //     if(i>arr.length-1 || i<0 || visitted[i] == true){
    //         return -1;
    //     }
    //     if(i != 0){
    //         st+=" - "+1;
    //     }
    //     visitted[i]=true;
    //     sumOfGold += arr[i];
    //     count++;
    //     int right = heaviestPath(arr, visitted, i+count+arr[i], count, st,sumOfGold);
    //     visitted[i]=false;
    //     int left = heaviestPath(arr, visitted, i-count-arr[i], count, st, sumOfGold);
    //     return Math.max(left, right);
    // }

    public static int heaviestPath(int[] arr){
        int result = heaviestPath(arr,1,0,0,"");
        return result == Integer.MIN_VALUE ? Integer.MAX_VALUE : result;
    }

    public static int heaviestPath(int[] arr, int step,int i, int sum, String pass){
        if(i >= arr.length || i < 0 || arr[i] < 0){
            return Integer.MIN_VALUE;
        }
        if(i == arr.length-1){
            System.out.println(pass + i +"\t sum =" + (sum + arr[i]));
            return sum+arr[i];
        }

        arr[i] *= -1;//Marking
        int max = Math.max(heaviestPath(arr,step+1,i+step+(arr[i] * -1),sum+(arr[i]*-1), pass + i + "\t"),heaviestPath(arr,step+1,i-step-(arr[i] * -1), sum+(arr[i]*-1) , pass + i + "\t"));
        arr[i] *= -1;
        return max;
    }

    // public static int heaviestPath(int[] arr) {
    //     return heaviestPath(arr, 1, 0, 0, "");
    // }

    // public static int heaviestPath(int[] arr, int step, int sum, int i, String path) {
    //     if (i == arr.length - 1) {
    //         System.out.println(path + " " + i + " sum = " + (sum + arr[i]));
    //         return sum + arr[i];
    //     }
    //     return (i < 0 || i >= arr.length) ? Integer.MIN_VALUE : Math.max(heaviestPath(arr, step + 1, sum + arr[i], i + arr[i] + step, path + i + " -- "),
    //         heaviestPath(arr, step + 1, sum + arr[i], i - arr[i] - step, path + i + " -- "));
    // }
    




    // ---------------------------------------------------------------------------------------------------------------------------

    //2024B 99 Q2.2 O(nlogn)

        // public static int smallestDiffPair(int[] a, int[] b){
        //     if(a==null || b==null || a.length==0 || b.length==0){
        //         return Integer.MAX_VALUE;
        //     }
            
        //     quickSort(a, 0, a.length-1);
        //     quickSort(b, 0 ,b.length-1);
                
        //     int ia = 0;
        //     int ib = 0;
        //     int numA = a[0];
        //     int numB = b[0];
        //     int minDiff = Integer.MAX_VALUE;
        //     while (ia < a.length && ib < b.length){
        //         int diff = Math.abs(a[ia]-b[ib]);
        //         if(diff<minDiff){
        //             minDiff = Math.min(minDiff, diff);
        //             numA=a[ia];
        //             numB=b[ib];
        //         }
        //         if (a[ia] < b[ib]){
        //             ia++;
        //         }else{
        //             ib++;
        //         }
        //     }
        //     System.err.println(numA + "" + numB);
        //     return minDiff;
        // }

        public static int smallestDiffPair(int[] a, int[] b){
            quickSort(a, 0, a.length-1);
            quickSort(b, 0 ,b.length-1);
            
            int i=0, j=0, minDiff = Integer.MAX_VALUE;
            String print = "";
            while(i<a.length && j<b.length){
                if(Math.abs(a[i]-b[j]) < minDiff){
                    minDiff = Math.abs(a[i]-b[j]);
                    print = a[i] + " " + b[j];
                    }
                    if(a[i] < b[j]){
                        j++;
                    }else{
                        i++;
                    }
            }
            System.out.println(print);
            return minDiff;
        }

        // O(n)

        public static int bigestDiffPair(int[] a, int[] b){
            int minA=Integer.MAX_VALUE , minB=Integer.MAX_VALUE, maxA=Integer.MIN_VALUE, maxB=Integer.MIN_VALUE;
            for(int i=0; i< a.length; i++){
                minA = Math.min(minA, a[i]);
                maxA = Math.max(maxA, a[i]);
            }
            for(int j=0; j< b.length; j++){
                minB = Math.min(minB, b[j]);
                maxB = Math.max(maxB, b[j]);
            }
            if(Math.abs(minA-maxB) > Math.abs(maxA-minB)){
                System.out.println(minA + "and" + maxB+ "the bigess");
                return Math.abs(minA-maxB);
            }
            System.out.println(maxA + "and" + minB+ "the bigess");
            return Math.abs(maxA-minB);
        }

    // .....................................................................
        public static void quickSort(int[] arr, int left, int right) {
            if (left >= right) return; // תנאי עצירה

            int pivot = partition(arr, left, right); // מחלקים את המערך לפי Pivot
            quickSort(arr, left, pivot - 1); // מיון החלק השמאלי
            quickSort(arr, pivot + 1, right); // מיון החלק הימני
        }

        private static int partition(int[] arr, int left, int right) {
            int pivot = arr[right]; // בוחרים את האלמנט האחרון כ-Pivot
            int i = left; 

            for (int j = left; j < right; j++) {
                if (arr[j] < pivot) { // אם הערך קטן מה-Pivot, מחליפים אותו עם i
                    swap(arr, i, j);
                    i++;
                }
            }
            swap(arr, i, right); // ממקמים את ה-Pivot במקום הנכון
            return i;
        }

        public static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }


   


    // -----------------------------------------------------------------------------------------------------------------

    // O(n)
    public static int MinimalLengthSumArrayEqualToK(int[] arr, int k)
    {
        int min = Integer.MAX_VALUE;
        int start = 0;
        int currentSum = 0;
  
        for (int end = 0; end < arr.length; end++)
        {
            currentSum += arr[end];
            while (start <= end && currentSum >= k)
            {
                if (currentSum == k)
                {
                    min = Math.min(min, end - start + 1);
                }
                currentSum -= arr[start];
                start++;
            }
        }
  
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }   

    // ---------------------------------------------------------------------------------------------------------------------------------------------

    // 2023b-83 Q1

    public static String minimalIncludeTwoStrings(String str1, String str2) {
        if (str1.length() == 0) {
        return str2;
        }
        if (str2.length() == 0) {
        return str1;
        }
        if (str1.charAt(0) == str2.charAt(0)) {
        return str1.charAt(0) + minimalIncludeTwoStrings(str1.substring(1),
            str2.substring(1));
        }
        String res1 = str1.charAt(0) + minimalIncludeTwoStrings(str1.substring(1), str2);
        String res2 = str2.charAt(0) + minimalIncludeTwoStrings(str1, str2.substring(1));
        return res1.length() < res2.length() ? res1 : res2;
    }

      // --------------------------------------------------------------------

    // sliding window exemple

    public static int smallesSub(int[] a, int k){
        int sum=0;
        int start=0;
        int end=0;
        int len=a.length;
        int minLen=len+1;
        
        while(end < len) {
            while(sum <= k && end < len) {
                sum+=a[end];
                end++;
            }
            while(sum>k && start < len) {
                minLen=Math.min(minLen, end-start);
                sum -= a[start];
                start++;
            }
        }
        return minLen;
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------- 

    public static void printAllSum(int[] a, int sum) {
        printAllSum(a,sum, 0,"");
    }

    public static void printAllSum(int[] a, int sum, int i, String str) {
        if(i>=a.length && sum==0){
            System.out.println(str);
            return;
        }
        if(i>=a.length){
            return;
        }
        printAllSum(a,sum-a[i],i+1,str+ "1");
        printAllSum(a,sum,i+1,str+"0");
    }

  // -----------------------------------------------------------------------------------------------------------------------------------------------


    // // חלק א: שיטה שבודקת האם יש מסלול חוקי במטריצה
    // public static boolean checkPath(int[][] mat) {
    //     // יצירת מטריצה בוליאנית לסימון ביקורים בתאים
    //     boolean[][] visited = new boolean[mat.length][mat[0].length];
    //     return checkPathHelper(mat, 0, 0, visited);
    // }

    // // שיטת עזר רקורסיבית שבודקת את המסלול
    // private static boolean checkPathHelper(int[][] mat, int row, int col, boolean[][] visited) {
    //     // מקרה בסיס: אם הגענו לפינה הימנית-תחתונה
    //     if (row == mat.length - 1 && col == mat[0].length - 1) {
    //         return mat[row][col] == 1;
    //     }

    //     // אם יצאנו מגבולות המטריצה או אם הערך אינו 1 או שכבר ביקרנו בתא זה, נחזיר false
    //     if (row < 0 || row >= mat.length || col < 0 || col >= mat[0].length || mat[row][col] != 1 || visited[row][col]) {
    //         return false;
    //     }

    //     // מסמנים את התא הנוכחי כ"ביקרנו בו"
    //     visited[row][col] = true;

    //     // ננסה לעבור לכל הכיוונים: ימינה, למטה, שמאלה, למעלה
    //     boolean hasPath = checkPathHelper(mat, row + 1, col, visited) ||  // למטה
    //                       checkPathHelper(mat, row, col + 1, visited) ||  // ימינה
    //                       checkPathHelper(mat, row - 1, col, visited) ||  // למעלה
    //                       checkPathHelper(mat, row, col - 1, visited);    // שמאלה

    //     // מחזירים את התא למצב "לא ביקרנו בו" כדי לאפשר מסלולים אחרים
    //     visited[row][col] = false;

    //     return hasPath;
    // }

    // --------------------------------------------------------------------------------------------------------
    // 2024B-81
    // int mOfMax[][] = {
    //     {4, 5, 8, 2},
    //     {3, 12,16, 7},
    //     {13, 1, 10, 14},
    //     {15, 11, 9, 6},
    // };
    // System.out.println("expected 12: " + minOfmax(m));

    public static int minOfmax(int[][]m){
        return minOfmax(m, 0, 0, 0);
    }
    
    public static int minOfmax(int[][]m, int i, int j, int max){
        if (i<0 || j < 0 || i >= m.length || j >= m[0].length || m[i][j] < 0) {
            return Integer.MAX_VALUE;
        }
        int temp= m[i][j];
        m[i][j]=-1;
        max = Math.max(max, temp);

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


    public static int minOfMax(int[][]mat)
    {
       return minOfMax(mat,0,0,mat[0][0],mat[0][0]);
    }

    private static int minOfMax(int[][]mat,int i,int j,int max,int last)
    {
        if(i<0||j<0||i>mat.length-1||j>mat[0].length-1||last==-1)
        {
            return Integer.MAX_VALUE;
        }
        
        if(i==mat.length-1&&j==mat[0].length-1)
        {
            if(mat[i][j]>max)
            {
                return mat[i][j];
            }
            return max;
        }
        int temp=mat[i][j];
        mat[i][j]=-1;
        int up=minOfMax(mat,i+1,j,Math.max(max,temp),temp);
        int down=minOfMax(mat,i-1,j,Math.max(max,temp),temp);
        int right=minOfMax(mat,i,j+1,Math.max(max,temp),temp);
        int left=minOfMax(mat,i,j-1,Math.max(max,temp),temp);
        mat[i][j]=temp;
        return Math.min(Math.min(up,down),Math.min(right,left));
    }

    // O(n)

    public static int whatEff(int[] a){
        if (a.length == 0){
            return 0;
        }
        int min = a[0];
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            min = Math.min(min, a[i]);
            max = Math.max(max, a[i]-min);
        }
        
        return max;
    }

    // -----------------------------------------------------------------------------------------------

    // 2025-66
    // Q1


    public static int lcs(String st1, String st2, String st3) {
        return lcsHelper(st1, st2, st3, st1.length(), st2.length(), st3.length());
      }
      
      private static int lcsHelper(String st1, String st2, String st3, int i, int j, int k) {
        if (i == 0 || j == 0 || k == 0) {
          return 0;
        }
      
        if (st1.charAt(i - 1) == st2.charAt(j - 1) && st2.charAt(j - 1) == st3.charAt(k - 1)) {
          return 1 + lcsHelper(st1, st2, st3, i - 1, j - 1, k - 1);
        }
      
        return Math.max(Math.max(
            lcsHelper(st1, st2, st3, i - 1, j, k),
            lcsHelper(st1, st2, st3, i, j - 1, k)),
          lcsHelper(st1, st2, st3, i, j, k - 1));
      }


    // 2025-66
    // Q2
    // O(n)


      public static int findDivisor(int[] a) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            min = Math.min(min, Math.abs(a[i]));
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] % min != 0)
                return -1;
        }
        return min == 1 ? -1 : min;
    }



    // ---------------------------------------------------------------------------------------------
    // 2025-72
    // Q1

    public static int maxFactor(int num) {
        return maxFactor(num, (int) Math.sqrt(num));
    }

    private static int maxFactor(int num, int factor) {
        if (factor < 2) return 0;
        return isFactorialSum(num, factor, 0, 1, "") ? factor : maxFactor(num, factor - 1);
    }

    private static boolean isFactorialSum(int num, int factor, int pow, int curNum, String str) {
        if (num < curNum)
            return false;
        if (num == curNum) {
            System.out.println(str + curNum);
            return true;
        }
        return isFactorialSum(num, factor, pow + 1, (int) Math.pow(factor, pow + 1), str) ||
                isFactorialSum(num - curNum, factor, pow + 1, (int) Math.pow(factor, pow + 1), str + curNum + "\t");
    }
    
    // public static int maxFactor(int num) {
    //     return maxFactor(num, 2, 0, "");
    // }
    // private static int maxFactor(int num, int base, int maxFactorNum, String biggestFactor) {
    //     if (base == num - 1) {
    //         if (biggestFactor.length() > 0) {
    //             System.out.println(biggestFactor);
    //         }
    //         return maxFactorNum;
    //     }
    //     String currentFactor = isFactor(num, base, 0, "");
    //     if (currentFactor.length() > 0) {
    //         biggestFactor = currentFactor;
    //         maxFactorNum = base;
    //     }
    //     return maxFactor(num, base + 1, maxFactorNum, biggestFactor);
    // }

    // private static String isFactor(int num, int base, int pow, String currentFactor) {
    //     if (num == 0) {
    //         return currentFactor;
    //     }
    //     if (num < 0 || num - Math.pow(base, pow) < 0)
    //         return "";
    //     String op1 =  isFactor(num - (int)(Math.pow(base, pow)), base, pow + 1, currentFactor + (int)Math.pow(base, pow) + "\t");
    //     String op2 = isFactor(num, base, pow + 1, currentFactor);
    //     if (op1.length() > op2.length()) {
    //         return op1;
    //     }
    //     return op2;
    // }

     
//     public static int maxFactor (int num){ 
//         return maxFactor(num, num-2); 
//     } 
 
//     private static int maxFactor(int num, int factor) { 
//         if (factor < 2){ 
//             return 0; 
//         } 
//         if (isFactor(num, factor)){ 
//             return factor; 
//         } 
 
//         return maxFactor(num, factor-1); 
//     } 
 
//     private static boolean isFactor(int num, int factor) { 
//         return isFactor(num, factor, 0, ""); 
//     } 
 
//     private static boolean isFactor(int num, int factor, int power, String powers) { 
//         if (num == 0){ 
//             System.out.println(powers); 
//             return true; 
//         } 
//         if (Math.pow(factor, power) > num){ 
//             return false; 
//         } 
 
//         int currPower = (int)(Math.pow(factor, power)); 
//         boolean r1 = isFactor(num-currPower,factor, power+1, powers + (powers.length() == 0 ? currPower : "\t" + currPower));//take 
//         boolean r2 = isFactor(num,factor, power+1, powers);//no take 
 
//         return r1 || r2; 
//     } 
// } 


// Q2
// int[] arr = {1,9,3,2,5,6,7,8,9,10,3}; 
// int num = 1; 
// System.out.println(howManyDivisors(arr, num)); 


public static int howManyDivisors(int [] arr, int num){ 
    if (arr.length < num*2+1){ 
        return -1; 
    } 

    int sum = 0; 
    int i = 0; 
    for (; i < num*2+1; i++) { 
        sum += arr[i]; 
    } 

    int count = 0; 
    if (sum % arr[i/2] == 0){ 
        count++; 
    } 
    for (; i < arr.length; i++) { 
        sum -= arr[i-(num*2+1)]; 
        sum += arr[i]; 
        if (sum % arr[i-num] == 0){ 
            count++; 
        } 
    } 

    return count; 
} 


// public static int howManyDivisors (int [] arr, int num)
//     {
//         if (num * 2 + 1 > arr.length)
//             return -1;
//         int count = 0;
//         int currentSum = 0;
//         for (int i = num; i < arr.length - num; i++) {
//             currentSum = 0;
//             for (int j = i - num; j <= i + num; j++) {
//                 currentSum += arr[j];
//             }
//             if (currentSum % arr[i] == 0)
//                 count++;
//         }
//         return count;
//     }

    // public static int hawManyDivisors(int[] arr, int num) {
    //     int size = 0, sum = 0, count = 0;
    //     if (arr.length <= num * 2)
    //         return -1;
    //     for (int i = 0; i < arr.length - 1; i++) {
    //         if (size < num * 2 + 1) {
    //             sum += arr[i];
    //             size++;
    //         }
    //         if (size == num * 2 + 1) {
    //             count = sum % arr[i - num] == 0 ? count + 1 : count;
    //             sum = sum - arr[i - (2 * num)] + arr[i + 1];
    //         }
    //     }
    //     return sum % arr[arr.length - num - 1] == 0 ? count + 1 : count;
    // }

    // shorter answer

    public static int howManyDivisors2(int[] arr, int num) {
        if (arr.length <= num * 2) return -1;
        int sum = 0, count = 0;
        for (int i = 0; i < num * 2 + 1; i++)
            sum += arr[i];
        for (int i = num; i < arr.length - num - 1; i++) {
            count = sum % arr[i] == 0 ? count + 1 : count;
            sum = sum - arr[i - num] + arr[i + num + 1];
        }
        return count;
    }




// endregion general 
    






// ________________________________________________________________________________________________________________________________________

// https://www.kefcode.com/courses/intro-to-computer-science/recursion
// https://github.com/Koren-Ben-Ezra/Exams/commit/333eb5d48176415ab959a69e19b84c3dea257c4d
// https://github.com/lironmiz/Computer-Science-in-Java
// https://leetcode.com/studyplan/leetcode-75/
// https://ofec.co.il/courses/%D7%9E%D7%91%D7%95%D7%90-%D7%9C%D7%9E%D7%93%D7%A2%D7%99-%D7%94%D7%9E%D7%97%D7%A9%D7%91-%D7%95%D7%A9%D7%A4%D7%AA-%D7%92%D7%B3%D7%90%D7%95%D7%95%D7%94/

}



