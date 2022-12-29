class Fi:
  #For sorting in auto_correct
  def score_sort(e):
    return e[1]
  
  """
    If parts of the word or nearly resembling parts of the word are in the request, then
    return those keywords that are relatable.
    (So a user could specify their input)
    If the word matches, then the a str will be returned
    If the word doesn't match the keywords directly, then a list of words will be returned
  """
  def auto_correct(msg, keywords):
    request = input(msg +"\n")
    #Check if the request actually has some of the keywords and return such keywords.
      #If so, get those keywords in order to offer choices
    if request in keywords:
      return request
    else:
      ratioed_options = []
      for word in keywords: 
        #start from the beginning of the requested word.
        # Start from a single letter in the request, and then 
        score = Fi.get_score(request,word)
        if score >= 0.49:
          ratioed_options.append((word,score))
      ratioed_options.sort(reverse=True,key=Fi.score_sort)
      # print(ratioed_options)
      options = []
      print(options)
      for tuple in ratioed_options:
        options.append(tuple[0])
      return options
    
  def get_score(reference, word):
    o_len = len(reference)
    total_streaked_letters = 0
    index = 0
    #Remove set of letters each time.
    while(index < len(word)):
      end = index + 1
      # print("Index:",index)
      # print("end:",end)
      # print(word)
      # print(reference[index:end])
  
      #Compare the reference to the actual word
      while reference.find(word[index:end],index,end) != -1 and end < o_len:
        # print("index in loop",index)
        # print(word[index:end])
        total_streaked_letters += 1
        end += 1
  
      #remove part of word
      word = word[0:index] + word[end:]
      if end != 1:
        index += 1
    # return total_streaked_letters
    return total_streaked_letters/(len(reference)-1)
  
  def format_keywords(keywords):
    #Remove copies
    for first in range(0,len(keywords)):
      sec = first + 1
      while(sec < len(keywords)):
        if keywords[first] == keywords[sec]:
          keywords.pop(sec)
        else:
          sec += 1
    return keywords
  
  #When input is a sentence.
  def is_keywords_in(request,keywords):
      for word in request.split():
          if word in keywords:
              return True
      #If there is a word with a space in the keywords, compare that word. Ultimately tells if the inputted msg is in the keywords or not.
      return Fi.handle_spaced_keywords(request,keywords)
  
  
  """
    Takes in a list and allows the user to pick certain options based on the list
  """
  # if keyword encountered has a space, then compare the first word of that keyword to the request
  def handle_spaced_keywords(request,keywords):
      for word in keywords:
          if " " in word:
              combo = 0
              listed_keyword = word.split()
              while combo < len(listed_keyword) and listed_keyword[combo] in request:
                  combo += 1
              if combo == len(listed_keyword):
                  return True
      return False
  
  def get_yes_or_no(text):
    user_i = input(text+ "\n")
    while True:
      if user_i.lower() in ["y","yes"]:
          return True
      elif user_i.lower() in ["n","no"]:
          return False
      user_i = input("Input invalid. Please enter 'Y' or 'N'\n")

  def num_list(length):
    to_r = []
    for i in range(length):
      to_r.append(i)
    return to_r

  """
  Hell
  
  "That sounds like masochism. Why would you do that to yourself???" - other Daniel

  Needs to be reworked
  """
  def input(request,keywords,skip_formatting = False):
    #Format keywords (in case)
    if not skip_formatting:
      keywords = Fi.format_keywords(keywords)
    stem = Fi.auto_correct(request,keywords)
    #User input is satisfactory w/o user interaction = break from loop and return word.
    print()
    #Prevents massive resource pain.
    if type(stem) == str:
      return stem
    #At this moment, he knew, he ****** up.
    else:
      if(len(stem) > 1):
        print("Did you mean...")
        i = 1
        #Print choices
        for word in stem:
          print(str(i) + ". " + word)
          i += 1
        
        #Bring over a list to choose
        while(True):
          choice = input("\nType a number corresponding to the list above or press enter to redo input.\n")
          #User retypes input --> Recursive func
          if choice == "":
            return Fi.input("Retype your request\n",keywords)
          #User puts digit
          elif choice.isdigit():
            if int(choice) in Fi.num_list(len(stem)):
                return stem[int(choice)-1]
            else:
              print("Value is invalid: value must be between %s and %s (inclusive)" % (1,(len(stem))))
          elif choice in stem:
            return choice
          else:
            print("Invalid input. Please retype your input!")
      #Scenario in which there is only 1 word
      elif(len(stem) == 1):
        if Fi.get_yes_or_no("Did you mean %s? Type Y or N" % stem[0]):
          return stem[0]
        else:
          Fi.input("Please retype your input",keywords)
      else:
        return Fi.input("Invalid input. Please retype your input!",keywords)
        
  
#Test Case
keywords = ["Samuel","Sam","Back","Ratatata","Amanda","Shelly","Shel","Sam","Slipstream","Doom","Slayer","Amalia"]
while True:
  print("You've said", Fi.input("Input a name.",keywords))
  print()