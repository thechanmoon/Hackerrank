### The number of words with k max number of consecutive vowels
Given the length of a word (wordLen) and the maximum number of consecutive vowels that it can contain (maxVowels), determine how many unique words can be generated. Words will consist of English alphabetic letters a through z only. Vowels are v: {a, e, i, o, u}; consonants are c: remaining 21 letters. In the explanations, v and c represent vowels and consonants.
```
           0          1          2        

0          1        n/a        n/a
1         21          5        n/a
2        546        105         25
3     14,196      2,730        525
4    366,471     70,980     13,650
5  9,473,121  1,832,355    354,900
```
### Route Counter:
Given an array of Cities and integer value for fuel, find the total number of routes possible.

Example:
cities[]={1,3,6,2,4}
fuel = 7

```
Route through  Distance       Fuel Remain 
	cities   Between cities
	0 -> 1        |3-1|         7-2 = 5
	1 -> 2        |3-6|         5-3 = 2
	2 -> 4        |4-6|         2-2 = 0
	
	One of the route: 0 -> 1 -> 2 -> 4
	
	Other 5 possible routes:
	2) [0,1,3,4]
	3) [0,1,4]
	4) [0,2,4]
	5) [0,3,4]
	6) [0,4]
	
	
	Output (Possible Route): 6
```    
