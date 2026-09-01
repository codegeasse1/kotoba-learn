package com.nexo.kotoba

/**
 * Example sentences for every English vocabulary word.
 *
 * Words from the English level lessons (A1-C2 / IELTS) and the vocabulary
 * bank have hand-crafted example sentences. Remaining words (mostly from the
 * Oxford 5000 list) fall back to part-of-speech template sentences so that
 * every word always has at least three usage examples.
 */
object Examples {

    private val CURATED: Map<String, List<String>> = mapOf(
        "a" to listOf("I have a small dog.", "She is a talented artist.", "Give me a hand here."),
        "a double-edged sword" to listOf("Fame is often a double-edged sword.", "This new law is a double-edged sword.", "His talent can be a double-edged sword."),
        "a moot point" to listOf("That is a moot point now.", "It's a moot point since we lost.", "Whether it rains is a moot point."),
        "about" to listOf("Tell me about your day.", "It is about five o'clock.", "I am thinking about it."),
        "abroad" to listOf("She wants to study abroad next year.", "Have you ever traveled abroad?", "He is currently working abroad."),
        "accomplish" to listOf("We can accomplish this goal together.", "I didn't accomplish much today.", "How much did you accomplish?"),
        "accordingly" to listOf("Please read the rules and act accordingly.", "He was warned and acted accordingly.", "The price rose, and budgets changed accordingly."),
        "achieve" to listOf("You can achieve anything with hard work.", "Did she achieve her targets?", "It takes time to achieve success."),
        "acknowledge" to listOf("Please acknowledge that you received this.", "He refused to acknowledge the mistake.", "They finally acknowledged the problem."),
        "active" to listOf("My dog is very active.", "Stay active by walking every day.", "Is the account still active?"),
        "actor" to listOf("He is a famous Hollywood actor.", "Which actor played the lead role?", "She is a talented stage actor."),
        "advocate" to listOf("She is a strong advocate for kids.", "He advocates for better healthcare.", "Who is the lead advocate here?"),
        "afternoon" to listOf("See you tomorrow afternoon.", "I have a meeting this afternoon.", "The afternoon sun is very hot."),
        "again" to listOf("Can you say that again?", "Let's try it again.", "See you again tomorrow."),
        "airplane" to listOf("The airplane landed on time.", "I have never flown in an airplane.", "The airplane is taking off now."),
        "airport" to listOf("I will meet you at the airport.", "The airport was crowded today.", "We arrived at the airport early."),
        "albeit" to listOf("It was a fun trip, albeit expensive.", "He agreed, albeit with some hesitation.", "The progress is slow, albeit steady."),
        "also" to listOf("I also like pizza.", "He is also a teacher.", "She also speaks French."),
        "always" to listOf("I always wake up early.", "She is always happy.", "It always rains in April."),
        "ambiguous" to listOf("The instructions were too ambiguous.", "His answer remained ambiguous.", "The ending of the movie was ambiguous."),
        "ambition" to listOf("Her ambition is to become CEO.", "He lacks any real ambition.", "Ambition drives him to work hard."),
        "amendment" to listOf("The law needs a small amendment.", "They proposed an amendment to the contract.", "This amendment changes the whole deal."),
        "an" to listOf("I ate an apple today.", "It was an honest mistake.", "Do you have an idea?"),
        "analysis" to listOf("The blood analysis came back negative.", "This data analysis takes a long time.", "Her analysis of the book was brilliant."),
        "and" to listOf("I like tea and coffee.", "She sang and danced.", "Bread and butter are here."),
        "angry" to listOf("Why are you so angry?", "He got angry at the driver.", "She looked angry during the meeting."),
        "answer" to listOf("Please answer the phone.", "Do you know the answer?", "His answer was very surprising."),
        "ant" to listOf("An ant is carrying a crumb.", "Look at that tiny ant.", "The ant colony is huge."),
        "any" to listOf("Do you have any milk?", "Is there any hope?", "I don't see any."),
        "apartment" to listOf("I live in a small apartment.", "Her apartment is near the park.", "We are renting a new apartment."),
        "app" to listOf("I downloaded a new fitness app.", "This app saves a lot of time.", "Which app do you use most?"),
        "apple" to listOf("I ate a red apple.", "Do you want an apple?", "The apple is very juicy."),
        "arcade" to listOf("Let's go to the game arcade.", "The arcade has many old games.", "We spent all our coins at the arcade."),
        "architect" to listOf("He is a famous modern architect.", "The architect designed the new library.", "She wants to be an architect."),
        "arguably" to listOf("This is arguably the best pizza here.", "He is arguably the fastest player.", "It is arguably the most difficult part."),
        "argue" to listOf("They always argue about the laundry.", "Please do not argue with me.", "We shouldn't argue in public."),
        "argument" to listOf("We had a huge argument yesterday.", "Your argument makes a lot of sense.", "They settled their argument quickly."),
        "arm" to listOf("He broke his arm playing soccer.", "She held the baby in her arm.", "My arm is falling asleep."),
        "arrive" to listOf("What time does the train arrive?", "We will arrive at noon.", "When did the guests arrive?"),
        "article" to listOf("I read an interesting article today.", "This article explains the new law.", "She wrote an article for the paper."),
        "as a result" to listOf("He lied and, as a result, lost trust.", "It rained, and as a result, we stayed home.", "She studied hard; as a result, she passed."),
        "ascertain" to listOf("We need to ascertain the cause.", "I cannot ascertain the exact date.", "He tried to ascertain her location."),
        "assert" to listOf("You must assert your rights.", "She continued to assert her innocence.", "He asserts that the plan works."),
        "assumption" to listOf("That is a very bold assumption.", "My assumption was completely wrong.", "Don't make an assumption about her."),
        "astronaut" to listOf("The astronaut floated in space.", "He dreams of becoming an astronaut.", "The astronaut landed on the moon."),
        "at" to listOf("Meet me at the station.", "He is at work now.", "I am at the door."),
        "at the expense of" to listOf("He won at the expense of others.", "Don't grow at the expense of quality.", "Success came at the expense of sleep."),
        "athlete" to listOf("She is a professional Olympic athlete.", "He is a very talented athlete.", "The athlete trained every single morning."),
        "attitude" to listOf("He has a very positive attitude.", "Her attitude toward work is great.", "Change your attitude or leave."),
        "aunt" to listOf("My aunt lives in New York.", "She is my father's sister and aunt.", "My aunt baked a chocolate cake."),
        "author" to listOf("Who is the author of this book?", "The author signed my copy.", "She is a best-selling author."),
        "baby" to listOf("The baby is sleeping soundly.", "My sister just had a baby.", "The baby is learning to walk."),
        "back" to listOf("Please come back home soon.", "My back hurts from the chair.", "He patted me on the back."),
        "backpack" to listOf("Put your books in your backpack.", "Her backpack is too heavy.", "I bought a new leather backpack."),
        "bad" to listOf("This milk smells really bad.", "I have a bad headache.", "That was a very bad idea."),
        "bad-tasting" to listOf("This medicine is very bad-tasting.", "I hate this bad-tasting soup.", "The tea was surprisingly bad-tasting."),
        "baker" to listOf("The baker makes fresh sourdough.", "He is the best baker in town.", "Ask the baker for a loaf."),
        "bakery" to listOf("The bakery smells like cinnamon.", "Let's go to the local bakery.", "She opened a small French bakery."),
        "balanced" to listOf("I try to eat a balanced diet.", "The budget is finally balanced.", "She has a very balanced perspective."),
        "balcony" to listOf("I love reading on my balcony.", "Put the plants on the balcony.", "The cat jumped off the balcony."),
        "banana" to listOf("Eat a banana for a snack.", "This banana is too green.", "I sliced a banana for cereal."),
        "bank" to listOf("I need to visit the bank.", "The bank is closed on Sundays.", "Put the money in the bank."),
        "bat" to listOf("He swung the bat hard.", "A bat flew into the cave.", "We need a new baseball bat."),
        "bath" to listOf("I need a warm bath.", "The baby is in the bath.", "Take a bath before dinner."),
        "bathroom" to listOf("Where is the nearest bathroom?", "The bathroom floor is wet.", "Please clean the guest bathroom."),
        "be" to listOf("I want to be a doctor.", "Be careful with that glass.", "Please be quiet in the library."),
        "bear" to listOf("We saw a bear in woods.", "That bear is very large.", "Do not feed the wild bear."),
        "beautiful" to listOf("This sunset is absolutely beautiful.", "She wore a beautiful red dress.", "The garden looks beautiful today."),
        "because" to listOf("I slept because I was tired.", "She cried because she lost it.", "He smiled because he was happy."),
        "bed" to listOf("I am going to bed now.", "The dog sleeps on my bed.", "Make your bed every morning."),
        "bedroom" to listOf("My bedroom is very small.", "She painted her bedroom blue.", "He is tidying his bedroom."),
        "beef" to listOf("I prefer beef over chicken.", "We are having roast beef.", "This beef steak is tender."),
        "beer" to listOf("He ordered a cold beer.", "Do you like craft beer?", "I only drink beer occasionally."),
        "begin" to listOf("Let us begin the meeting.", "When does the movie begin?", "The show will begin shortly."),
        "behaviour" to listOf("His behaviour was very strange.", "Good behaviour earns a reward.", "The child's behaviour improved."),
        "between" to listOf("Sit between us.", "It is between two cities.", "Choose between these two."),
        "big" to listOf("That is a big house.", "He has big plans for summer.", "I made a big mistake."),
        "bike" to listOf("I ride my bike to work.", "My bike has a flat tire.", "She bought a new electric bike."),
        "bird" to listOf("A bird is on the fence.", "That bird sings every morning.", "The blue bird flew away."),
        "birthday" to listOf("Happy birthday to my sister!", "When is your birthday?", "We had a big birthday party."),
        "blizzard" to listOf("The blizzard stopped the traffic.", "We were trapped in a blizzard.", "A blizzard is coming tonight."),
        "blood" to listOf("He has a blood test tomorrow.", "Blood is red in color.", "Stop the blood with a bandage."),
        "blouse" to listOf("She wore a white blouse.", "This silk blouse is expensive.", "Wash the blouse by hand."),
        "boat" to listOf("The boat is on the lake.", "We rented a small fishing boat.", "He steered the boat carefully."),
        "body" to listOf("Exercise is good for the body.", "The body needs plenty of water.", "He has a strong body."),
        "bone" to listOf("The dog chewed a bone.", "He broke a bone in his arm.", "This fish has many bones."),
        "book" to listOf("I need to book a flight.", "Read this book for class.", "Can you book the table?"),
        "bookstore" to listOf("Let's meet at the bookstore.", "This bookstore has great coffee.", "I spent hours in the bookstore."),
        "bored" to listOf("I'm bored with this movie.", "He looked bored during the meeting.", "The kids are getting bored."),
        "boring" to listOf("That lecture was so boring.", "This book is a bit boring.", "Stop telling boring stories."),
        "brain" to listOf("Exercise is good for your brain.", "Use your brain to solve this.", "My brain feels like mush."),
        "bread" to listOf("Please buy a loaf of bread.", "I love the smell of fresh bread.", "Do you want toasted bread?"),
        "breakfast" to listOf("What did you have for breakfast?", "I usually skip breakfast.", "Breakfast is served until ten."),
        "bridge" to listOf("Walk across the bridge slowly.", "The bridge is closed for repairs.", "We crossed the bridge together."),
        "bring about" to listOf("New laws can bring about change.", "What brought about this decision?", "Hard work brings about success."),
        "broadcast" to listOf("The news is broadcast live.", "They broadcast the game nationwide.", "When will the report broadcast?"),
        "brother" to listOf("My brother lives in London.", "Do you have a younger brother?", "He is my only brother."),
        "budget" to listOf("We are on a tight budget.", "I need to plan my budget.", "This project is over budget."),
        "builder" to listOf("The builder is arriving tomorrow.", "We hired a professional builder.", "He is a skilled house builder."),
        "bus" to listOf("I take the bus to work.", "The bus is running late.", "Wait for the next bus."),
        "bus stop" to listOf("Meet me at the bus stop.", "There is a bus stop nearby.", "He waited at the bus stop."),
        "busy" to listOf("I have a very busy day.", "The street is always busy.", "Are you busy right now?"),
        "but" to listOf("I like it but it's pricey.", "He is small but strong.", "I tried but I failed."),
        "butcher shop" to listOf("I bought steak at the butcher shop.", "The butcher shop closes at five.", "Visit the local butcher shop."),
        "butter" to listOf("Put some butter on the toast.", "Do we have any salted butter?", "The butter is in the fridge."),
        "butterfly" to listOf("A butterfly landed on the flower.", "Look at that colorful butterfly.", "The butterfly flew away quickly."),
        "button" to listOf("Press the red button now.", "My shirt is missing a button.", "Push the button to start."),
        "buy" to listOf("Where can I buy tickets?", "I want to buy a car.", "Did you buy any milk?"),
        "by" to listOf("I go to work by bus.", "The book was written by him.", "Stand by the door."),
        "by the same token" to listOf("He is smart; by the same token, he is arrogant.", "It is fast; by the same token, it is risky.", "She is kind; by the same token, she is firm."),
        "cafe" to listOf("Let's meet at the cafe.", "This cafe has great pastries.", "I read books at the cafe."),
        "camp" to listOf("We plan to camp here.", "They set up camp by the river.", "Do you like to camp?"),
        "campaign" to listOf("The political campaign starts tomorrow.", "This ad campaign is very successful.", "She led the cleaning campaign."),
        "can" to listOf("Can you help me move this?", "I can speak a little Spanish.", "We can meet after work."),
        "cap" to listOf("Put the cap back on the pen.", "I bought a new baseball cap.", "The bottle cap is too tight."),
        "car" to listOf("My car is in the shop.", "We took the car to the city.", "She drives an electric car."),
        "career" to listOf("He wants a career in law.", "It takes time to build a career.", "She is changing her career path."),
        "carry out" to listOf("Please carry out my instructions.", "They will carry out the plan.", "We need to carry out a test."),
        "cat" to listOf("The cat is sleeping on the sofa.", "My cat likes to chase birds.", "Do you have a pet cat?"),
        "ceiling" to listOf("There is a leak in the ceiling.", "The ceiling is very high here.", "Paint the ceiling white."),
        "chair" to listOf("Take a seat in this chair.", "This office chair is very comfortable.", "Please move the chair aside."),
        "channel" to listOf("Change the channel to the news.", "Which channel is the game on?", "I found a great cooking channel."),
        "character" to listOf("He is a strong character.", "This movie has a great lead character.", "She is a very honest character."),
        "cheap" to listOf("This watch was very cheap.", "Cheap flights are hard to find.", "I bought some cheap snacks."),
        "cheese" to listOf("I love cheddar cheese.", "Put some cheese on the pizza.", "Do you like goat cheese?"),
        "chef" to listOf("The chef cooked a great meal.", "He is a professional pastry chef.", "Ask the chef for the recipe."),
        "chest" to listOf("He felt a pain in his chest.", "The treasure was in the chest.", "Put the book on my chest."),
        "chest of drawers" to listOf("Put your socks in the chest of drawers.", "This chest of drawers is too heavy.", "I bought a wooden chest of drawers."),
        "chicken" to listOf("We are having roast chicken tonight.", "The chicken is crossing the road.", "Do you prefer chicken or beef?"),
        "child" to listOf("The child is playing with toys.", "Every child needs a good education.", "She is an only child."),
        "children's room" to listOf("The children's room is a mess.", "We painted the children's room blue.", "There are toys in the children's room."),
        "chocolate" to listOf("I want some dark chocolate.", "This chocolate cake is delicious.", "Do you like milk chocolate?"),
        "city" to listOf("New York is a huge city.", "I love living in the city.", "Which city are you visiting?"),
        "claim" to listOf("He tried to claim the prize.", "You can claim your expenses here.", "She made a bold claim."),
        "clarify" to listOf("Could you clarify your point?", "I need to clarify the rules.", "Please clarify the instructions."),
        "class" to listOf("I have an English class today.", "The class starts at nine.", "She is the best in the class."),
        "climate" to listOf("This region has a tropical climate.", "The climate is getting warmer.", "We prefer a cold climate."),
        "climate change" to listOf("Climate change affects the whole planet.", "We must fight climate change.", "What causes climate change?"),
        "close" to listOf("Please close the door.", "The store is close to my house.", "We are very close friends."),
        "cloudy" to listOf("It looks too cloudy for a picnic.", "The sky is cloudy today.", "It’s a cloudy afternoon."),
        "coach" to listOf("My coach is very strict.", "She is the soccer coach.", "He works as a life coach."),
        "coat" to listOf("Put on your winter coat.", "This coat is too big.", "Hang your coat on the rack."),
        "coffee" to listOf("I need some coffee now.", "Do you drink black coffee?", "Let's grab a coffee together."),
        "coherence" to listOf("The essay lacks overall coherence.", "Her argument had no coherence.", "We need more coherence here."),
        "coherent" to listOf("The plan is finally coherent.", "He was barely coherent after sleep.", "Please give me a coherent answer."),
        "cold" to listOf("It is freezing cold outside.", "I have a bad cold.", "The water feels very cold."),
        "cold wind" to listOf("A cold wind blew north.", "The cold wind bit my cheeks.", "I can't stand this cold wind."),
        "collaborate" to listOf("Let's collaborate on this project.", "We need to collaborate more.", "They collaborate with local artists."),
        "colleague" to listOf("She is a trusted colleague.", "My colleague is on vacation.", "I work with a helpful colleague."),
        "come" to listOf("Please come to the party.", "When will you come home?", "Come here for a second."),
        "come up with" to listOf("Come up with a plan.", "She came up with an idea.", "Can you come up with a solution?"),
        "community" to listOf("We live in a small community.", "This is a friendly community.", "They support the local community."),
        "commute" to listOf("My commute takes one hour.", "I hate my daily commute.", "Do you commute by train?"),
        "company" to listOf("He started a software company.", "I enjoy your company.", "The company is hiring new staff."),
        "comprehensive" to listOf("This is a comprehensive guide.", "The report was very comprehensive.", "We need a comprehensive list."),
        "computer" to listOf("My computer is very slow.", "Turn off the computer now.", "I bought a new computer."),
        "concede" to listOf("He had to concede defeat.", "I concede that you are right.", "They refused to concede the point."),
        "conclusion" to listOf("I reached a different conclusion.", "The conclusion was quite surprising.", "What is your final conclusion?"),
        "confidence" to listOf("She has a lot of confidence.", "I have confidence in you.", "This will boost your confidence."),
        "conflict" to listOf("We have a schedule conflict.", "This is a major conflict.", "They tried to resolve the conflict."),
        "consciousness" to listOf("He slowly regained consciousness.", "She lost consciousness for a moment.", "It affects human consciousness."),
        "consensus" to listOf("They finally reached a consensus.", "There is no general consensus.", "We need a group consensus."),
        "consequently" to listOf("It rained, consequently the game stopped.", "He lied and consequently lost trust.", "She failed, consequently she retook it."),
        "considerable" to listOf("This requires a considerable amount of time.", "There is considerable interest in this.", "He spent a considerable sum."),
        "consist" to listOf("The cake consists of flour and eggs.", "These kits consist of five basic tools.", "Most meals consist of rice and fish."),
        "constitution" to listOf("He has a very strong constitution.", "The constitution protects our basic rights.", "The new constitution was signed today."),
        "contend" to listOf("They contend that the price is too high.", "She will contend for the gold medal.", "I contend that we need more time."),
        "contribute" to listOf("Everyone should contribute to the project.", "He contributes money to the local shelter.", "Do you want to contribute an idea?"),
        "convenience store" to listOf("I stopped at the convenience store for milk.", "The convenience store is open twenty-four hours.", "Is there a convenience store nearby?"),
        "conversely" to listOf("He loves tea; conversely, she prefers coffee.", "Some like heat; conversely, others hate it.", "It's fast, but conversely, it's very expensive."),
        "cooking" to listOf("My mother is great at cooking pasta.", "Cooking dinner takes a long time.", "I enjoy cooking for my friends."),
        "cool" to listOf("The weather is finally getting cool.", "That is a really cool jacket.", "Let's wait for the engine to cool."),
        "correlation" to listOf("There is a correlation between diet and health.", "I see no correlation between the two events.", "This study shows a strong correlation."),
        "corroborate" to listOf("The witness could corroborate his story.", "New evidence will corroborate the claim.", "Can you corroborate her version of events?"),
        "cough" to listOf("He has a loud, dry cough.", "Please cover your mouth when you cough.", "This syrup helps soothe a cough."),
        "could" to listOf("Could you open the window?", "He could be at home.", "I could not find my keys."),
        "country" to listOf("Which country are you from?", "They moved to a different country.", "The country is known for its mountains."),
        "course" to listOf("I am taking a course in history.", "The golf course is closed today.", "Please stay on the main course."),
        "cousin" to listOf("My cousin lives in New York.", "She is my favorite female cousin.", "Do you have any cousins?"),
        "cow" to listOf("The cow is eating the grass.", "A cow provides milk for the farm.", "Look at that big brown cow."),
        "crisis" to listOf("The government is facing a financial crisis.", "We need a plan to handle this crisis.", "It was a personal crisis for him."),
        "criteria" to listOf("What are the criteria for this job?", "He meets all the necessary criteria.", "The criteria for selection are very strict."),
        "crocodile" to listOf("A crocodile is hiding in the river.", "Be careful of the crocodile.", "The crocodile has very sharp teeth."),
        "culture" to listOf("I love learning about different culture.", "Food is a big part of culture.", "They are adjusting to the new culture."),
        "curry" to listOf("This chicken curry is very spicy.", "I ordered a vegetable curry.", "Do you like Indian curry?"),
        "custom" to listOf("It is a local custom to bow.", "This custom has existed for centuries.", "We followed the traditional wedding custom."),
        "dancing" to listOf("She is very good at dancing.", "We spent the night dancing.", "Dancing is a great way to exercise."),
        "data" to listOf("We need to analyze the data.", "The data shows a clear trend.", "Where can I find the raw data?"),
        "daughter" to listOf("Their daughter starts school tomorrow.", "She is the only daughter.", "My daughter loves to paint."),
        "daughter-in-law" to listOf("My daughter-in-law is a doctor.", "She gets along with her daughter-in-law.", "I bought a gift for my daughter-in-law."),
        "day" to listOf("I had a long day at work.", "What day is it today?", "It was a rainy day in London."),
        "deadline" to listOf("The deadline is tomorrow at noon.", "We missed the filing deadline.", "Can we extend the deadline?"),
        "debt" to listOf("He is struggling to pay his debt.", "They are finally out of debt.", "National debt is rising quickly."),
        "decline" to listOf("Sales began to decline last month.", "He decided to decline the offer.", "The population continues to decline."),
        "deer" to listOf("A deer ran across the road.", "Look at that deer in the woods.", "Deer love eating garden plants."),
        "degree" to listOf("She has a degree in history.", "It was a first-degree burn.", "He is a degree away from finishing."),
        "degrees" to listOf("It is thirty degrees outside today.", "Water boils at one hundred degrees.", "The angle is forty-five degrees."),
        "delegate" to listOf("I need to delegate more tasks.", "He was chosen as the delegate.", "Please delegate this to the team."),
        "delicious" to listOf("This chocolate cake is delicious.", "The dinner smelled delicious.", "That was a delicious meal."),
        "delineate" to listOf("Please delineate the boundary lines.", "The map helps delineate the border.", "He failed to delineate the goals."),
        "demonstrate" to listOf("Can you demonstrate how it works?", "The teacher will demonstrate the experiment.", "He demonstrated his skill on stage."),
        "dentist" to listOf("I have a dentist appointment tomorrow.", "The dentist cleaned my teeth.", "My dentist is very gentle."),
        "department store" to listOf("We bought a dress at the department store.", "The department store is having a sale.", "Meet me at the department store."),
        "desert" to listOf("It rarely rains in the desert.", "The Sahara is a vast desert.", "They got lost in the desert."),
        "desk" to listOf("My desk is covered in papers.", "Put the lamp on your desk.", "He sat at his desk all day."),
        "dessert" to listOf("What should we have for dessert?", "I want ice cream for dessert.", "This apple tart is a great dessert."),
        "development" to listOf("The city is seeing rapid development.", "This is a new product development.", "Child development is a complex topic."),
        "diet" to listOf("I am on a strict diet.", "A balanced diet is important.", "She changed her diet to feel better."),
        "difficult" to listOf("This math problem is very difficult.", "It was a difficult decision to make.", "Learning a language is difficult."),
        "dinner" to listOf("What is for dinner tonight?", "We had dinner at seven.", "Let's go out for dinner."),
        "direction" to listOf("Which direction are we heading?", "Follow the direction of the arrow.", "He gave us the wrong direction."),
        "discovery" to listOf("The discovery changed science forever.", "This was a surprising discovery.", "They made a discovery in the cave."),
        "discrepancy" to listOf("There is a discrepancy in the bill.", "We found a discrepancy in the data.", "Explain the discrepancy in your story."),
        "do" to listOf("What do you do for a living?", "I can do the laundry now.", "Just do your best today."),
        "doctor" to listOf("The doctor gave me some medicine.", "I need to see a doctor.", "She is a qualified doctor."),
        "doctrine" to listOf("The party's core doctrine is changing.", "He follows a strict religious doctrine.", "That political doctrine is outdated now."),
        "dog" to listOf("My dog loves chasing tennis balls.", "Who is walking the dog today?", "I need to feed the dog."),
        "dolphin" to listOf("A dolphin jumped out of the water.", "Dolphins are very intelligent animals.", "We saw a dolphin near the boat."),
        "donation" to listOf("I made a small cash donation.", "Thank you for your generous donation.", "The charity accepted the clothing donation."),
        "door" to listOf("Please close the door behind you.", "Someone is knocking at the front door.", "The door is locked from inside."),
        "down" to listOf("Sit down, please.", "The sun goes down.", "Put the bag down."),
        "download" to listOf("I need to download the app.", "The download is taking too long.", "Where can I download the file?"),
        "downpour" to listOf("We got soaked in the downpour.", "The sudden downpour ruined the party.", "A heavy downpour flooded the street."),
        "dress" to listOf("She wore a blue summer dress.", "This dress is too long for me.", "You should wear a formal dress."),
        "drink" to listOf("Would you like something to drink?", "I need a cold drink now.", "He took a sip of his drink."),
        "driver" to listOf("The taxi driver was very friendly.", "Is he a licensed truck driver?", "The driver stopped at the red light."),
        "duck" to listOf("A duck is swimming in the pond.", "Look at that yellow rubber duck.", "The duck waddled across the grass."),
        "eagle" to listOf("An eagle soared above the mountains.", "The eagle has very sharp vision.", "I saw an eagle in the tree."),
        "ear" to listOf("She whispered something in my ear.", "My left ear is hurting today.", "He has a keen ear for music."),
        "earrings" to listOf("These gold earrings were a gift.", "She is wearing small pearl earrings.", "I lost one of my earrings."),
        "earth" to listOf("The earth orbits around the sun.", "We must protect the earth's resources.", "Plants grow in the rich earth."),
        "easy" to listOf("This math test was very easy.", "It is easy to get lost here.", "Following the recipe is quite easy."),
        "eat" to listOf("What do you want to eat?", "I like to eat fresh fruit.", "Let's eat dinner at six tonight."),
        "economy" to listOf("The global economy is struggling now.", "He studied the local economy.", "Low interest rates help the economy."),
        "egg" to listOf("I had a boiled egg for breakfast.", "Do we have any eggs left?", "She cracked an egg into the bowl."),
        "eight" to listOf("The meeting starts at eight o'clock.", "He has eight apples in his bag.", "My sister is eight years old."),
        "elephant" to listOf("An elephant has a long trunk.", "We saw a wild elephant today.", "Elephants are the largest land animals."),
        "elevator" to listOf("The elevator is out of order.", "Take the elevator to the fifth floor.", "I prefer the stairs to the elevator."),
        "eleven" to listOf("There are eleven players on the team.", "The child is eleven years old.", "I have eleven emails to answer."),
        "eloquent" to listOf("She gave an eloquent speech today.", "His writing style is very eloquent.", "He is an eloquent public speaker."),
        "elucidate" to listOf("Could you please elucidate that point?", "The teacher tried to elucidate the concept.", "Further details will elucidate the matter."),
        "emphasize" to listOf("Please emphasize the main points.", "I want to emphasize this detail.", "Let me emphasize the risk."),
        "energy" to listOf("I have no energy today.", "This drink gives me energy.", "Solar energy is getting cheaper."),
        "entrance" to listOf("Where is the main entrance?", "Meet me at the entrance.", "The entrance was blocked by snow."),
        "environment" to listOf("We must protect our environment.", "It is a stressful environment.", "Plants need a warm environment."),
        "equality" to listOf("They fight for gender equality.", "We believe in legal equality.", "Equality is a basic human right."),
        "ethics" to listOf("This is a question of ethics.", "Medical ethics are very strict.", "He studies professional ethics."),
        "evaluate" to listOf("We need to evaluate the results.", "I cannot evaluate your work yet.", "Let us evaluate the options."),
        "evening" to listOf("I will call you this evening.", "The evening was very quiet.", "What are your evening plans?"),
        "every day" to listOf("I drink coffee every day.", "She walks her dog every day.", "I learn English every day."),
        "evidence" to listOf("There is no evidence here.", "The police found new evidence.", "Do you have any evidence?"),
        "exacerbate" to listOf("Stress can exacerbate the pain.", "Don't exacerbate the problem.", "Cold weather will exacerbate it."),
        "exam" to listOf("I have a math exam.", "The exam was very difficult.", "When is your final exam?"),
        "excited" to listOf("I am excited for the trip.", "She is excited about her job.", "We are excited to meet you."),
        "exercise" to listOf("I need more daily exercise.", "This exercise is too hard.", "Do you exercise every morning?"),
        "exhibition" to listOf("The art exhibition opens today.", "I enjoyed the photo exhibition.", "Which exhibition is the best?"),
        "existential" to listOf("He is having an existential crisis.", "It is an existential threat.", "They discussed existential philosophy."),
        "expense" to listOf("Travel is a huge expense.", "This was an unexpected expense.", "We need to cut expenses."),
        "expensive" to listOf("This car is too expensive.", "Dinner was very expensive.", "I can't afford expensive clothes."),
        "experience" to listOf("I have five years of experience.", "It was a great experience.", "Do you have any experience?"),
        "experiment" to listOf("The science experiment failed.", "We tried a new experiment.", "This is just a social experiment."),
        "extrapolate" to listOf("We can extrapolate the data.", "Do not extrapolate the results.", "Try to extrapolate the trend."),
        "eye" to listOf("Something is in my eye.", "Keep an eye on him.", "She has a blue eye."),
        "face" to listOf("Wash your face with water.", "He has a smiling face.", "I cannot face the truth."),
        "facilitate" to listOf("This tool will facilitate work.", "A guide can facilitate travel.", "Let me facilitate the meeting."),
        "family" to listOf("I love my big family.", "My family lives in Spain.", "We have a family dinner."),
        "far" to listOf("The park is too far.", "How far is it?", "Go far away."),
        "farmer" to listOf("The farmer grows organic corn.", "My uncle is a dairy farmer.", "The farmer feeds the cows."),
        "fast" to listOf("This car is very fast.", "Don't walk too fast.", "He is a fast learner."),
        "father" to listOf("My father works in a bank.", "He is a great father.", "Call your father tonight."),
        "feasibility" to listOf("We are checking the project's feasibility.", "The feasibility study is complete.", "Is this plan even feasible?"),
        "festival" to listOf("The music festival starts tomorrow.", "We love the autumn festival.", "I bought food at the festival."),
        "fever" to listOf("The baby has a high fever.", "Drink water to break the fever.", "I feel warm and have a fever."),
        "finance" to listOf("She studies corporate finance.", "Personal finance is very important.", "He works in the finance department."),
        "finger" to listOf("I cut my index finger.", "Put your finger on the map.", "She wore a ring on her finger."),
        "finish" to listOf("Please finish your homework now.", "I will finish the book tonight.", "Did you finish the race?"),
        "firefighter" to listOf("The firefighter saved the cat.", "He is a brave firefighter.", "Firefighters wear heavy gear."),
        "fish" to listOf("I love eating grilled fish.", "There are fish in the pond.", "Can you fish in this lake?"),
        "fisherman" to listOf("The fisherman caught a huge bass.", "My grandfather was a fisherman.", "The fisherman cast his net."),
        "five" to listOf("I have five gold coins.", "It takes five minutes to walk.", "Give me five dollars, please."),
        "flight attendant" to listOf("The flight attendant served drinks.", "She is training as a flight attendant.", "Ask the flight attendant for help."),
        "floor" to listOf("The floor is made of wood.", "I dropped my phone on the floor.", "We live on the second floor."),
        "flower" to listOf("This flower smells very sweet.", "She picked a yellow flower.", "Water the flowers every morning."),
        "fluctuate" to listOf("Prices fluctuate every single day.", "Temperatures fluctuate during the spring.", "My mood tends to fluctuate."),
        "fog" to listOf("The fog covered the mountain.", "I can't see through the fog.", "Thick fog slowed down traffic."),
        "foggy" to listOf("It is a very foggy morning.", "The valley looked foggy today.", "Driving is hard in foggy weather."),
        "foot" to listOf("He stepped on my left foot.", "My foot hurts after the hike.", "The ruler is one foot long."),
        "for" to listOf("This gift is for you.", "I waited for two hours.", "Is this for sale?"),
        "for instance" to listOf("Use a tool, for instance, a hammer.", "For instance, we could go swimming.", "Take a fruit, for instance, an apple."),
        "forest" to listOf("We walked through the dark forest.", "Many animals live in the forest.", "The forest is very quiet here."),
        "four" to listOf("There are four chairs at the table.", "I have four siblings.", "The cake is cut into four pieces."),
        "fox" to listOf("A red fox ran past.", "The fox is very clever.", "We saw a fox in the garden."),
        "friday" to listOf("We go to the cinema every Friday.", "Friday is my favorite day.", "The report is due this Friday."),
        "friend" to listOf("She is my best friend.", "I need a friend to talk to.", "We have been friends for years."),
        "frog" to listOf("A small green frog jumped away.", "The frog sat on a leaf.", "I saw a frog in the pond."),
        "from" to listOf("I am from Canada.", "This gift is from Sarah.", "Walk away from the edge."),
        "fruit" to listOf("Do you like fresh fruit?", "Apples are my favorite fruit.", "Eat more fruit every day."),
        "fun" to listOf("This party is so much fun.", "We had fun at the beach.", "Learning English is really fun."),
        "furthermore" to listOf("It is cheap; furthermore, it is fast.", "The room is small; furthermore, it is cold.", "He is smart; furthermore, he is hardworking."),
        "gallery" to listOf("The art gallery is open today.", "We visited a local photo gallery.", "This gallery has a new exhibit."),
        "game" to listOf("Let's play a board game.", "The game ends at midnight.", "Who won the football game?"),
        "garden" to listOf("My grandmother has a beautiful garden.", "We planted roses in the garden.", "The garden needs more water."),
        "generous" to listOf("He is very generous with his time.", "Thank you for your generous gift.", "She is a generous person."),
        "get" to listOf("I need to get some milk.", "Did you get my email?", "It is getting late now."),
        "get up" to listOf("I usually get up at six.", "What time do you get up?", "Help me get up from the floor."),
        "give up" to listOf("Don't give up on your dreams.", "I will never give up now.", "He decided to give up smoking."),
        "glasses" to listOf("I can't find my reading glasses.", "Do these glasses look good?", "She wears glasses for reading."),
        "global" to listOf("Global warming is a serious issue.", "We live in a global economy.", "This is a global problem."),
        "gloves" to listOf("Wear your gloves in the snow.", "My gloves are too small.", "These leather gloves are expensive."),
        "go" to listOf("I have to go now.", "Let's go to the park.", "Where do you want to go?"),
        "go out" to listOf("Do you want to go out?", "They go out every Friday night.", "I don't feel like going out."),
        "goal" to listOf("My goal is to learn English.", "He scored a goal in the game.", "What is your main goal here?"),
        "goat" to listOf("The goat is eating the grass.", "I saw a goat on the hill.", "That goat is very stubborn."),
        "good" to listOf("This is a very good book.", "Have a good day!", "He is a good student."),
        "good afternoon" to listOf("Good afternoon, how are you?", "Good afternoon, class!", "Good afternoon, Mr. Smith."),
        "good evening" to listOf("Good evening, everyone.", "Good evening, may I help you?", "Good evening to you all."),
        "good morning" to listOf("Good morning, sleep well?", "Good morning, time to wake up.", "Good morning, how is your day?"),
        "goodbye" to listOf("It is time to say goodbye.", "Goodbye, see you tomorrow!", "She waved goodbye to me."),
        "gradual" to listOf("There was a gradual change in weather.", "The recovery was a gradual process.", "We saw a gradual increase in sales."),
        "grandchild" to listOf("She loves her only grandchild.", "He is his favorite grandchild.", "The grandchild is visiting today."),
        "granddaughter" to listOf("My granddaughter is starting school today.", "She is a spoiled granddaughter.", "I bought a gift for my granddaughter."),
        "grandfather" to listOf("My grandfather tells great stories.", "He is a retired grandfather.", "I visit my grandfather on Sundays."),
        "grandmother" to listOf("My grandmother bakes the best cookies.", "She is a loving grandmother.", "I live with my grandmother."),
        "grandparents" to listOf("My grandparents live in the countryside.", "They are very proud grandparents.", "We visit our grandparents every summer."),
        "grandson" to listOf("He is a talented grandson.", "My grandson loves playing soccer.", "I have one grandson and two granddaughters."),
        "grapes" to listOf("These green grapes are very sweet.", "Do you prefer red or green grapes?", "I bought a bunch of grapes."),
        "grass" to listOf("The grass needs to be cut.", "Don't walk on the grass.", "The dew is on the grass."),
        "green tea" to listOf("I drink green tea every morning.", "Green tea is very healthy.", "Would you like some green tea?"),
        "greengrocer" to listOf("The greengrocer has fresh apples today.", "I buy my fruit from the greengrocer.", "The local greengrocer is very friendly."),
        "guest" to listOf("We have a guest for dinner.", "Please make the guest feel welcome.", "She is a guest in our house."),
        "guide" to listOf("He is a professional tour guide.", "The guide showed us the castle.", "Read the user guide first."),
        "habit" to listOf("Biting nails is a bad habit.", "I have a habit of waking up early.", "It is hard to break a habit."),
        "hair" to listOf("She has long brown hair.", "My hair needs a trim.", "He has curly hair."),
        "hair salon" to listOf("I have an appointment at the hair salon.", "This hair salon is very expensive.", "Where is the nearest hair salon?"),
        "hairdresser" to listOf("My hairdresser is very talented.", "I need to call the hairdresser.", "The hairdresser cut my hair short."),
        "hand" to listOf("Please give me a hand with this.", "Wash your hands before eating.", "He held her hand tightly."),
        "handbag" to listOf("She left her handbag on the bus.", "This leather handbag was a gift.", "Put your phone in your handbag."),
        "happy" to listOf("I am so happy for you.", "They look like a happy couple.", "This news makes me very happy."),
        "hat" to listOf("Put on a hat for the sun.", "He wears a black hat.", "This hat is too small for me."),
        "have" to listOf("Do you have any siblings?", "I have a lot of work today.", "We have a meeting at noon."),
        "head" to listOf("My head hurts from the noise.", "He shook his head in disagreement.", "Put your head on the pillow."),
        "headache" to listOf("I have a terrible headache.", "This loud music is giving me a headache.", "Aspirin helps with a headache."),
        "headline" to listOf("The headline was very shocking.", "I read the headline in the news.", "That is a misleading headline."),
        "healthy" to listOf("Eating vegetables is a healthy habit.", "She looks very healthy and fit.", "I want to live a healthy life."),
        "heart" to listOf("My heart is beating fast.", "He has a very kind heart.", "Exercise is good for your heart."),
        "heavy" to listOf("This box is too heavy.", "It was a heavy rain.", "My bag feels very heavy."),
        "hello" to listOf("Hello, how are you today?", "Hello, please come inside.", "Hello, is anyone there?"),
        "help" to listOf("Can you help me move?", "I need some help here.", "Please help me find it."),
        "hence" to listOf("He lied, hence the trust.", "It rained, hence the delay.", "She's sick, hence the absence."),
        "here" to listOf("Come here right now.", "It is cold here.", "Put it here."),
        "hi" to listOf("Hi, what is your name?", "Hi, how is it going?", "Just say hi to them."),
        "high" to listOf("The prices are too high.", "That is a high wall.", "The bird flew high."),
        "high heels" to listOf("She wore red high heels.", "High heels hurt my feet.", "Put on your high heels."),
        "hill" to listOf("The house is on a hill.", "We ran down the hill.", "It is a steep hill."),
        "hold" to listOf("Please hold the door open.", "Can you hold my bag?", "Hold this for a second."),
        "honest" to listOf("Be honest with me now.", "He is an honest man.", "Give me your honest opinion."),
        "honey bee" to listOf("A honey bee stung me.", "The honey bee is yellow.", "Look at that honey bee."),
        "horse" to listOf("He rides a brown horse.", "The horse ran very fast.", "Can I feed the horse?"),
        "hospital" to listOf("She works at the hospital.", "The hospital is nearby.", "He is in the hospital."),
        "host" to listOf("Our host was very friendly.", "Who is the party host?", "The host welcomed the guests."),
        "hot" to listOf("The coffee is too hot.", "It is hot outside today.", "This soup is very hot."),
        "hotel" to listOf("We stayed at a hotel.", "Which hotel is the best?", "The hotel has a pool."),
        "hotel staff" to listOf("The hotel staff were helpful.", "Ask the hotel staff for help.", "The hotel staff is professional."),
        "hour" to listOf("I will be there in an hour.", "It takes one hour.", "Wait for another hour."),
        "house" to listOf("This is a big house.", "We are staying at home.", "My house is painted white."),
        "humid" to listOf("The air feels very humid.", "It is humid in Florida.", "I hate humid weather."),
        "humidity" to listOf("The humidity is very high.", "Low humidity dries the skin.", "Humidity makes me feel sticky."),
        "hundred" to listOf("It costs one hundred dollars.", "There are a hundred birds.", "I have a hundred ideas."),
        "hungry" to listOf("I am getting very hungry.", "Are you hungry for lunch?", "The baby is hungry now."),
        "husband" to listOf("Her husband is a doctor.", "My husband loves cooking.", "He is a kind husband."),
        "hypothesis" to listOf("My hypothesis was actually wrong.", "Test your hypothesis now.", "The hypothesis needs more proof."),
        "hypothesize" to listOf("Scientists hypothesize about the origin.", "Let us hypothesize the result.", "I hypothesize it will rain."),
        "ice" to listOf("Put some ice in it.", "The lake is made of ice.", "I need more ice cubes."),
        "ice cream" to listOf("Do you want chocolate ice cream?", "I love eating ice cream in summer.", "The ice cream is melting fast."),
        "ideology" to listOf("Their political ideology is very strict.", "It is a complex social ideology.", "He questioned the party's core ideology."),
        "if" to listOf("If it rains, stay home.", "I will go if you go.", "Tell me if you need help."),
        "immigration" to listOf("The new immigration laws are confusing.", "Immigration helps grow the local economy.", "She is studying international immigration patterns."),
        "implement" to listOf("We need to implement the new plan.", "When will they implement the changes?", "The company implemented a strict policy."),
        "implication" to listOf("This decision has a serious implication.", "What is the implication of that?", "He ignored the legal implication."),
        "improve" to listOf("I want to improve my English.", "This cream will improve your skin.", "We must improve our sales targets."),
        "in" to listOf("The keys are in my bag.", "He lives in a city.", "I will be there in ten."),
        "in addition" to listOf("In addition, we offer free shipping.", "She speaks French and, in addition, Spanish.", "In addition, the hotel has a gym."),
        "in conclusion" to listOf("In conclusion, we need more funding.", "In conclusion, the project was a success.", "In conclusion, please sign the form."),
        "in contrast" to listOf("He is tall; in contrast, his brother is short.", "In contrast, the city is very noisy.", "The red one is bright; in contrast, the blue is dark."),
        "in essence" to listOf("In essence, it is a simple machine.", "It is, in essence, a waste of time.", "In essence, we are all the same."),
        "in light of" to listOf("In light of the news, we paused.", "In light of the cost, we cancelled.", "The plan changed in light of the rain."),
        "in other words" to listOf("In other words, you are fired.", "In other words, it is too expensive.", "It is free; in other words, no cost."),
        "in the long run" to listOf("In the long run, this saves money.", "It will be better in the long run.", "In the long run, health is wealth."),
        "income" to listOf("My monthly income is quite low.", "They have a very high annual income.", "He earns a steady income now."),
        "inevitably" to listOf("The price will inevitably go up.", "Inevitably, we ran out of time.", "Mistakes will inevitably happen during the process."),
        "inherent" to listOf("There is an inherent risk in climbing.", "Patience is inherent to her personality.", "This system has an inherent flaw."),
        "insect" to listOf("A small insect landed on my arm.", "Which insect is this?", "Ants are very hardworking insects."),
        "interesting" to listOf("That is an interesting point of view.", "I read an interesting book yesterday.", "The movie was not very interesting."),
        "internet" to listOf("The internet is down again today.", "I found the answer on the internet.", "Do you have an internet connection?"),
        "intersection" to listOf("Turn left at the next intersection.", "There was a crash at the intersection.", "Wait for the light at the intersection."),
        "interview" to listOf("I have a job interview tomorrow.", "The interview lasted for one hour.", "She felt nervous during the interview."),
        "intricate" to listOf("The dress has an intricate pattern.", "This is a very intricate puzzle.", "The watch has an intricate mechanism."),
        "investment" to listOf("Buying a house is a good investment.", "He made a risky stock investment.", "This project requires a large investment."),
        "irrefutable" to listOf("The evidence against him is irrefutable.", "This is an irrefutable fact.", "Her logic was completely irrefutable."),
        "island" to listOf("They live on a small tropical island.", "We took a boat to the island.", "The island is famous for its beaches."),
        "issue" to listOf("We need to fix this issue.", "Is there a technical issue?", "That is a major issue."),
        "jacket" to listOf("Put on your winter jacket.", "This jacket is too small.", "I left my jacket here."),
        "jeans" to listOf("These jeans are very tight.", "Do you like these jeans?", "I bought new blue jeans."),
        "job" to listOf("He started a new job.", "I love my current job.", "Is it a full-time job?"),
        "journey" to listOf("It was a long journey.", "Enjoy your journey to Italy.", "The journey took five hours."),
        "judiciary" to listOf("The judiciary is independent here.", "He works in the judiciary.", "The judiciary handles the appeals."),
        "juice" to listOf("I want some orange juice.", "This apple juice is sweet.", "Do you have any juice?"),
        "jurisdiction" to listOf("That is outside my jurisdiction.", "Who has jurisdiction over this?", "The court has legal jurisdiction."),
        "just" to listOf("I just got home.", "Just wait a moment.", "It is just a game."),
        "justice" to listOf("We all seek social justice.", "The judge ensured justice.", "There is no justice here."),
        "justify" to listOf("How can you justify this?", "You must justify the cost.", "I cannot justify the expense."),
        "kimono" to listOf("She wore a silk kimono.", "The kimono has floral patterns.", "He bought a traditional kimono."),
        "kitchen" to listOf("The kitchen is very clean.", "Meet me in the kitchen.", "Who is in the kitchen?"),
        "knee" to listOf("I hurt my left knee.", "He fell on his knee.", "My knee is swelling up."),
        "know" to listOf("Do you know her name?", "I don't know the answer.", "We know how to fix it."),
        "knowledge" to listOf("She has a lot of knowledge.", "Knowledge is power in life.", "Use your knowledge of law."),
        "laboratory" to listOf("The samples are in the laboratory.", "We work in the laboratory.", "This is a chemistry laboratory."),
        "lake" to listOf("The lake is very calm.", "We went swimming in the lake.", "Let's boat on the lake."),
        "language" to listOf("Which language do you speak?", "Learning a language takes time.", "English is a global language."),
        "last month" to listOf("I visited Paris last month.", "She quit her job last month.", "It rained a lot last month."),
        "last week" to listOf("We met him last week.", "I bought this last week.", "Last week was very busy."),
        "lawyer" to listOf("I need to call my lawyer.", "She is a corporate lawyer.", "The lawyer gave some advice."),
        "leaf" to listOf("A yellow leaf fell down.", "Look at this green leaf.", "Every leaf is falling now."),
        "learn" to listOf("I want to learn Spanish.", "You learn fast in school.", "We learn from our mistakes."),
        "leave" to listOf("Please leave the door open.", "I have to leave now.", "When did they leave home?"),
        "left" to listOf("Turn left here.", "There is nothing left.", "He left the room."),
        "leg" to listOf("My leg is cramping up.", "He broke his right leg.", "The table has one leg."),
        "legislation" to listOf("The new legislation is strict.", "They are drafting the legislation.", "This legislation affects all citizens."),
        "liaise" to listOf("I will liaise with the team.", "We need to liaise with them.", "Please liaise with your manager."),
        "library" to listOf("I am going to the library.", "The library is very quiet.", "Can you find a library book?"),
        "lifestyle" to listOf("She has a very healthy lifestyle.", "This lifestyle is too expensive.", "I want a slower lifestyle."),
        "light" to listOf("Please turn on the light.", "This room is very light.", "The light is too bright."),
        "like" to listOf("I like eating fresh fruit.", "Do you like this song?", "She looks like her mother."),
        "likewise" to listOf("Nice to meet you; likewise.", "He smiled and she did likewise.", "I feel likewise about this."),
        "lion" to listOf("The lion is very loud.", "We saw a lion today.", "A lion is a big cat."),
        "listen" to listOf("Please listen to me.", "I like to listen to music.", "Listen to the sound."),
        "lively" to listOf("The party was very lively.", "This is a lively city.", "He is a lively child."),
        "loan" to listOf("I need a small loan.", "Can you loan me ten dollars?", "He paid off the loan."),
        "local" to listOf("I shop at the local store.", "We live in a local park.", "The local news is boring."),
        "lonely" to listOf("He feels very lonely here.", "It is a lonely road.", "I get lonely at night."),
        "long" to listOf("It was a long trip.", "She has very long hair.", "That is a long story."),
        "look into" to listOf("I will look into it.", "We must look into the cost.", "Let me look into that."),
        "low" to listOf("The battery is very low.", "Keep your voice low.", "The water level is low."),
        "luggage" to listOf("My luggage is very heavy.", "Where is your luggage?", "We lost our luggage."),
        "lunch" to listOf("What is for lunch today?", "Let us eat lunch together.", "I had a quick lunch."),
        "lungs" to listOf("Take a deep breath into your lungs.", "Smoking damages your lungs.", "My lungs feel tight."),
        "magnitude" to listOf("They felt the earthquake's magnitude.", "We underestimated the magnitude.", "The magnitude was quite large."),
        "maintain" to listOf("You must maintain the car.", "It is hard to maintain order.", "Maintain a steady pace."),
        "make" to listOf("Can you make some coffee?", "I will make a cake.", "Let us make a plan."),
        "manager" to listOf("Talk to your store manager.", "The manager is in a meeting.", "She is a great manager."),
        "mandarin orange" to listOf("I ate a mandarin orange.", "This mandarin orange is sweet.", "Do you like mandarin oranges?"),
        "map" to listOf("I cannot read this map.", "Look at the city map.", "We need a map."),
        "marginal" to listOf("There is a marginal difference.", "The gain was marginal.", "It is a marginal cost."),
        "market" to listOf("I am going to the market.", "The fish market is busy.", "Prices are high at the market."),
        "masterpiece" to listOf("This painting is a true masterpiece.", "He considers this movie his masterpiece.", "The chef created a culinary masterpiece."),
        "may" to listOf("May I come in please?", "It may rain this afternoon.", "You may leave the room."),
        "meat" to listOf("Do you eat red meat?", "I'll buy some ground meat today.", "This meat is cooked perfectly."),
        "medicine" to listOf("Take your medicine after dinner.", "This medicine makes me sleepy.", "Where is the cough medicine?"),
        "meeting" to listOf("The meeting starts at ten.", "I have a meeting tomorrow.", "Our meeting was cancelled today."),
        "melon" to listOf("This honeydew melon is very sweet.", "I sliced the melon for snacks.", "Do you like watermelon or melon?"),
        "message" to listOf("Send me a quick message.", "I got your text message.", "Did he leave a message?"),
        "methodology" to listOf("Their research methodology is flawed.", "Explain your methodology to the class.", "We need a new testing methodology."),
        "meticulous" to listOf("She is meticulous about her work.", "He is a meticulous cleaner.", "The artist was very meticulous."),
        "midnight" to listOf("I stayed up until midnight.", "The party ended at midnight.", "It is almost midnight now."),
        "might" to listOf("It might be too expensive.", "We might go to Italy.", "She might be sleeping now."),
        "milk" to listOf("Please buy some almond milk.", "The milk has gone sour.", "Do you want milk in your coffee?"),
        "million" to listOf("She won a million dollars.", "There are a million stars.", "It takes a million years."),
        "minute" to listOf("Wait for one more minute.", "I'll be there in a minute.", "Give me a minute to think."),
        "mirror" to listOf("Look in the mirror please.", "The mirror is cracked.", "He stared at the mirror."),
        "miso soup" to listOf("I love hot miso soup.", "Miso soup is a great starter.", "Order the miso soup here."),
        "mitigate" to listOf("We need to mitigate the risk.", "This plan will mitigate the damage.", "How can we mitigate the cost?"),
        "monday" to listOf("I hate Monday mornings.", "See you on Monday morning.", "Monday is the busiest day."),
        "money" to listOf("I don't have much money.", "How much money is that?", "Save your money for later."),
        "monkey" to listOf("The monkey ate a banana.", "Look at that funny monkey.", "Monkeys are very intelligent animals."),
        "month" to listOf("I'll see you next month.", "February is a short month.", "I started this job last month."),
        "mood" to listOf("He is in a bad mood.", "Music always improves my mood.", "She is in a great mood."),
        "moon" to listOf("The moon is very bright tonight.", "Look at the crescent moon.", "The moon orbits the Earth."),
        "morality" to listOf("They debated the morality of the law.", "Her morality is very strict.", "This story tests human morality."),
        "moreover" to listOf("It is cold; moreover, it is raining.", "Moreover, the price is too high.", "He is smart; moreover, he is kind."),
        "morning" to listOf("I exercise every morning.", "Good morning to everyone here.", "The morning air is fresh."),
        "mother" to listOf("My mother is a teacher.", "Call your mother this evening.", "Her mother lives in Spain."),
        "mountain" to listOf("We climbed a tall mountain.", "The mountain is covered in snow.", "Which mountain is the highest?"),
        "mouse" to listOf("My computer mouse is broken.", "There is a mouse in the kitchen.", "The mouse ate the cheese."),
        "mouth" to listOf("Close your mouth when chewing.", "He has a small mouth.", "Brush your teeth and mouth."),
        "movie" to listOf("Let's watch a movie tonight.", "That movie was very scary.", "I love this old movie."),
        "movie theater" to listOf("Meet me at the movie theater.", "The movie theater is crowded.", "I work at the movie theater."),
        "muscle" to listOf("He has a strong muscle.", "My leg muscle is sore.", "Exercise helps build muscle."),
        "museum" to listOf("We visited the art museum.", "The museum is closed today.", "I love visiting the museum."),
        "music" to listOf("I listen to music daily.", "The music is too loud.", "She loves classical music."),
        "musician" to listOf("My brother is a talented musician.", "The musician played the violin.", "She wants to be a musician."),
        "must" to listOf("You must wear a seatbelt.", "I must finish this project.", "We must be very quiet."),
        "narrow" to listOf("This street is very narrow.", "The path became too narrow.", "It is a narrow bridge."),
        "nature" to listOf("I love spending time in nature.", "Nature is beautiful in spring.", "We must protect nature."),
        "near" to listOf("My house is near here.", "Stay near the exit.", "Is there a bank near?"),
        "neck" to listOf("He wore a scarf on his neck.", "My neck feels very stiff.", "She has a long neck."),
        "necklace" to listOf("She wears a gold necklace.", "This necklace is very expensive.", "I bought her a pearl necklace."),
        "necktie" to listOf("He is wearing a red necktie.", "I cannot tie a necktie.", "A necktie is formal wear."),
        "negligible" to listOf("The difference is negligible.", "The cost increase was negligible.", "It is a negligible amount."),
        "negotiate" to listOf("We need to negotiate the price.", "Can you negotiate a deal?", "They are trying to negotiate."),
        "negotiation" to listOf("The negotiation took three hours.", "We are in a tough negotiation.", "The negotiation failed yesterday."),
        "neighbour" to listOf("My neighbour is very friendly.", "The neighbour's dog barks loud.", "He is a helpful neighbour."),
        "never" to listOf("I have never been there.", "He never listens.", "Never give up."),
        "new" to listOf("I bought a new car.", "This is a new phone.", "We have a new teacher."),
        "news" to listOf("Have you heard the news?", "The news was shocking.", "I watch the evening news."),
        "newspaper" to listOf("He reads the newspaper daily.", "I found a job in the newspaper.", "Put the newspaper on the table."),
        "next month" to listOf("I will travel next month.", "The project ends next month.", "We move house next month."),
        "next week" to listOf("See you next week.", "I have a test next week.", "It will rain next week."),
        "nice to meet you" to listOf("Hello, nice to meet you.", "It is nice to meet you.", "Nice to meet you too."),
        "night" to listOf("The night is very dark.", "I can't sleep at night.", "See you tomorrow night."),
        "night town" to listOf("The night town is very bright.", "I love the energy of night town.", "We explored the night town."),
        "nine" to listOf("I have nine apples.", "He is nine years old.", "The class starts at nine."),
        "no" to listOf("No, I cannot go.", "There is no time.", "No, that is wrong."),
        "nonetheless" to listOf("It was raining; nonetheless, we went.", "He is tired, nonetheless he works.", "It is expensive, nonetheless I bought it."),
        "noon" to listOf("Let's meet at noon.", "Lunch is served at noon.", "The sun is high at noon."),
        "nose" to listOf("My nose is running.", "She has a small nose.", "He hit his nose."),
        "not" to listOf("I am not feeling well.", "Do not touch that button.", "It is not too late."),
        "notion" to listOf("That is a strange notion.", "I have no notion of it.", "The notion seems impractical."),
        "notwithstanding" to listOf("Notwithstanding the rain, we played.", "He won, notwithstanding the odds.", "Notwithstanding the cost, it is worth it."),
        "novel" to listOf("I am reading a novel.", "She wrote a historical novel.", "This is a long novel."),
        "now" to listOf("I need to go now.", "Where are you now?", "We can start now."),
        "nurse" to listOf("The nurse helped the patient.", "She is a registered nurse.", "Call the nurse for help."),
        "obtain" to listOf("Where can I obtain a visa?", "You must obtain a permit.", "He tried to obtain more info."),
        "of" to listOf("This is a cup of tea.", "He is a friend of mine.", "The color of the car is red."),
        "office" to listOf("My office is downtown.", "She works in a quiet office.", "Please come to my office."),
        "office worker" to listOf("He is a typical office worker.", "The office worker felt tired.", "She is an office worker here."),
        "often" to listOf("How often do you exercise?", "I often go there.", "We often eat out."),
        "oil" to listOf("Add some olive oil.", "The car is leaking oil.", "This pan needs more oil."),
        "old" to listOf("My dog is very old.", "This is an old house.", "He is an old friend."),
        "older brother" to listOf("My older brother is a doctor.", "He is my older brother.", "I fight with my older brother."),
        "older sister" to listOf("My older sister lives here.", "She is my older sister.", "I love my older sister."),
        "on" to listOf("The book is on the table.", "Put your coat on now.", "I am on my way."),
        "on balance" to listOf("On balance, it was a success.", "On balance, the plan worked.", "On balance, we are happy."),
        "on the contrary" to listOf("On the contrary, it is hot.", "On the contrary, I disagree.", "On the contrary, she is kind."),
        "on the verge of" to listOf("She is on the verge of crying.", "We are on the verge of winning.", "It is on the verge of breaking."),
        "once" to listOf("I have been there once.", "Once a week is enough.", "Do it only once."),
        "one" to listOf("I only have one dollar.", "One person is waiting.", "This is the one I want."),
        "online" to listOf("I bought this online.", "The class is held online.", "Are you online right now?"),
        "only" to listOf("I only have five dollars.", "She is the only child.", "It only takes a minute."),
        "only child" to listOf("I am an only child.", "She grew up as an only child.", "He is an only child."),
        "open" to listOf("Please open the window.", "The store is now open.", "Open your book to page ten."),
        "opinion" to listOf("What is your honest opinion?", "In my opinion, this is better.", "Everyone has a different opinion."),
        "optimize" to listOf("We need to optimize the site.", "Please optimize your workflow.", "This tool helps optimize speed."),
        "or" to listOf("Do you want tea or coffee?", "You can walk or take a bus.", "Red or blue, pick one."),
        "out of the blue" to listOf("He called me out of the blue.", "That happened completely out of the blue.", "She arrived out of the blue."),
        "outlet" to listOf("Where is the nearest power outlet?", "This store is a great outlet.", "I need a new electrical outlet."),
        "over" to listOf("The cat jumped over it.", "It is over now.", "Come over to my house."),
        "oversee" to listOf("She will oversee the new project.", "He oversees a team of ten.", "Who is overseeing the construction site?"),
        "owl" to listOf("An owl hooted in the woods.", "That owl has very large eyes.", "Owls hunt for food at night."),
        "pain" to listOf("My lower back is in pain.", "The pain went away quickly.", "He felt a sharp pain here."),
        "painter" to listOf("The painter finished the living room.", "She is a talented oil painter.", "We hired a professional house painter."),
        "painting" to listOf("This painting is worth a lot.", "She is painting the fence white.", "I love that oil painting here."),
        "palm" to listOf("He held the coin in his palm.", "We sat under a palm tree.", "The palm of my hand itches."),
        "paper" to listOf("Can I have a piece of paper?", "This paper is very thin.", "I read it in the paper."),
        "paradigm" to listOf("This is a new business paradigm.", "The paradigm shifted after the war.", "We need a new social paradigm."),
        "paradox" to listOf("It seems like a strange paradox.", "That is a classic logical paradox.", "Life is full of paradoxes."),
        "paramount" to listOf("Safety is of paramount importance.", "Quality is paramount to our success.", "This issue is paramount right now."),
        "parents" to listOf("My parents live in New York.", "Her parents are very supportive.", "Do your parents know about this?"),
        "park" to listOf("Let's go to the park today.", "You cannot park your car here.", "The kids are playing in the park."),
        "partner" to listOf("She is my business partner.", "He is a great dancing partner.", "I live with my long-term partner."),
        "passport" to listOf("Do not lose your passport.", "I need to renew my passport.", "Show your passport at the gate."),
        "password" to listOf("I forgot my computer password.", "Please enter your secret password.", "Your password must be eight characters."),
        "pasta" to listOf("I love pasta with red sauce.", "We are cooking pasta for dinner.", "This pasta is slightly overcooked."),
        "patience" to listOf("Please have some patience with me.", "Teaching kids requires a lot of patience.", "My patience is running very thin."),
        "pay" to listOf("When do you get paid?", "I will pay for the coffee.", "How much do they pay you?"),
        "peach" to listOf("This peach is very juicy.", "I love the smell of peaches.", "Do you want a fresh peach?"),
        "peak" to listOf("We reached the mountain peak.", "Traffic hits its peak at noon.", "He is at his career peak."),
        "pen" to listOf("Can I borrow your blue pen?", "This pen has run out of ink.", "Sign the form with a pen."),
        "penguin" to listOf("The penguin waddles on the ice.", "Penguins cannot fly in the air.", "Look at that cute little penguin."),
        "pepper" to listOf("Add some black pepper to this.", "This pepper is way too spicy.", "Do you like bell pepper?"),
        "perception" to listOf("My perception of him changed quickly.", "Public perception of the company is poor.", "She has a keen perception of detail."),
        "person" to listOf("He is a very kind person.", "Which person is in charge here?", "I am just one person."),
        "personality" to listOf("She has a very bubbly personality.", "His personality clashes with mine.", "They have similar personalities."),
        "perspective" to listOf("Try to see it from my perspective.", "Travel gives you a new perspective.", "His perspective on life is unique."),
        "phenomenon" to listOf("This is a strange natural phenomenon.", "Social media is a global phenomenon.", "The northern lights are a rare phenomenon."),
        "phone" to listOf("My phone is out of battery.", "Please put your phone away.", "I left my phone at home."),
        "photo" to listOf("This photo was taken last year.", "Can you take a photo of us?", "Look at this old photo."),
        "photographer" to listOf("The photographer took a great shot.", "She is a professional wedding photographer.", "I hired a photographer for the event."),
        "pig" to listOf("The pig is eating an apple.", "Farms usually have many pigs.", "A pig can be very smart."),
        "pilot" to listOf("The pilot landed the plane safely.", "He wants to be a pilot.", "Ask the pilot about the weather."),
        "pineapple" to listOf("Do you like pineapple on pizza?", "I bought a fresh pineapple.", "Pineapples grow in warm climates."),
        "pivotal" to listOf("This was a pivotal moment in history.", "Her role was pivotal to the project.", "It was a pivotal decision for them."),
        "plane" to listOf("The plane departs at six o'clock.", "We are boarding the plane now.", "He flew by plane to London."),
        "planet" to listOf("Mars is a red planet.", "Earth is our home planet.", "Which planet is furthest from the sun?"),
        "plateau" to listOf("The hikers reached a high plateau.", "The land levels out into a plateau.", "My progress has hit a plateau."),
        "platform" to listOf("Stand back from the platform edge.", "This app is a great platform.", "He spoke from a wooden platform."),
        "play" to listOf("Do you want to play soccer?", "We saw a play at the theater.", "Let the children play outside."),
        "please" to listOf("Please pass me the salt.", "Please sit down and be quiet.", "Could you please help me?"),
        "plot" to listOf("The movie has a complex plot.", "They are plotting a garden.", "I didn't understand the plot."),
        "pocket" to listOf("Put your keys in your pocket.", "He has a hole in his pocket.", "I found a coin in my pocket."),
        "poetry" to listOf("She loves reading romantic poetry.", "This class studies modern poetry.", "His poetry is very emotional."),
        "point out" to listOf("Please point out the mistake.", "He pointed out the exit.", "I want to point out one thing."),
        "police officer" to listOf("The police officer stopped the car.", "Ask a police officer for help.", "He is a dedicated police officer."),
        "police station" to listOf("Go to the nearest police station.", "The police station is on Main Street.", "She works at the local police station."),
        "policy" to listOf("Company policy forbids smoking here.", "What is the return policy?", "We need a new security policy."),
        "politician" to listOf("That politician makes a lot of promises.", "She is a well-known politician.", "I don't trust that politician."),
        "pollution" to listOf("Air pollution is bad in cities.", "Plastic causes water pollution.", "We must reduce ocean pollution."),
        "population" to listOf("The city's population is growing.", "The world population is huge.", "What is the population of Japan?"),
        "pork" to listOf("I don't eat pork.", "This pork roast tastes great.", "Do you like grilled pork?"),
        "post office" to listOf("The post office closes at five.", "I'm going to the post office.", "Where is the nearest post office?"),
        "postulate" to listOf("Scientists postulate a new theory.", "We postulate that heat rises.", "He postulated a different result."),
        "poverty" to listOf("Many people live in extreme poverty.", "The government fights child poverty.", "Poverty affects millions of people."),
        "practice" to listOf("I need to practice piano.", "Practice makes perfect.", "She has a medical practice."),
        "pragmatic" to listOf("We need a pragmatic solution.", "He takes a pragmatic approach.", "Be pragmatic about the budget."),
        "precedent" to listOf("This case sets a legal precedent.", "There is no precedent for this.", "We must follow the existing precedent."),
        "precipitate" to listOf("The cold air will precipitate rain.", "Certain chemicals precipitate a reaction.", "These events precipitate a crisis."),
        "prevalence" to listOf("The prevalence of flu is rising.", "Study the prevalence of the disease.", "There is a high prevalence of obesity."),
        "price" to listOf("The price of gas is high.", "What is the retail price?", "This price is too expensive."),
        "prioritize" to listOf("You should prioritize your health.", "I need to prioritize my tasks.", "Let's prioritize the most urgent work."),
        "professor" to listOf("My history professor is very strict.", "She is a university professor.", "The professor gave a long lecture."),
        "profit" to listOf("The company made a huge profit", "We need to increase our profit", "Small businesses struggle to make profit"),
        "profound" to listOf("His words had a profound effect", "It was a profound discovery", "She felt a profound sense of loss"),
        "programmer" to listOf("He works as a Java programmer", "The programmer fixed the bug", "She is a talented young programmer"),
        "project" to listOf("This project is due on Friday", "We started a new school project", "The project took three months"),
        "promotion" to listOf("She finally got a promotion", "He is hoping for a promotion", "The company offered her a promotion"),
        "propensity" to listOf("He has a propensity for lying", "She has a propensity for risk", "Dogs have a propensity to bark"),
        "prosecution" to listOf("The prosecution called a new witness", "The prosecution failed to prove it", "He is facing criminal prosecution"),
        "protect" to listOf("Wear sunscreen to protect your skin", "This case will protect the phone", "Parents want to protect their children"),
        "put off" to listOf("Don't put off your homework", "We had to put off the trip", "She keeps putting off the doctor"),
        "quiet" to listOf("Please be quiet in the library", "It is very quiet in here", "The house was finally quiet"),
        "rabbit" to listOf("The rabbit ate a carrot", "My pet rabbit is very soft", "A rabbit hopped across the yard"),
        "railway" to listOf("The railway runs through the city", "I work for the national railway", "The railway station is crowded"),
        "rain" to listOf("I hope it doesn't rain today", "The rain stopped an hour ago", "We love the smell of rain"),
        "rainbow" to listOf("Look at that beautiful rainbow", "A rainbow appeared after the storm", "Can you see the rainbow?"),
        "raincoat" to listOf("Put on your yellow raincoat", "I forgot my raincoat at home", "This raincoat keeps me dry"),
        "rainy" to listOf("It is a rainy afternoon", "We stayed inside on rainy days", "I love rainy weather"),
        "ramen" to listOf("I want some spicy ramen", "This ramen shop is very popular", "She cooked ramen for dinner"),
        "rationale" to listOf("What is the rationale for this?", "He explained his rationale clearly", "The rationale behind the decision was simple"),
        "read" to listOf("I like to read novels", "Did you read the news?", "She can read very fast"),
        "reading" to listOf("I am reading a great book", "Reading helps you learn English", "She spends her weekends reading"),
        "really" to listOf("Do you really mean it?", "It is really hot today.", "I really like this."),
        "recycle" to listOf("Please recycle those plastic bottles.", "We should recycle more at home.", "Do you know where to recycle?"),
        "referendum" to listOf("The citizens voted in a referendum.", "The referendum changed the law.", "They are holding a national referendum."),
        "refrigerator" to listOf("Put the milk in the refrigerator.", "Is there any food in the refrigerator?", "The refrigerator is making a loud noise."),
        "refute" to listOf("He tried to refute the claim.", "The lawyer will refute the evidence.", "New data may refute that theory."),
        "relationship" to listOf("They have a very strong relationship.", "My relationship with my boss is good.", "Trust is key in any relationship."),
        "relative" to listOf("My favorite relative lives in Italy.", "Are you a relative of hers?", "She is a distant relative of mine."),
        "relax" to listOf("I just want to relax today.", "This music helps me relax.", "You need to relax your shoulders."),
        "reliability" to listOf("I doubt the reliability of this car.", "He is known for his reliability.", "We need to check its reliability."),
        "reporter" to listOf("The reporter asked a tough question.", "She works as a news reporter.", "The reporter is covering the story."),
        "require" to listOf("This job may require travel.", "Most plants require plenty of sunlight.", "Do you require any further help?"),
        "research" to listOf("I am doing research for school.", "More research is needed on this.", "She does a lot of research."),
        "resource" to listOf("The library is a great resource.", "We have limited water resources.", "Use every resource available to you."),
        "respect" to listOf("Please show some respect for others.", "I have a lot of respect for him.", "They respect the local traditions."),
        "rest" to listOf("You need to get some rest.", "I will take a short rest.", "Let the dough rest for an hour."),
        "restaurant" to listOf("Let's go to a Japanese restaurant.", "This restaurant has great reviews.", "The restaurant is closed on Mondays."),
        "restroom" to listOf("Where is the nearest restroom?", "The restroom is down the hall.", "I need to find a restroom."),
        "result" to listOf("The result was a complete surprise.", "This is the result of hard work.", "What was the result of the game?"),
        "return home" to listOf("I will return home after work.", "When did you return home?", "It is time to return home."),
        "rice" to listOf("Do you prefer brown or white rice?", "I cook rice every single day.", "We had rice with the fish."),
        "rice ball" to listOf("I bought a rice ball for lunch.", "Do you like this rice ball?", "This rice ball tastes very salty."),
        "rice field" to listOf("They work in the rice field.", "The rice field is very green.", "We walked past the rice field."),
        "right" to listOf("Turn right at the corner.", "You are right about that.", "Use your right hand."),
        "rigorous" to listOf("This is a rigorous training program.", "He follows a rigorous diet.", "The test was incredibly rigorous."),
        "ring" to listOf("She wears a gold wedding ring.", "Give me a ring tomorrow.", "The bell began to ring loudly."),
        "river" to listOf("The river flows through the city.", "We swam in the cold river.", "The river is very deep here."),
        "road" to listOf("This road leads to the city.", "There is a hole in the road.", "Stay on the main road."),
        "rock" to listOf("He sat on a large rock.", "The climbers climbed the rock wall.", "I found a strange rock."),
        "roof" to listOf("There is a cat on the roof.", "Rain is leaking through the roof.", "We fixed the roof yesterday."),
        "room" to listOf("Is there a room available?", "This room is too small.", "Clean your room right now."),
        "routine" to listOf("My morning routine is very simple.", "He has a strict daily routine.", "I need a new workout routine."),
        "run" to listOf("Can you run faster than me?", "I run five miles every morning.", "Let's go for a quick run."),
        "sad" to listOf("This movie has a sad ending.", "Why do you look so sad?", "It is sad that they left."),
        "salary" to listOf("My monthly salary is quite low.", "She earns a high annual salary.", "He negotiated a better salary."),
        "salient" to listOf("What are the salient points here?", "Focus on the most salient features.", "He ignored the most salient facts."),
        "salt" to listOf("Pass me the salt, please.", "This soup has too much salt.", "Add a pinch of salt."),
        "saturday" to listOf("We are going out this Saturday.", "Saturday is my favorite day.", "I work every single Saturday."),
        "say" to listOf("What did you say to him?", "Say it one more time.", "They say it will rain."),
        "scared" to listOf("I am scared of spiders.", "The loud noise scared the baby.", "She felt scared in the dark."),
        "scarf" to listOf("Wear a warm scarf outside.", "Her silk scarf is very colorful.", "He tied a scarf around his neck."),
        "schedule" to listOf("My schedule is full today.", "Check the bus schedule online.", "We are behind schedule again."),
        "school" to listOf("I walk to school every day.", "The school is closed on Sundays.", "She is a high school teacher."),
        "scientist" to listOf("The scientist discovered a new species.", "She is a brilliant research scientist.", "The scientist explained the theory."),
        "screen" to listOf("My phone screen is cracked.", "He stared at the computer screen.", "Don't touch the screen."),
        "sculpture" to listOf("That sculpture is made of bronze.", "The museum has a huge sculpture.", "She creates abstract sculptures."),
        "sea" to listOf("The sea is very calm today.", "We spent the day by the sea.", "Salt water from the sea stung."),
        "seat" to listOf("Please take a seat over there.", "Is this seat taken?", "He sat in the back seat."),
        "see" to listOf("I can see you now.", "Let me see your homework.", "Do you see that bird?"),
        "sell" to listOf("They sell fresh bread here.", "I want to sell my car.", "Does this shop sell milk?"),
        "set up" to listOf("Help me set up the tent.", "He set up the new printer.", "Let's set up a meeting."),
        "seven" to listOf("I woke up at seven.", "There are seven days in a week.", "He is seven years old."),
        "shall" to listOf("Shall we dance together?", "I shall return shortly.", "Where shall we meet?"),
        "sheep" to listOf("The sheep are eating grass.", "I saw a flock of sheep.", "That sheep looks lost."),
        "ship" to listOf("The ship left the port.", "He works on a cargo ship.", "The ship is very large."),
        "shirt" to listOf("This white shirt is too big.", "I need a new dress shirt.", "Put on a clean shirt."),
        "shoe store" to listOf("The shoe store is closed.", "Let's go to the shoe store.", "Which shoe store is the best?"),
        "shoes" to listOf("My shoes are too tight.", "Take off your shoes inside.", "She bought new running shoes."),
        "shop" to listOf("This coffee shop is cozy.", "I need to shop for food.", "The gift shop sells cards."),
        "shop clerk" to listOf("The shop clerk was very helpful.", "Ask the shop clerk for help.", "The shop clerk rang up items."),
        "short" to listOf("The movie was very short.", "He is too short for this.", "Life is short, enjoy it."),
        "shorts" to listOf("Wear shorts in the summer.", "These shorts are too long.", "He bought a pair of shorts."),
        "should" to listOf("You should eat more vegetables.", "We should leave right now.", "Should I call them back?"),
        "shoulder" to listOf("He carried the bag on his shoulder.", "My shoulder hurts today.", "She tapped him on the shoulder."),
        "shower" to listOf("I need to take a shower.", "The shower is too hot.", "He took a quick shower."),
        "shrine" to listOf("They visited the ancient shrine.", "This shrine is very peaceful.", "People leave flowers at the shrine."),
        "siblings" to listOf("Do you have any siblings?", "My siblings live in Ohio.", "She is the youngest of three siblings."),
        "sick" to listOf("I feel sick today.", "He is sick with the flu.", "Call in sick to work."),
        "significance" to listOf("Does this date have any significance?", "I don't see the significance of this.", "The event had great historical significance."),
        "significant" to listOf("That is a significant amount of money.", "There is a significant difference here.", "He made a significant improvement."),
        "similarly" to listOf("She smiled, and he similarly grinned.", "Similarly, we must consider the cost.", "It works similarly to a phone."),
        "singer" to listOf("She is a professional singer.", "Who is your favorite singer?", "The singer hit a high note."),
        "singing" to listOf("Stop singing in the shower!", "She loves singing in the choir.", "I heard someone singing nearby."),
        "sister" to listOf("My sister is a doctor.", "Do you have an older sister?", "I live with my sister."),
        "sit" to listOf("Please sit in this chair.", "Can we sit over there?", "Just sit and relax for a while."),
        "six" to listOf("I woke up at six.", "There are six eggs left.", "He is six years old."),
        "size" to listOf("What size shoe do you wear?", "This shirt is too small in size.", "I need a larger size."),
        "skepticism" to listOf("He reacted with some skepticism.", "Her plan was met with skepticism.", "I view the claim with skepticism."),
        "skill" to listOf("Cooking is a useful skill.", "He has a great technical skill.", "You need skill to play chess."),
        "skin" to listOf("Use lotion for dry skin.", "Her skin is very pale.", "Wash your skin with soap."),
        "skirt" to listOf("She is wearing a long skirt.", "That skirt looks great on you.", "I bought a new denim skirt."),
        "sky" to listOf("Look at the blue sky.", "The sky is turning grey.", "Birds fly across the sky."),
        "sleep" to listOf("I need some sleep.", "Did you sleep well last night?", "Go to sleep right now."),
        "slow" to listOf("Please drive a bit slower.", "The internet is very slow today.", "He is a slow reader."),
        "small" to listOf("This room is too small.", "I want a small coffee.", "It is a small mistake."),
        "snake" to listOf("Look at that green snake.", "A snake is slithering away.", "I am afraid of snakes."),
        "snow" to listOf("There is fresh snow outside.", "I love playing in the snow.", "The snow is falling quickly."),
        "snowy" to listOf("It was a cold, snowy night.", "We live in a snowy region.", "The mountain peak is snowy."),
        "so" to listOf("It was raining so I stayed.", "I am so tired today.", "I am so happy today."),
        "social media" to listOf("I don't use social media much.", "She posted it on social media.", "Social media can be very distracting."),
        "society" to listOf("We live in a modern society.", "He wants to help society.", "This is a common rule in society."),
        "socks" to listOf("Where are my clean socks?", "These wool socks are very warm.", "I need to buy new socks."),
        "sofa" to listOf("Please sit on the sofa.", "The sofa is very comfortable.", "He fell asleep on the sofa."),
        "soil" to listOf("This soil is great for plants.", "The soil is very dry here.", "Put the seeds in the soil."),
        "some" to listOf("I need some water.", "Can you bring some snacks?", "Some people are waiting."),
        "sometimes" to listOf("Sometimes I feel sad.", "It sometimes snows here.", "Sometimes he is late."),
        "son" to listOf("My son starts school tomorrow.", "He is the only son.", "Their son lives in London."),
        "son-in-law" to listOf("My son-in-law is a doctor.", "He likes his son-in-law.", "The son-in-law helped us move."),
        "sorry" to listOf("I am sorry for being late.", "Sorry, I didn't see you.", "He felt sorry for the dog."),
        "soup" to listOf("This tomato soup is delicious.", "I want a bowl of soup.", "The soup is too hot."),
        "souvenir" to listOf("I bought a souvenir from Paris.", "This keychain is a great souvenir.", "Did you get any souvenirs?"),
        "sovereignty" to listOf("The nation fought for its sovereignty.", "They claim sovereignty over the land.", "Sovereignty is key to independence."),
        "sparrow" to listOf("A small sparrow landed here.", "The sparrow is singing loudly.", "I saw a sparrow in the tree."),
        "speak" to listOf("Can you speak English?", "Please speak more slowly.", "I need to speak with him."),
        "sport" to listOf("What is your favorite sport?", "Basketball is a popular sport.", "He plays sport every weekend."),
        "squirrel" to listOf("A squirrel is climbing the tree.", "The squirrel found a nut.", "Look at that funny squirrel."),
        "stairs" to listOf("Please go up the stairs.", "He ran down the stairs.", "The stairs are made of wood."),
        "stand" to listOf("Please stand in the line.", "I cannot stand for long.", "Where do you stand now?"),
        "star" to listOf("Look at that bright star.", "He is a movie star.", "The stars are beautiful tonight."),
        "station" to listOf("Meet me at the train station.", "Which station is closest to you?", "The bus station is very crowded."),
        "stipulate" to listOf("The rules stipulate a strict deadline.", "Does the contract stipulate a price?", "Please stipulate the terms of payment."),
        "stomach" to listOf("My stomach hurts after that meal.", "I have a nervous stomach today.", "He has a stomach flu."),
        "stone" to listOf("This wall is made of stone.", "She found a smooth river stone.", "Don't throw stones in the pond."),
        "storm" to listOf("A huge storm is coming tonight.", "We stayed inside during the storm.", "The storm knocked down a tree."),
        "story" to listOf("Tell me a story about childhood.", "That is a very sad story.", "Her story doesn't sound true."),
        "strawberry" to listOf("I want a strawberry milkshake.", "This strawberry is very sweet.", "Do you like strawberry jam?"),
        "streamline" to listOf("We need to streamline our process.", "This update will streamline the workflow.", "Let's streamline the check-out system."),
        "street" to listOf("I live on a quiet street.", "Look both ways before crossing the street.", "The street is blocked by cars."),
        "stress" to listOf("Work is causing me a lot of stress.", "I can't handle this much stress.", "Try to reduce your daily stress."),
        "strong" to listOf("He is strong enough to lift it.", "This coffee is way too strong.", "She has a strong personality."),
        "stubborn" to listOf("My cat is very stubborn.", "Stop being so stubborn about it.", "He is too stubborn to apologize."),
        "student" to listOf("She is a hardworking medical student.", "Every student must bring a pen.", "I was a student ten years ago."),
        "study" to listOf("I need to study for the exam.", "Where do you usually study?", "She is studying French at college."),
        "subject" to listOf("Math is my favorite school subject.", "Let's change the subject now.", "This is a very complex subject."),
        "subsequently" to listOf("He resigned and subsequently left town.", "The error occurred and subsequently crashed.", "She failed and subsequently tried again."),
        "substantial" to listOf("There is a substantial amount of debt.", "We made substantial progress today.", "The house suffered substantial damage."),
        "substantiate" to listOf("Can you substantiate your claim?", "He had no evidence to substantiate it.", "Please substantiate your theory with data."),
        "sugar" to listOf("Do you take sugar in your tea?", "This cake has too much sugar.", "Please pass me the sugar bowl."),
        "sum up" to listOf("To sum up, we need more time.", "Can you sum up the main points?", "Let me sum up the meeting."),
        "sun" to listOf("The sun is very bright today.", "Don't look directly at the sun.", "The sun sets in the west."),
        "sunday" to listOf("I usually relax on Sunday.", "Sunday is my favorite day.", "We visit grandma every Sunday."),
        "sunny" to listOf("It is a beautiful sunny day.", "I love sunny weather in July.", "Wear a hat if it's sunny."),
        "sunny then rain" to listOf("It will be sunny then rain.", "Expect sunny then rain tomorrow.", "The forecast says sunny then rain."),
        "sunshine" to listOf("I love feeling the warm sunshine.", "The room is filled with sunshine.", "We spent the day in sunshine."),
        "supermarket" to listOf("I need to go to the supermarket.", "The supermarket is open until midnight.", "Meet me at the supermarket entrance."),
        "support" to listOf("I really appreciate your emotional support.", "Does this phone support wireless charging?", "They support the local football team."),
        "sushi" to listOf("Let's order some salmon sushi.", "I love eating fresh sushi.", "Do you like sushi with ginger?"),
        "sustainability" to listOf("The company focuses on environmental sustainability.", "Sustainability is key for our future.", "They are teaching us about sustainability."),
        "sustainable" to listOf("We need more sustainable energy sources.", "Is this packaging truly sustainable?", "They use sustainable farming methods."),
        "sweater" to listOf("Put on a sweater, it's cold.", "This wool sweater is very soft.", "I bought a new blue sweater."),
        "swim" to listOf("Can you swim in this lake?", "I like to swim every morning.", "Let's go for a quick swim."),
        "swimsuit" to listOf("Don't forget to pack your swimsuit.", "This swimsuit is a bit too small.", "She bought a new red swimsuit."),
        "synthesize" to listOf("We need to synthesize the data.", "Scientists can synthesize this protein.", "It's hard to synthesize these ideas."),
        "t-shirt" to listOf("I am wearing a white t-shirt.", "This t-shirt is made of cotton.", "Where is my favorite t-shirt?"),
        "table" to listOf("Please put the keys on the table.", "This dining table is made of oak.", "The table is too small for us."),
        "take" to listOf("Take your umbrella with you.", "I take the bus daily.", "Please take a deep breath."),
        "taxi" to listOf("I will call a taxi for you.", "The taxi is waiting outside.", "How much is the taxi fare?"),
        "tea" to listOf("Would you like some green tea?", "I drink tea every morning.", "This tea is way too hot."),
        "teach" to listOf("Can you teach me how to cook?", "She will teach English next year.", "I want to teach my kids."),
        "teacher" to listOf("My math teacher is very strict.", "He is a great primary school teacher.", "Ask your teacher for help."),
        "television" to listOf("Turn off the television now.", "My television is too small.", "Do you have a television?"),
        "temperature" to listOf("The temperature is dropping fast.", "Check the room temperature.", "He has a high temperature."),
        "temple" to listOf("We visited an ancient temple.", "The temple is very quiet.", "They are building a new temple."),
        "ten" to listOf("I have ten dollars left.", "It takes ten minutes walking.", "He is ten years old."),
        "tenuous" to listOf("Their connection is quite tenuous.", "This is a tenuous link.", "The evidence is very tenuous."),
        "thank you" to listOf("Thank you for your help.", "Thank you for the gift.", "No, thank you very much."),
        "that" to listOf("I want that red dress.", "That is a great idea.", "Who told you that?"),
        "the" to listOf("The sun is very bright.", "Pass me the remote control.", "The store closes at nine."),
        "the crux of the matter" to listOf("That is the crux of the matter.", "We found the crux of the matter.", "Let's address the crux of the matter."),
        "theme" to listOf("The party has a beach theme.", "What is the main theme?", "This movie has a dark theme."),
        "then" to listOf("First eat, then sleep.", "What happened then?", "Then we went home."),
        "theory" to listOf("My theory is that he lied.", "That is a wild theory.", "The theory seems plausible now."),
        "there" to listOf("Look over there.", "There is a big dog.", "I will go there."),
        "these" to listOf("These shoes are too small.", "Do these look good?", "I bought these yesterday."),
        "think" to listOf("I think we should leave.", "Do you think it will rain?", "I need time to think."),
        "thirsty" to listOf("I am very thirsty today.", "Are you feeling thirsty?", "Drink water if you are thirsty."),
        "thirteen" to listOf("There are thirteen people here.", "She is thirteen years old.", "I have thirteen emails to send."),
        "those" to listOf("Those apples look ripe.", "Who are those people?", "Put those books away."),
        "thousand" to listOf("A thousand people came.", "It costs a thousand euros.", "He ran a thousand meters."),
        "three" to listOf("I have three dogs.", "Give me three more minutes.", "They have three children."),
        "throat" to listOf("My throat feels very sore.", "He has a lump in his throat.", "Drink tea for your throat."),
        "thunder" to listOf("I can hear the thunder.", "The thunder was very loud.", "Thunder follows the lightning."),
        "thursday" to listOf("See you next Thursday.", "Thursday is my busiest day.", "It happened last Thursday."),
        "thus" to listOf("Thus, the plan failed.", "He lied and thus lost trust.", "It is thus decided."),
        "ticket" to listOf("Do you have your ticket?", "I bought a train ticket.", "Show me your ticket, please."),
        "tiger" to listOf("The tiger is hunting now.", "Look at that orange tiger.", "Tigers live in the jungle."),
        "time" to listOf("What time is it now?", "I have no time today.", "It is time to go."),
        "tired" to listOf("I am too tired to cook.", "You look really tired today.", "He was tired after the gym."),
        "to" to listOf("I want to go home.", "Give the book to her.", "We walked to the park."),
        "today" to listOf("What are you doing today?", "I have a meeting today.", "Today is a very busy day."),
        "toe" to listOf("I stubbed my big toe.", "She has a sore toe.", "He hurt his toe running."),
        "toilet" to listOf("Where is the nearest toilet?", "The toilet is down the hall.", "Please clean the guest toilet."),
        "tomorrow" to listOf("I will see you tomorrow.", "Is the meeting tomorrow morning?", "Let's go to the park tomorrow."),
        "tongue" to listOf("He burnt his tongue on tea.", "The dog licked my tongue.", "Hold your tongue for a second."),
        "too" to listOf("It is too hot outside.", "This shirt is too big.", "I want to come too."),
        "tooth" to listOf("I have a loose tooth.", "My front tooth really hurts.", "He went to the dentist."),
        "tourist" to listOf("She is just a tourist here.", "The city is full of tourists.", "He looks like a typical tourist."),
        "tower" to listOf("The clock tower is very old.", "That tower is way too high.", "We climbed the watch tower."),
        "town" to listOf("This is a small quiet town.", "I live in a nearby town.", "Let's go downtown for dinner."),
        "tradition" to listOf("It is a family tradition.", "We keep the holiday tradition.", "That tradition is very old."),
        "train" to listOf("I take the train daily.", "The train was ten minutes late.", "Which train goes to London?"),
        "travel" to listOf("I love to travel alone.", "They travel for work often.", "Do you travel by plane?"),
        "treaty" to listOf("The two countries signed a treaty.", "It was a peace treaty.", "They broke the old treaty."),
        "tree" to listOf("The cat is in the tree.", "That tree grows very fast.", "We sat under a large tree."),
        "trend" to listOf("That fashion trend is over.", "It is a growing trend.", "I don't follow every trend."),
        "trousers" to listOf("These trousers are too long.", "He wore black trousers today.", "Where are my grey trousers?"),
        "trust" to listOf("I trust him with my life.", "You cannot trust his word.", "Trust your gut feeling here."),
        "tsunami" to listOf("The tsunami hit the coast.", "A tsunami is a giant wave.", "They warned us about the tsunami."),
        "tuesday" to listOf("I have a test on Tuesday.", "We meet every other Tuesday.", "Tuesday is the worst day."),
        "turn down" to listOf("Please turn down the music.", "He turned down the job offer.", "Turn down the heat a bit."),
        "turtle" to listOf("That turtle moves very slowly.", "I saw a turtle on the beach.", "Turtles have hard shells."),
        "twelve" to listOf("It is twelve o'clock already.", "She bought twelve red roses.", "There are twelve eggs in the carton."),
        "twenty" to listOf("It costs twenty dollars.", "He is twenty years old.", "I have twenty pages to read."),
        "twice" to listOf("I called him twice.", "Brush your teeth twice daily.", "It happened twice."),
        "two" to listOf("I have two sisters.", "Can I have two coffees?", "It takes two hours to get there."),
        "typhoon" to listOf("The typhoon hit the coast yesterday.", "We stayed inside during the typhoon.", "A strong typhoon is coming tomorrow."),
        "ubiquitous" to listOf("Smartphones are ubiquitous these days.", "Coffee shops are ubiquitous in this city.", "Plastic waste is ubiquitous in the ocean."),
        "umbrella" to listOf("Take an umbrella with you.", "My umbrella is broken.", "She opened her black umbrella."),
        "uncle" to listOf("My uncle lives in New York.", "He is my father's brother.", "I visited my uncle last weekend."),
        "under" to listOf("The cat is under the bed.", "Put it under the table.", "I am under pressure."),
        "understand" to listOf("I don't understand this word.", "Do you understand the rules?", "I understand how you feel."),
        "unequivocal" to listOf("His answer was an unequivocal yes.", "The evidence provided unequivocal proof.", "She gave an unequivocal command."),
        "university" to listOf("She is studying at the university.", "Which university do you attend?", "He graduated from a top university."),
        "up" to listOf("Look up at the sky.", "Wake up, it is late.", "Lift the box up."),
        "use" to listOf("Can I use your phone?", "I use this app every day.", "How do you use this tool?"),
        "usually" to listOf("I usually drink tea.", "He usually arrives at six.", "We usually walk home."),
        "vacuum cleaner" to listOf("The vacuum cleaner is too loud.", "I need a new vacuum cleaner.", "Put the vacuum cleaner away."),
        "validity" to listOf("The ticket lost its validity.", "I question the validity of this claim.", "Check the validity of the passport."),
        "variable" to listOf("The weather is a constant variable.", "Price is a key variable here.", "This experiment has one main variable."),
        "vegetable garden" to listOf("We have a small vegetable garden.", "He works in the vegetable garden.", "Plant the seeds in the vegetable garden."),
        "vegetables" to listOf("Eat more green vegetables.", "I bought some fresh vegetables.", "Do you like cooked vegetables?"),
        "verdict" to listOf("The jury reached a verdict.", "We are waiting for the verdict.", "The verdict was a surprise."),
        "very" to listOf("This room is very cold.", "He is very tall.", "I am very tired."),
        "viable" to listOf("This is not a viable plan.", "We need a viable solution.", "Is this project still viable?"),
        "virtue" to listOf("Patience is a great virtue.", "She values honesty as a virtue.", "Kindness is her greatest virtue."),
        "volcano" to listOf("The volcano erupted last year.", "Is that volcano still active?", "We hiked up the volcano."),
        "volunteer" to listOf("I want to volunteer today.", "She is a hospital volunteer.", "Do you want to volunteer?"),
        "waist" to listOf("This belt is too tight.", "The dress fits her waist.", "He wore a wide belt."),
        "wait" to listOf("Please wait for the bus.", "I cannot wait any longer.", "Just wait a few minutes."),
        "waiter" to listOf("The waiter brought the food.", "Our waiter was very friendly.", "Call the waiter over here."),
        "wake up" to listOf("I wake up at six.", "Please wake up the kids.", "What time do you wake up?"),
        "walk" to listOf("Let's take a short walk.", "I walk to work daily.", "Can you walk the dog?"),
        "wall" to listOf("The wall is painted white.", "Hang the picture on the wall.", "There is a wall here."),
        "wallet" to listOf("My wallet is completely empty.", "He lost his leather wallet.", "Put the money in your wallet."),
        "want" to listOf("I want a glass of water.", "Do you want some cake?", "They want to go home."),
        "wardrobe" to listOf("My wardrobe is full of clothes.", "She bought a new wardrobe.", "Put it in the wardrobe."),
        "warm" to listOf("The soup is very warm.", "Keep the baby warm.", "It is a warm day."),
        "wash" to listOf("Wash your hands with soap.", "I need to wash my car.", "Did you wash the dishes?"),
        "washbasin" to listOf("The washbasin is leaking water.", "Put the soap in the washbasin.", "Scrub the washbasin today."),
        "washing machine" to listOf("The washing machine is loud.", "Put the towels in the machine.", "My washing machine is broken."),
        "waste" to listOf("Do not waste your time.", "This is a waste of money.", "Stop wasting the water."),
        "water" to listOf("Can I have some water?", "The water is too cold.", "Drink plenty of water today."),
        "watermelon" to listOf("I love eating cold watermelon.", "Slice the watermelon into cubes.", "Watermelon is my favorite fruit."),
        "weak" to listOf("My legs feel very weak.", "This glue is too weak.", "He is too weak to walk."),
        "wear" to listOf("What should I wear tonight?", "I wear glasses for reading.", "Don't wear those old shoes."),
        "weather" to listOf("The weather is lovely today.", "I hate this rainy weather.", "What's the weather like tomorrow?"),
        "website" to listOf("Their website is very slow.", "Check the website for prices.", "I found it on a website."),
        "wednesday" to listOf("See you on Wednesday morning.", "Wednesday is my busiest day.", "We meet every Wednesday."),
        "week" to listOf("I'll be away next week.", "It has been a long week.", "I work forty hours a week."),
        "weekend" to listOf("What are your weekend plans?", "I relaxed over the weekend.", "The weekend goes by fast."),
        "well" to listOf("He plays piano well.", "I don't feel well.", "Everything will be well."),
        "whale" to listOf("We saw a huge whale.", "That whale is swimming away.", "Blue whales are truly massive."),
        "what" to listOf("What is your name?", "What are you doing?", "I don't know what to say."),
        "when" to listOf("When do you wake up?", "Call me when you arrive.", "I was young when it happened."),
        "where" to listOf("Where do you live?", "I know where it is.", "Put it where it belongs."),
        "whereas" to listOf("He likes tea, whereas she prefers coffee.", "I'm tall, whereas my dad is short.", "This is cheap, whereas that is expensive."),
        "whereby" to listOf("It's a system whereby we share tasks.", "He created a process whereby data is saved.", "We need a law whereby people can vote."),
        "while" to listOf("Read while I am cooking.", "He slept while it rained.", "Listen while I explain."),
        "whilst" to listOf("Don't talk whilst you are eating.", "I listened whilst she spoke.", "Read the book whilst you wait."),
        "who" to listOf("Who is that man?", "I know who did it.", "Who wants some cake?"),
        "why" to listOf("Why are you laughing?", "Tell me why you left.", "Why did this happen?"),
        "wide" to listOf("The river is very wide.", "Open your eyes wide.", "This road is too wide."),
        "wife" to listOf("My wife is a doctor.", "He loves his wife dearly.", "His wife is a great cook."),
        "will" to listOf("I will call you tomorrow.", "It will be here soon.", "They will arrive at six."),
        "wind" to listOf("The wind is blowing hard.", "A cold wind hit us.", "The wind knocked over the tree."),
        "window" to listOf("Please close the bedroom window.", "Look out the window.", "The window is broken."),
        "windy" to listOf("It is too windy to play.", "Today is a very windy day.", "Keep your hat on, it's windy."),
        "with" to listOf("I am with my friend.", "Cut it with these scissors.", "Come with me please."),
        "with a pinch of salt" to listOf("Take his stories with a pinch of salt.", "I take the news with a pinch of salt.", "Listen to her with a pinch of salt."),
        "wolf" to listOf("The wolf howled at the moon.", "A wolf entered the village.", "Wolves hunt in large packs."),
        "work" to listOf("I have too much work.", "Where do you work?", "It is time to go to work."),
        "work out" to listOf("I work out at the gym.", "We need to work this out.", "Does this plan work out?"),
        "worried" to listOf("I am worried about the exam.", "She looked very worried today.", "Don't be worried about me."),
        "would" to listOf("Would you like some tea?", "I would go if I could.", "That would be very helpful."),
        "write" to listOf("Please write your name here.", "I need to write an email.", "Do you write poetry?"),
        "year" to listOf("Happy New Year to all!", "I lived there for one year.", "This year has been great."),
        "yes" to listOf("Yes, I agree.", "Yes, please help me.", "Yes, it is raining."),
        "yesterday" to listOf("I saw him yesterday afternoon.", "Yesterday was a holiday.", "It rained all day yesterday."),
        "younger brother" to listOf("My younger brother is annoying.", "He has one younger brother.", "I play soccer with my younger brother."),
        "younger sister" to listOf("Her younger sister is five.", "My younger sister lives in London.", "I help my younger sister study.")
    )

