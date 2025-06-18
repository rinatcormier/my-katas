with open("test.txt") as file:
    words_counter = dict()
    for line in file:
        words = line.strip().lower().split()
        for word in words:
            if word not in words_counter:
                words_counter[word] = 1
            else:
                words_counter[word] += 1
    max_count = max(words_counter.values())
    most_frequently_words = list()
    for key, value in words_counter.items():
        if value == max_count:
            most_frequently_words.append(key + ":" + str(value))
    most_frequently_words.sort()
    for word_with_counter in most_frequently_words:
        word, counter = word_with_counter.split(":")
        print(word, counter)
