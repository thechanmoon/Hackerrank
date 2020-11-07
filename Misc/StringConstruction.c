#include <assert.h>
#include <limits.h>
#include <math.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *readline();

// Complete the stringConstruction function below.
int stringConstruction(char *s)
{

    int count = 0;
    int str_length = strlen(s);
    if (strlen(s) == 0)
        return 0;
    int index = 0;

    char sb[str_length + 1];
    memset(sb, 0, str_length);

    // while(*s)
    // {
    //         // print
    //         if(strchr(sb,*s)== false)
    //         {
    //             *(sb+count) = *s;
    //             s++;
    //             count++;
    //             continue;
    //         }
    //         s++;
    // }

    for (int i = 0; i < str_length; i++)
    {
        if (strchr(sb, s[i]) == false)
        {
            sb[index++] = s[i];
            sb[index] = '\0';
            count++;
        }
    }
    return count;
}

int stringConstructionUsingArray(char *s)
{

    int count = 0;
    int str_length = strlen(s);
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

static int stringConstructionUsingBitVector(char *s)
{

    int count = 0;
    int BitVector = 0;
    int str_length = strlen(s);

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
    FILE *fptr = fopen(getenv("OUTPUT_PATH"), "w");

    char *q_endptr;
    char *q_str = readline();
    int q = strtol(q_str, &q_endptr, 10);

    if (q_endptr == q_str || *q_endptr != '\0')
    {
        exit(EXIT_FAILURE);
    }

    for (int q_itr = 0; q_itr < q; q_itr++)
    {
        char *s = readline();

        // int result = stringConstruction(s);
        // int result = stringConstructionUsingArray(s);
        int result = stringConstructionUsingBitVector(s);

        fprintf(fptr, "%d\n", result);
    }

    fclose(fptr);

    return 0;
}

char *readline()
{
    size_t alloc_length = 1024;
    size_t data_length = 0;
    char *data = malloc(alloc_length);

    while (true)
    {
        char *cursor = data + data_length;
        char *line = fgets(cursor, alloc_length - data_length, stdin);

        if (!line)
        {
            break;
        }

        data_length += strlen(cursor);

        if (data_length < alloc_length - 1 || data[data_length - 1] == '\n')
        {
            break;
        }

        size_t new_length = alloc_length << 1;
        data = realloc(data, new_length);

        if (!data)
        {
            break;
        }

        alloc_length = new_length;
    }

    if (data[data_length - 1] == '\n')
    {
        data[data_length - 1] = '\0';
    }

    data = realloc(data, data_length);

    return data;
}