    private val POS: Map<String, String> = run {
        val m = mutableMapOf<String, String>()
        for (lesson in Oxford.lessons) {
            for (w in lesson.words) {
                val k = w.en.trim().lowercase()
                if (k.isNotEmpty() && w.ipa.isNotEmpty() && !m.containsKey(k)) m[k] = w.ipa.trim().lowercase()
            }
        }
        m
    }

    fun forWord(word: Word): List<String> = forWordText(word.en)

    fun forWordText(en: String): List<String> {
        val key = normalize(en)
        CURATED[key]?.let { return it }
        return generated(key)
    }

    fun normalize(raw: String): String {
        var w = raw.trim().lowercase()
        w = w.replace(Regex("\\([^)]*\\)"), " ").replace(Regex("\\s+"), " ").trim()
        w = w.split(" / ")[0].trim()
        if (w.startsWith("to ")) w = w.removePrefix("to ").trim()
        return w
    }

    private fun generated(key: String): List<String> {
        if (key.isEmpty()) return generic(key)
        val pos = POS[key] ?: guessPos(key)
        return when (pos) {
            "noun" -> noun(key)
            "verb", "linking verb" -> verb(key)
            "adjective" -> adjective(key)
            "adverb" -> adverb(key)
            "preposition" -> preposition(key)
            "conjunction" -> conjunction(key)
            "determiner", "definite article", "indefinite article" -> determiner(key)
            "pronoun" -> pronoun(key)
            "number" -> number(key)
            "ordinal number" -> ordinal(key)
            "exclamation" -> exclamation(key)
            "modal verb" -> modal(key)
            "infinitive marker" -> listOf("I want to go home.", "She likes to sing.", "We plan to travel.")
            else -> generic(key)
        }
    }

