#include <bits/stdc++.h>

using namespace std;

// Complete the stringConstruction function below.
int stringConstruction(string s)
{

    int count = 0;
    int str_length = s.length();

    string sb = "";

    for (int i = 0; i < str_length; i++)
    {
        if (sb.find(s[i]) == -1)
        {
            sb.append(1, s[i]);
            count++;
        }
    }
    return count;
}

int stringConstructionUsingArray(string s)
{

    int count = 0;
    int str_length = s.length();
    int ascii[26] = {
        0,
    };

    for (int i = 0; i < str_length; i++)
    {
        int index = s[i] - 'a';
        if (ascii[index] == 0)
        {
            ascii[index]++;
            count++;
        }
    }
    return count;
}

static int stringConstructionUsingBitVector(string s)
{

    int count = 0;
    int BitVector = 0;
    int str_length = s.length();

    for (int i = 0; i < str_length; i++)
    {
        int index = s[i] - 'a';
        if ((BitVector & (1 << index)) == 0)
        {
            BitVector |= (1 << index);
            count++;
            continue;
        }
    }
    return count;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int q;
    cin >> q;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int q_itr = 0; q_itr < q; q_itr++)
    {
        string s;
        getline(cin, s);

        // int result = stringConstruction(s);
        // int result = stringConstructionUsingArray(s);
        int result = stringConstructionUsingBitVector(s);
        fout << result << "\n";
    }

    fout.close();

    return 0;
}
