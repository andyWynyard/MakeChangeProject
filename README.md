## Andy's MakeChange Project

The first class I worked on was the MakeChange class. This class worked fine but was not pretty, and was around 150 lines long. This was excessive.

Thus I created a copy to work on (for fear of breaking the first). I managed to cut the code to 1/3 the size. 

My final hand in is MakeChangeEfficient, however I will leave the original so you can see what I did firstly. Lets see if I can leave this alone ;)

After all of the talk about the % operator, I wanted to see what I could do without it. I used >= instead to see how far that would take me. It works just fine, and I could have continued using this in the final class, but I decided to do it a % way.

Late Sunday I changed the prompts to an array of prompts that could be added to if there were more prompts needed. This was cleaner than with strict Strings being passed to the user. 

I also added another array to take the two amounts (price and money given) as I could then reduce the system input to one loop.