    private fun guessPos(key: String): String = when {
        key.endsWith("ly") -> "adverb"
        key.endsWith("ing") || key.endsWith("tion") || key.endsWith("ness") ||
            key.endsWith("ment") || key.endsWith("ance") -> "noun"
        key.endsWith("ize") || key.endsWith("ise") || key.endsWith("ate") || key.endsWith("ify") -> "verb"
        key.endsWith("ful") || key.endsWith("ous") || key.endsWith("ive") ||
            key.endsWith("al") || key.endsWith("able") -> "adjective"
        else -> "noun"
    }

    private fun noun(key: String): List<String> = listOf(
        "We talked about $key in class today.",
        "I read about $key in the newspaper.",
        "Can you tell me more about $key?"
    )

    private fun verb(key: String): List<String> = when (key) {
        "be" -> listOf("I want to be a doctor.", "Be careful with that glass.", "She will be here soon.")
        "have" -> listOf("I have two brothers.", "She has a new car.", "We have a meeting today.")
        "do" -> listOf("What do you do at work?", "I do my homework at night.", "Do you like coffee?")
        "go" -> listOf("I go to school by bus.", "She wants to go home.", "We go to the park on Sundays.")
        "come" -> listOf("Please come to my party.", "She comes home at six.", "They will come tomorrow.")
        "make" -> listOf("I make coffee every morning.", "She made a cake for us.", "Can you make a plan?")
        "take" -> listOf("I take the bus to work.", "She took my book by mistake.", "Take an umbrella with you.")
        "get" -> listOf("I get up at seven.", "Did you get my message?", "She got a new phone.")
        "see" -> listOf("I see you every day.", "She saw the movie last night.", "Can you see the sign?")
        "know" -> listOf("I know the answer.", "Do you know her name?", "She knows how to swim.")
        "say" -> listOf("What did you say?", "She says hello to everyone.", "He said it was fine.")
        "think" -> listOf("I think it is a good idea.", "What do you think about this?", "She thinks you are right.")
        else -> listOf(
            "We need to $key the new plan.",
            "I want to $key something useful today.",
            "She will $key the first item on the list."
        )
    }

