# Project6
# Donald Duck's Digital Data Ducts

# Project Timeline 
- 4-7/2021 Finish Part 1 - 4
- 8-11/2/2021 Finish Knn Algorithm part 

## Problem statement
###### [ ] DataFrame Object 
  - A DataFrame object to interface with the CSV file parsed.
    - a. Method to save DataFrame to CSV file
    - b. Method to construct DataFrame from CSV file

###### [ ] Manipulation methods
  - [ ] Method to concatenate DataFrames
  - [ ] Method to obtain a subset of DataFrame with range of row or column
  - [ ] Method to sort the rows by a column in the DataFrame
  - [ ] Method to remove duplicate rows based on subset of columns
  - [ ] Method to remove rows containing missing data in subset of columns
  
###### [ ] Statistics package and imputers
  - a. Method compute variance, standard deviation, min, max,mean, median, mode and range of a column (Non numeric columns will only have mode)
  - b. Method to fill in missing values of specified columns with a specified value.
  
###### [ ] Scalers 
  - [ ] a. Method to perform Standard Scaling.
      - Standard scaling is subtracting the mean from all values in the column and dividing by the standard deviation.
  - [ ] b. Method to perform Min Max Scaling
      - Min max scaling is subtracting the min from all values in the column and dividing by the range

###### [ ] K-Nearest Neighbours 

###### [ ] Error Metric 

## Caution 
- Proper Package Management 
- Proper documentation 
- User Manual 
- External Libraries are prohibited for basic requirements. However, these libraries can be used as **TOOLS** for implemetation of advanced features. 

## Advanced features 
###### [ ] Drag and drop with saving and loading pipelines
  To be frank, Donald isn’t very good at this whole programming thing. If you had a drag and drop interface for constructing pipelines, Donald would get much more done quicker. Donald would also like to be able to save these pipelines and load them to continue where he left off.

###### [ ] Proof of concept for distributed/parallel computing
  Datasets in production these days can have millions of columns and billions of rows. For example, genomics data, high resolution image datasets and large arrays of IoT sensors. Analysis on these datasets usually require multiple computers churning through the dataset in parallel and sharing intermediate computations with each other. Donald would love to be able to use these datasets in his analysis as well. Maybe you could think of how you could convert the methods in the library you have created to use distributed computing.

###### [ ] Buzzword models
k-nearest neighbors is definitely a powerful algorithm. However, Donalds friends think he’s lame because he doesn’t use any “advanced” models with fancy names. He wants to be cool. So cool. Can you help him out?

###### [ ] Different scalers
  Donald likes the scalers you’ve made so far. However, he’s upset as the scalers seemed to make some of the datasets run worse! Looking into it, you realize that the scalers perform badly on skewed datasets as they amplify outliers. Are there other scalers out there to address this issue?

###### [ ] Read and write to database
  Reading CSV files is nice. But a lot of data Donald is looking for is in databases waiting to be analyzed. Could you make the library support read and write from some of these databases? (SQL is enough. Feel free to explore non-SQL options too though.)

###### [ ] Web Scraping
  Donald is getting a little bored of analyzing the few CSV files he has, there are only so many available free interesting CSVs. But not all datasets come in nicely packaged CSV files. Many websites on the magical internet provide data for free but don't have nice APIs to query or charge a fee for API access. Could you help Donald out by creating a web scraper in your library to get him some more interesting CSVs? (Donald will be interested in whatever data you are interested in. As long as your eyes glow when talking about your web scraped dataset, Donald will pay you (with marks).)
  
###### [ ] Take off the training wheels! 
  Constraints keep the project fun and allow you to focus on the fun parts. But Donald isn’t exactly happy with your library limiting the datasets he can explore. Are you ready to face the quotes and commas nightmare? What about dates and timezones? Hashtables? yikes.

###### [ ] Anything else you find interesting
  There’s a lot of other statistics transforms, encoders and visualisations you can do to help Donald on his Data Science journey. Feel free to bring your fresh innovative ideas to Donald too!
  
  
## Tips and Comments 
- If there is anything you are having trouble solving, try and think if sorting makes your problem simpler.
- Code is read more than it is written. Don’t be too smart. You may think it is cool to be able to code super fast with your 3 character variables or that you’re uber cool because u wrote a one liner with multiple for loops and clauses, but your teammates and you from 1 week in the future will appreciate the extra readability of slowing down to name your methods and variables properly, practice proper spacing and write meaningful comments. Always code as if you are going to explain it one week later, because you are going to have to, even to yourself.
- You might find GitHub useful for collaborating as it allows your team to sync code instead of sending files to each other on whatsapp. This assignment is pretty modular, so it should not be too hard to moderate the repo and will be a nice learning experience for using GitHub.
36
- Methods can have similar names as long as they have different signatures. This may be useful for implementing methods for different types or with different numbers of parameters without confusing yourself by choosing a convoluted method name.
- Dealing with floating point is something new programmers find very annoying, especially people coming from strong math backgrounds who firmly believe in real number precision. The fact that a binary computation system cannot deal with real numbers is one of the proofs that the computational model cannot solve every problem, as the computation model can only output integers, which is a much smaller set. However, as you become more attuned to computer science, you will start accepting this limitation and avoid fighting it when it’s not crucial (for better or for worse). As a result, machine learning algorithms that deal with real numbers usually use float instead of double as the extra precision isn’t worth the increased computation and memory. You may use double in your implementations for this assignment if you wish, but know that we won’t penalize your precious marks over floating point errors.
- You might find coding a matrix library with operation broadcasting helpful. Dealing with matrix operations is much easier to conceptualize than writing a pyramid of for loops all the time. This is one of the reasons why linear algebra has become so important in computer science; for loops are just hard for human intuition to deal with.
- The constraint of only allowing columns with floats beyond requirement 4 is simply because you have not learnt about maps. In python they are called dictionaries which makes much more sense to the common person. Simply map non float columns to float with some sort of schema and you will be able to use the non float columns in your models.
- The distributed computing additional feature requires good networking fundamentals and it is not recommended you try it unless you’re prepared for that. For those who do, it is pretty simple in abstract. You basically need to have a master node that delegates tasks to its workers. The schema you choose to specify tasks and manage the worker-master relationship is up to your creativity. Do notify the question author if you want to attempt it as he would love for you to go through your idea with him. However, again, don’t suffer over it please.
- You can implement an unsupervised learning algorithm for the buzzword additional feature if you wish. However, be warned that unsupervised learning algorithms are not as straightforward as supervised ones as your goal is not always clear. But if you understand it quite well and think you can explain it, go ahead!
- If you try a reinforcement learning algorithm, please notify the problem author. He would love to hear you explain it.
- There’s an amazing website called kaggle.com with a lot of data science competitions. If you found this assignment interesting. Feel free to continue learning about data science using kaggle.
