import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Integer.valueOf;
import static java.lang.Math.pow;

public class Main {

    //Task1
    public static int findMaxCommonDivider(int a, int b){
        int temp1;
        int result;
        if(a < b){
            temp1 = a;
            a = b;
            b = temp1;
        }
        int remainder;
        int temp;
        temp =  a / b;
        remainder = a % b;

        while(remainder != 0){
            a = b;
            b = remainder;
            temp = a / b;
            remainder = a % b;
        }
        result = b;
        return result;
    }
    public static void  isDigitsCoprime(int a, int b, int c){
        int temporaryResult1;
        int temporaryResult2;
        int temporaryResult3;
        int temporaryResult4;
        temporaryResult1 = findMaxCommonDivider(a,b);
        if(temporaryResult1 == 1){
            temporaryResult2 = findMaxCommonDivider(temporaryResult1,c);
            temporaryResult3 = findMaxCommonDivider(a, c);
            temporaryResult4 = findMaxCommonDivider(b, c);
            if(temporaryResult2 == 1 && temporaryResult3 == 1 && temporaryResult4 == 1){
                System.out.println("Coprime");
            }else{
                System.out.println("Not coprime(");
            }
        }else{
            System.out.println("Not coprime(");
        }
    }

    //Task2
    public static String initialize(){
        String a;
        System.out.println("Input number:");
        Scanner inputNumber = new Scanner(System.in);
        a = inputNumber.nextLine();
        return a;
    }
    public static int getSize(String a){
        int size;
        size = a.length();
        return size;
    }
    public static String addZeroes(String a, int delta){
        String result = "";
        int counter = delta;
        while(counter != 0){
            result += "0";
            counter--;
        }
        result += a;
        return result;
    }

    public static void sumOfUnlimited(){

        //инициализация
        String number1 = initialize();
        String number2 = initialize();
        String result = "";
        int length1, length2;
        int delta, counter = 0;
        length1 = getSize(number1);
        length2 = getSize(number2);

        //уравнивание длины строк добавлением нулей в начало той, которая короче

        if(length1 > length2){
            delta = length1 - length2;
            number2 = addZeroes(number2, delta);
            counter = length1;
        }
        if(length2 > length1){
            delta = length2 - length1;
            number1 = addZeroes(number1, delta);
            counter = length2;
        }else{
            counter = length1;
        }

        int transition = 0;   //переменная для переноса единицы при сложении столбиком
        int a, b, sum = 0;
        String sumtoString;  //строка для получения и перевода в стринг результата суммирования на каждом этапе
        char str1, str2;


        //поразрядное сложение столбиком

        while(counter != 0){
            str1 = number1.charAt(counter - 1);
            a = Character.getNumericValue(str1);;
            str2 = number2.charAt(counter - 1);
            b = Character.getNumericValue(str2);

            if(a + b + transition >= 10){
                sum = (a + b + transition) % 10;
                transition = 1;
            }
            if(a + b + transition < 10){
                sum = a + b + transition;
                transition = 0;
            }
            sumtoString = String.valueOf(valueOf(sum));
            result+=sumtoString;

            counter--;
        }

        if(transition == 1){
            result+="1";
        }

        //переворачиваем строку
        StringBuffer result2 = new StringBuffer(result);

        result2.reverse();
        System.out.println("Сумма: " + result2);
    }

    //Task3
    public static boolean isArmstrong(int a){
       boolean isTrue = false;
       int counter = 0, sum = 0;
       int temp;
       int ostatok = a/10;
       counter++;

       while(ostatok!=0){
           ostatok/=10;
           counter++;
       }
        ostatok = a/10;
        temp = a % 10;

        while(ostatok!=0){
            sum+=pow(temp, counter);
            temp = ostatok % 10;
            ostatok/=10;
        }
        sum+=pow(temp, counter);

        if(sum == a){
            isTrue = true;
        }else{
            isTrue = false;
        }
       return isTrue;
    }
    public static void findAllArmstrongNumbers(int k){
        boolean check;
        ArrayList<Integer> ArmstrongNumbers = new ArrayList<Integer>();

        for(int i = 1; i <= k; i++){
            check = isArmstrong(i);
            if(check){
                ArmstrongNumbers.add(i);
            }
        }

        System.out.println();
        System.out.println("Числа Армстронга: ");
        for (int i = 0; i < ArmstrongNumbers.size(); i++){
            System.out.println(ArmstrongNumbers.get(i));
        }
        System.out.println();
    }

    //Task4
    public static void sumOfElements(int[] array, int k, int m, int elemetsamount){
        int sum = 0;
        int counter = 0;
        if(k < 0 || m >= array.length){
            System.out.println("Out of range");
        }else {
            for (int i = k; i <= m; i++) {
                sum+=array[i];
                counter++;
                if(counter == elemetsamount){
                    break;
                }
            }
        }
        System.out.println("Сумма трёх элементов от " + k + " до " + m + " : "+ sum);
    }

    //Task5
    public static void findCombination(int[] array, int start, int size, int summa){
        int i = start;
        int tempsum = 0;
        int element;
        while(i + size <= array.length){
            for(int j = i; j < i + size - 1; j++){
                tempsum+=array[j];
            }
            array[i+size-1] = summa - tempsum;
            if(array[i+size-1] < 1 || array[i+size-1] > 6){
                System.out.println("Error!");
                break;
            }
            tempsum = 0;
            i++;
        }
        System.out.println();
        System.out.println("Итоговая комбинация:");
        for(int j = 0; j < array.length; j++){
            System.out.print(array[j] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        isDigitsCoprime(3,1,2);
        sumOfUnlimited();
        findAllArmstrongNumbers(1540);

        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        sumOfElements(arr,0,2,3);

        //инициализация первых двух элементов массива случайными элементами
        int[] arr2 = new int[10];
        arr2[0] = 1;
        arr2[1] = 5;

        int summa = 10;
        int size = 3;
        int start = 0;
        findCombination(arr2,start,size,summa);
    }
}