    private fun adjective(key: String): List<String> = listOf(
        "That was a really $key moment.",
        "This plan sounds $key to me.",
        "She looked $key in the photo."
    )

    private fun adverb(key: String): List<String> = when (key) {
        "not" -> listOf("I am not feeling well.", "Do not touch that button.", "It is not too late.")
        else -> listOf(
            "He spoke $key during the meeting.",
            "Please do it $key.",
            "She finished the work $key."
        )
    }

    private fun preposition(key: String): List<String> = when (key) {
        "in" -> listOf("The keys are in my bag.", "He lives in a city.", "I will be there in ten.")
        "on" -> listOf("The book is on the table.", "Put your coat on now.", "I am on my way.")
        "at" -> listOf("Meet me at the station.", "He is at work now.", "I am at the door.")
        "to" -> listOf("I want to go home.", "Give the book to her.", "We walked to the park.")
        "from" -> listOf("I am from Canada.", "This gift is from Sarah.", "Walk away from the edge.")
        "for" -> listOf("This gift is for you.", "I waited for two hours.", "Is this for sale?")
        "with" -> listOf("I am with my friend.", "Cut it with these scissors.", "Come with me please.")
        "by" -> listOf("I go to work by bus.", "The book was written by him.", "Stand by the door.")
        "about" -> listOf("Tell me about your day.", "It is about five o'clock.", "I am thinking about it.")
        "of" -> listOf("This is a cup of tea.", "He is a friend of mine.", "The color of the car is red.")
        "into" -> listOf("The cat jumped into the box.", "Let's go into the room.", "He ran into the street.")
        "through" -> listOf("We walked through the forest.", "The train goes through the tunnel.", "I looked through the window.")
        "during" -> listOf("I fell asleep during the movie.", "It rained during the night.", "Be quiet during the class.")
        "before" -> listOf("Wash your hands before dinner.", "I have seen this before.", "Please arrive before noon.")
        "after" -> listOf("We went home after the party.", "She called me after work.", "I will rest after the exam.")
        "between" -> listOf("The shop is between the bank and the park.", "Choose between the two.", "We sat between them.")
        "under" -> listOf("The cat is under the table.", "The keys fell under the chair.", "We rested under a tree.")
        "over" -> listOf("The plane flew over the city.", "She jumped over the wall.", "Let's talk it over.")
        "above" -> listOf("The sun was above the clouds.", "Write your name above the line.", "The temperature is above normal.")
        "below" -> listOf("The temperature is below zero.", "Look at the notes below.", "The flat is below my office.")
        "across" -> listOf("The bridge goes across the river.", "She walked across the road.", "We live across the street.")
        "along" -> listOf("We walked along the beach.", "There are shops along the road.", "Move along, please.")
        "among" -> listOf("She sat among her friends.", "There is a spy among us.", "The house is hidden among the trees.")
        "behind" -> listOf("The car is behind the house.", "He hid behind the door.", "She is behind in her work.")
        "beside" -> listOf("Come sit beside me.", "The lamp is beside the bed.", "She stood beside her brother.")
        "beyond" -> listOf("The village is beyond the hills.", "This is beyond my control.", "The school is beyond the bridge.")
        "near" -> listOf("My house is near here.", "Stay near the exit.", "Is there a bank near?")
        "since" -> listOf("I have lived here since 2020.", "It has been raining since morning.", "We have been friends since school.")
        "until" -> listOf("Wait here until I return.", "The shop is open until nine.", "I worked until midnight.")
        "towards" -> listOf("She walked towards the door.", "He ran towards the station.", "The boat moved towards the shore.")
        "without" -> listOf("I can't live without my phone.", "She left without saying goodbye.", "Don't go out without a coat.")
        "within" -> listOf("The package will arrive within a week.", "Stay within the marked area.", "You must finish within an hour.")
        else -> listOf(
            "We talked $key the new house.",
            "I walked $key the station.",
            "She lives $key the market."
        )
    }

