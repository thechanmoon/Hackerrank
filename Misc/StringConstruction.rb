#!/bin/ruby

require 'json'
require 'stringio'

# Complete the stringConstruction function below.
def stringConstruction(s)       
    count = 0;
    sb =" ";
        s.chars.each do |ch|
            if (( sb.include? ch ) == false ) 
                sb = sb+ch;
                count = count +1;
            end
        end    
    return count;
end

def stringConstructionUsingArray(s)       
    count = 0;
    ascii = Array.new(26,0);        
    
    s.each_byte do |ch|
        index = ch - 97;
        
        if(ascii[index] === 0)
            ascii[index] = ascii[index] + 1;
            count = count +1;
        end
    end    
    
    return count;
end

def stringConstructionUsingBitVector(s)       
    count = 0;
    bitVector = 0;
    
    s.each_byte do |ch|        
        index = ch - "a".ord; 
        if((bitVector & (1 << index)) == 0)
            bitVector |= (1 << index);
            count = count +1;
        end
    end
    
    return count;
end

fptr = File.open(ENV['OUTPUT_PATH'], 'w')

q = gets.to_i

q.times do |q_itr|
    s = gets.to_s.rstrip

    # result = stringConstruction s
    # result = stringConstructionUsingArray s
    result = stringConstructionUsingBitVector s

    fptr.write result
    fptr.write "\n"
end

fptr.close()