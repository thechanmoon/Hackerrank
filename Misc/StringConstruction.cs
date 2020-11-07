using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections;
using System.ComponentModel;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Runtime.Serialization;
using System.Text.RegularExpressions;
using System.Text;
using System;

class Solution {

    // Complete the stringConstruction function below.
    static int stringConstruction(string s) {
        
        if(s.Length == 0)
            return 0;
            
        int count = 0;
        StringBuilder sb = new StringBuilder();

        char[] ch = s.ToCharArray();  
        
        for(int i = 0; i < s.Length; i++)
        {     
             if(sb.ToString().Contains((ch[i]))== false)
             {
                sb.Append(ch[i]);
                count++;
                continue;
             }
        }
        return count;
    }

    static int stringConstructionUsingArray(string s) {
        
        if(s.Length == 0)
            return 0;
            
        int count = 0;
        int[] ascii = new int[26];

        char[] ch = s.ToCharArray();  
        
        for(int i = 0; i < s.Length; i++)
        {     
             int index = ch[i]-'a'; 
             if(ascii[index] == 0)
             {
                ascii[index]++;
                count++;
                continue;
             }
        }
        return count;
    }
    
    static int stringConstructionUsingBitVector(string s) {
        
        if(s.Length == 0)
            return 0;
            
        int count = 0;
        int BitVector = 0;

        char[] ch = s.ToCharArray();  
        
        for(int i = 0; i < s.Length; i++)
        {     
             int index = ch[i]-'a'; 
             if((BitVector & (1 << index)) == 0)
             {
                BitVector |= (1 << index);
                count++;
                continue;
             }
        }
        return count;
    }

    static void Main(string[] args) {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        int q = Convert.ToInt32(Console.ReadLine());

        for (int qItr = 0; qItr < q; qItr++) {
            string s = Console.ReadLine();

            // int result = stringConstruction(s);
            // int result = stringConstructionUsingArray(s);
            int result = stringConstructionUsingBitVector(s);

            textWriter.WriteLine(result);
        }

        textWriter.Flush();
        textWriter.Close();
    }
}