    private fun conjunction(key: String): List<String> = when (key) {
        "and" -> listOf("I like tea and coffee.", "She sang and danced.", "Bread and butter are here.")
        "but" -> listOf("I like it but it's pricey.", "He is small but strong.", "I tried but I failed.")
        "or" -> listOf("Do you want tea or coffee?", "Red or blue, pick one.", "You can walk or take a bus.")
        "so" -> listOf("It was raining so I stayed.", "I am so tired today.", "I am so happy today.")
        "because" -> listOf("I slept because I was tired.", "She cried because she lost it.", "He smiled because he was happy.")
        "if" -> listOf("If it rains, stay home.", "I will go if you go.", "Tell me if you need help.")
        "when" -> listOf("When do you wake up?", "Call me when you arrive.", "I was young when it happened.")
        "while" -> listOf("Read while I am cooking.", "He slept while it rained.", "Listen while I explain.")
        "although" -> listOf("Although it was cold, we went out.", "Although he is rich, he is humble.", "Although tired, she kept working.")
        "though" -> listOf("Though it was late, we kept talking.", "It is expensive, though worth it.", "Though small, the room is cozy.")
        "unless" -> listOf("We will be late unless we hurry.", "I won't go unless you come.", "Unless it rains, we will play outside.")
        "whereas" -> listOf("He likes tea, whereas she prefers coffee.", "I'm tall, whereas my dad is short.", "This is cheap, whereas that is expensive.")
        "whilst" -> listOf("Don't talk whilst you are eating.", "I listened whilst she spoke.", "Read the book whilst you wait.")
        "until" -> listOf("Wait here until I return.", "The shop is open until nine.", "I worked until midnight.")
        "since" -> listOf("I have lived here since 2020.", "It has been raining since morning.", "We have been friends since school.")
        "before" -> listOf("Wash your hands before dinner.", "I have seen this before.", "Please arrive before noon.")
        "after" -> listOf("We went home after the party.", "She called me after work.", "I will rest after the exam.")
        else -> listOf(
            "I stayed home $key it was raining.",
            "She smiled $key she was happy.",
            "We left early $key we were tired."
        )
    }

    private fun determiner(key: String): List<String> = when (key) {
        "a" -> listOf("I have a small dog.", "She is a talented artist.", "Give me a hand here.")
        "an" -> listOf("I ate an apple today.", "It was an honest mistake.", "Do you have an idea?")
        "the" -> listOf("The sun is very bright.", "Pass me the remote control.", "The store closes at nine.")
        "this" -> listOf("This book is interesting.", "I like this song.", "This is my friend.")
        "that" -> listOf("That was a good idea.", "I saw that movie.", "That is my house.")
        "these" -> listOf("These shoes are too small.", "Do these look good?", "I bought these yesterday.")
        "those" -> listOf("Those apples look ripe.", "Who are those people?", "Put those books away.")
        "some" -> listOf("I need some water.", "Can you bring some snacks?", "Some people are waiting.")
        "any" -> listOf("Do you have any milk?", "Is there any hope?", "I don't see any.")
        "each" -> listOf("Each student got a book.", "I checked each answer.", "Each day is different.")
        "every" -> listOf("I exercise every morning.", "Every student passed the test.", "She calls me every week.")
        "either" -> listOf("You can take either bus.", "Either answer is correct.", "I don't like either option.")
        "neither" -> listOf("Neither answer is right.", "I like neither of them.", "Neither option works for me.")
        "no" -> listOf("No, I cannot go.", "There is no time.", "No, that is wrong.")
        "other" -> listOf("I met the other students.", "The other day I saw him.", "Do you have other plans?")
        "another" -> listOf("Can I have another cup of tea?", "Let's try another way.", "I need another chair.")
        "both" -> listOf("Both answers are correct.", "I like both of them.", "Both doors are open.")
        "few" -> listOf("I have a few questions.", "Few people came today.", "A few friends visited me.")
        "many" -> listOf("Many people like this song.", "How many books do you have?", "There are many stars tonight.")
        "much" -> listOf("I don't have much time.", "How much does it cost?", "There isn't much milk left.")
        "several" -> listOf("I met several new people.", "She asked several questions.", "We waited for several hours.")
        "all" -> listOf("All the students passed.", "I ate all the cookies.", "We all went home.")
        "such" -> listOf("Such a lovely day!", "I have never seen such beauty.", "Why did you say such a thing?")
        "same" -> listOf("We go to the same school.", "I feel the same way.", "We arrived at the same time.")
        "own" -> listOf("I have my own room.", "She started her own business.", "Do you own a car?")
        "whole" -> listOf("I ate the whole cake.", "We spent the whole day outside.", "The whole class laughed.")
        "enough" -> listOf("Do we have enough time?", "That is enough food for us.", "I have had enough.")
        "more" -> listOf("I need more time.", "Tell me more about it.", "Would you like some more tea?")
        "most" -> listOf("Most people agree with me.", "I spend most of my time reading.", "She was the most helpful.")
        "less" -> listOf("I drink less coffee now.", "It costs less than before.", "Try to eat less sugar.")
        "least" -> listOf("That is the least of my worries.", "He spent the least time on it.", "It is the least I can do.")
        "which" -> listOf("Which one do you want?", "I don't know which is better.", "Which bus goes to the city?")
        "what" -> listOf("What is your name?", "What do you want to eat?", "What time is it?")
        "whose" -> listOf("Whose bag is this?", "I know whose book it is.", "Whose idea was that?")
        else -> listOf(
            "I met $key person at the party.",
            "Show me $key example, please.",
            "I bought $key one at the shop."
        )
    }

    private fun pronoun(key: String): List<String> = when (key) {
        "i" -> listOf("I like to read books.", "I am learning English.", "I will call you later.")
        "you" -> listOf("You are very kind.", "You should try this.", "I will help you.")
        "he" -> listOf("He is a good teacher.", "He likes to play football.", "He will be here soon.")
        "she" -> listOf("She is my sister.", "She sings very well.", "She will come tomorrow.")
        "it" -> listOf("It is raining outside.", "I like it very much.", "It was a long day.")
        "we" -> listOf("We are going home.", "We should work together.", "We had a great time.")
        "they" -> listOf("They are my friends.", "They will arrive soon.", "They said it was fine.")
        "me" -> listOf("Please call me later.", "She gave the book to me.", "Come with me.")
        "him" -> listOf("I met him yesterday.", "Give the keys to him.", "She called him twice.")
        "her" -> listOf("I saw her at the market.", "This gift is for her.", "She told her the news.")
        "us" -> listOf("Please join us.", "They invited us to dinner.", "Come with us.")
        "them" -> listOf("I called them yesterday.", "Give the books to them.", "We waited for them.")
        "my" -> listOf("This is my phone.", "My mother is a teacher.", "I lost my keys.")
        "your" -> listOf("Is this your bag?", "Your idea is great.", "Wash your hands.")
        "his" -> listOf("His name is Ravi.", "I borrowed his pen.", "This is his house.")
        "our" -> listOf("This is our school.", "Our team won the match.", "We love our city.")
        "their" -> listOf("Their house is big.", "I met their parents.", "Their idea was good.")
        "its" -> listOf("The dog wagged its tail.", "The tree lost its leaves.", "The phone is in its case.")
        "mine" -> listOf("This book is mine.", "The blue bag is mine.", "Mine is the red one.")
        "yours" -> listOf("Is this seat yours?", "The choice is yours.", "Yours is better than mine.")
        "who" -> listOf("Who is that man?", "Do you know who called?", "Who wants some cake?")
        "what" -> listOf("What is your name?", "What do you want to eat?", "What time is it?")
        "which" -> listOf("Which one do you want?", "I don't know which is better.", "Which bus goes to the city?")
        "whose" -> listOf("Whose bag is this?", "I know whose book it is.", "Whose idea was that?")
        "whom" -> listOf("Whom did you meet?", "To whom should I speak?", "She is someone whom I trust.")
        else -> listOf(
            "$key is in the box.",
            "I like $key very much.",
            "$key seems fine to me."
        )
    }

    private fun number(key: String): List<String> = when (key) {
        "hundred" -> listOf("It costs one hundred dollars.", "There are a hundred birds.", "I have a hundred ideas.")
        "thousand" -> listOf("A thousand people came.", "It costs a thousand euros.", "He ran a thousand meters.")
        "million" -> listOf("She won a million dollars.", "There are a million stars.", "It takes a million years.")
        else -> listOf(
            "The number $key is written on the board.",
            "Count from one to $key.",
            "My lucky number is $key."
        )
    }

    private fun ordinal(key: String): List<String> = listOf(
        "He came $key in the race.",
        "This is the $key time today.",
        "She took the $key place."
    )

    private fun exclamation(key: String): List<String> = when (key) {
        "hello" -> listOf("Hello, how are you?", "Say hello to your mother.", "Hello, is anyone there?")
        "hi" -> listOf("Hi, how are you doing?", "Say hi to your sister.", "Hi, nice to see you!")
        "yes" -> listOf("Yes, I agree.", "Yes, please help me.", "Yes, it is raining.")
        "no" -> listOf("No, I cannot go.", "There is no time.", "No, that is wrong.")
        "bye" -> listOf("Bye, see you later.", "She waved bye to us.", "I said bye and left.")
        "wow" -> listOf("Wow, that is amazing!", "Wow, you look great.", "Wow, what a surprise!")
        "oh" -> listOf("Oh, I see now.", "Oh, I forgot my keys.", "Oh, that is too bad.")
        "hey" -> listOf("Hey, how is it going?", "Hey, wait for me!", "Hey, I have an idea.")
        "well" -> listOf("Well, that is interesting.", "Well, let's get started.", "Well, I am not sure.")
        "ouch" -> listOf("Ouch, that really hurts.", "Ouch, I hit my finger.", "Ouch, be careful!")
        "thanks" -> listOf("Thanks for your help.", "Thanks a lot!", "Thanks, I really appreciate it.")
        else -> listOf(
            "$key, that was unexpected.",
            "$key, I didn't see that coming.",
            "$key, what a surprise."
        )
    }

    private fun modal(key: String): List<String> = when (key) {
        "can" -> listOf("Can you help me move this?", "I can speak a little Spanish.", "We can meet after work.")
        "could" -> listOf("Could you open the window?", "He could be at home.", "I could not find my keys.")
        "may" -> listOf("May I come in please?", "It may rain this afternoon.", "You may leave the room.")
        "might" -> listOf("It might be too expensive.", "We might go to Italy.", "She might be sleeping now.")
        "must" -> listOf("You must wear a seatbelt.", "I must finish this project.", "We must be very quiet.")
        "shall" -> listOf("Shall we dance together?", "I shall return shortly.", "Where shall we meet?")
        "should" -> listOf("You should eat more vegetables.", "We should leave right now.", "Should I call them back?")
        "will" -> listOf("I will call you tomorrow.", "It will be here soon.", "They will arrive at six.")
        "would" -> listOf("Would you like some tea?", "I would go if I could.", "That would be very helpful.")
        else -> listOf(
            "You $key try again tomorrow.",
            "I think we $key go now.",
            "$key I ask a question?"
        )
    }

    private fun generic(key: String): List<String> = listOf(
        "We talked about $key in class today.",
        "Can you tell me more about $key?",
        "I read about $key in the newspaper."
    )
}
