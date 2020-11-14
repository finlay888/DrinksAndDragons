package uk.co.nightowl.platforms.drinksdragons.objects

import uk.co.nightowl.platforms.drinksdragons.R
import uk.co.nightowl.platforms.drinksdragons.models.*
import uk.co.nightowl.platforms.drinksdragons.models.Treasure

object Events {
    fun setEvents() : ArrayList<Event> {
        val mEvents = ArrayList<Event>()
        val sadKnightBs = BadStuff(-1, "n", 0, "n", "Drink 3, Lose a level, Have a little cry")
        val sadKnightEvent = Event("You come across a sullen, sad knight.",
            R.drawable.e_sad_knight, "You come across a sad, depressed looking knight who just" +
                    " looks like he needs a hug to be honest, he notices you and begins to come closer",
            "He bonks you on the head and then bursts into tears, to lift his spirits you go to a " +
                    "local tavern to drown his sorrows",
            sadKnightBs, null, 1, "the knight bursts into tears and you give him a big hug before giving you some" +
                    "of his belongings, give out two drinks", "you strike the sad knight dead and take his belongings",
            80, 80, 60)
        mEvents.add(sadKnightEvent)
        val oneEyedSlimeBs = BadStuff(-1, "n", 0, "n", "Take a shot, Lose a level," +
                " You must drop to the floor and swim out of the slime that has swallowed you.")
        val oneEyedSlimeEvent = Event("You stumble upon a one-eyed slimey boi",
            R.drawable.e_one_eyed_slime, "He's giving you the slimey eye and he's slithering towards you," +
                    "maybe it's because of the jelly you had earlier.",
            "You are helpless to the slime as it swallows you up entirely, " +
                    "you need to chew and swim through the slime to escape.", oneEyedSlimeBs, null,2,
            "Somehow you manage to converse with the slime in some weird way and it spits out some treasure before" +
                    " slithering away.",
            "You stomp on the slimes single eye and it dies instantly, melting into the ground and leaving some loot.",
            50, 60, 60)
        mEvents.add(oneEyedSlimeEvent)
        val skeletonArmyBs = BadStuff(-2, "a", 5, "chest", "Take 2 shots, " +
                "Lose two Levels, Lose an item of clothing")
        val skeletonArmyEvent = Event("You stumble upon a small army of skeletons!",
            R.drawable.e_skeleton_army, "They're boney, they smell a bit " +
                    "and they don't look too friendly, they're running towards you swords drawn and bones rattling",
            "The skeletons overpower you, beat you up and steal your clothes. There was just simply " +
                    "too many of them.", skeletonArmyBs, null,3,
            "By some miracle you convince the skeletons you are on their side by clacking some bones together, " +
                    "take a shot to pay for your miracle",
            "After several minutes of bashing and slashing you defeat all the skeletons and they are reduced to a pile of bones, " +
                    "In celebration, hand out 5 drinks", 100, 120, 50)
        mEvents.add(skeletonArmyEvent)
        val teenDragonBs = BadStuff(0, "c", 5, "n", "Drink 2, Feel a " +
                "bit humiliated")
        val teenDragonEvent = Event("Moody teen dragon", R.drawable.e_rebellious_teen_dragon,
            "He's mean, a bit green and he's just discovered smoking, as you try and pass he angrily tokes his" +
                    " cigarettes and glares at you and begins to move closer.", "He sucker punches you in the nose " +
                    "and hurls a barrage of insults at you, hurting your feelings.", teenDragonBs, null, 2,
            "You and the dragon mong out to some snow patrol and smoke some of his private stash, hand out 1 drink",
            "You slap the dragon on the nose and blow his smoke back into his face, making him quite sad, everyone else drinks",
            70, 65, 45
        )
        mEvents.add(teenDragonEvent)
        val tequTrexBs = BadStuff(-1, "n", 0, "n", "Take a Tequila shot " +
                "or two shots of any kind, Lose a level")
        val tequTrexEvent = Event("Tequila Tyrannosaur", R.drawable.e_tequila_tyrannosaur,
            "Tequilaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "The dino lets out a mighty roar before, " +
                    "puking up pure Tequila onto you.", tequTrexBs, null,2, "You do some shots with the T-rex " +
                    "and it lets you past happily, everybody does a Tequila shot.", "You punch the T-rex in the " +
                    "throat and make it your bitch, everybody but you takes a Tequila shot .", 100, 75, 60)
        mEvents.add(tequTrexEvent)
        val singleSkelBs = BadStuff(0, "n", 0, "n", "Drink 2")
        val singleSkelEvent = Event("One Boney Boi", R.drawable.e_single_skeleton,
            "He's a bit worse for wear and he has no friends but he looks rather menacing anyways.",
            "The skeleton stabs you, hurting you just a little bit", singleSkelBs, null, 1,
            "You manage to convince the skeleton you are a powerful sorcerer who will blast them even deader, " + "causing them" +
                    " to run away rattling and jiggling.", "You hack and slash at the skeleton and they fall apart to bones and dust, maybe he" +
                    " just wanted to be your friend.", 55, 65, 45)
        mEvents.add(singleSkelEvent)
        val mMahoganyBs = BadStuff(-1, "n", 0, "n", "Everybody pours a bit of drink into a SMALL glass then down it, Lose a level, " +
                "Miss 1 turn")
        val mMahoganyEvent = Event("Melanchony Mahogany", R.drawable.e_melancholy_mahogany,
            "As you are travelling a tree next to you moans and takes a slap at you but misses just, it looks rather sad and lonely as it seems to " +
                    "be the only tree for miles however, it cannot move.", "The tree eats you, you sit in it's tummy for a few days," +
                    " before coming out the trees bottom, smelling rather foul.", mMahoganyBs, null, 3,
            "You give the tree a big hug and put a smile on it's face, lifting it's spirits. Give out 2 drinks.",
            "You hack and slash and chop the tree down, you big meanie, give out 4 drinks.", 100, 65, 30)
        mEvents.add(mMahoganyEvent)
        val blueSOctopusBs = BadStuff(0, "r", 5, "n", "Drink 2, Athleticism decreased")
        val blueSOctopusEvent = Event("A Small Blue Octopus", R.drawable.e_blue_small_octopus,
            "A small slithery octopus slides towards you looking rather curious.",
            "Your feet are wrapped in tentacles and your ankles are covered in sucker marks.",
            blueSOctopusBs, null, 1,
            "You give them a snack from your rations and shake a tentacle, Give out 2 drinks",
            "You drop kick the poor little octopus into a nearby river. Take a drink you meanie.", 45, 50, 50)
        mEvents.add(blueSOctopusEvent)
        val drunkardO1 = Outcome(1, 1, null, "", 0, "You impressively out drink the drunkard")
        val drunkard02 = Outcome(0, 0, null, "", 0, "You're a lil bitch, drink 1")
        val drunkardSpecial = SpecialEvent("Drink", "Refuse", drunkardO1, drunkard02)
        val drunkardEvent = Event("Drinking Competition", R.drawable.e_drunkard,
            "A slurring drunk challenges you to a drink off. Drink 2 shots to gain a level or refuse", "",
            null, drunkardSpecial, 0, "", "")
        mEvents.add(drunkardEvent)
        val blizzard01 = Outcome(0, 0, null, "0", 0, "The alcohol" +
                " keeps you warm and cosy")
        val blizzard02 = Outcome(0, -1, null, "0", 0, "You take shelter " +
                "in a nearby cave")
        val blizzardSpecial = SpecialEvent("Drink", "Retreat", blizzard01, blizzard02)
        val blizzardEvent = Event("Freezing Blizzard", R.drawable.e_blizzard,
            "One second it's fine, the next you are caught in the worst blizzard in decades! " +
                    "in order to brave it you must take one shot, or lose a level and retreat to a nearby cave",
            "", null, blizzardSpecial, 0, "", "")
        mEvents.add(blizzardEvent)
        val communistManifesto = Treasure("Communist Manifesto", "Go forth and seize the means of production",
            "t", 2, 5, 5, 0, R.drawable.t_communist_manifesto)
        val riot01 = Outcome(0, 0, communistManifesto, "", 0, "Death to the west! Miss a turn")
        val riot02 = Outcome(0, 0, null, "", 0, "You sneak past the riot and continue on your journey, drink 2 capitalist scum")
        val riotSpecial = SpecialEvent("Riot", "Sneak", riot01, riot02)
        val riotEvent = Event("Street Riot", R.drawable.e_street_riot, "The city you were staying in is in " +
                "uproar with peasants taking to the streets in a brutal riot, take part in the riot and miss a turn or sneak past", "",
            null, riotSpecial, 0, "", "", 0, 0, 0)
        mEvents.add(riotEvent)
        val dBrigadeBs = BadStuff(-3, "", 0, "", "Finish your drink, Lose three levels")
        val dBrigadeEvent = Event("Death Brigade", R.drawable.e_death_brigade, "You trip and fall into a " +
                "hole in the ground only to find yourself in a catacomb, wave after wave of the undead approach you.",
            "You are overwhelmed cut to pieces, the skeletons throw you out of the catacomb and you have lost much of your legend status.",
            dBrigadeBs, null, 4, "You let out a deafening roar and scare the skeletons back into their coffins, give out 5 drinks",
            "You fight your way out of the catacomb after shattering bones and cracking skulls", 140, 160, 70)
        mEvents.add(dBrigadeEvent)
        val skeletonGBs = BadStuff(0, "",0,"w", "Drink 3, Lose your weapon" )
        val skeletonGEvent = Event("Skeleton Guard", R.drawable.e_skeleton_guard, "A hulking skeleton guard blocks your path," +
                "it would be staring you down if it had eyes, but it doesn't...", "The guard swings their axe and breaks your weapon in two, you manage to scamper away defenseless.",
            skeletonGBs, null, 2, "You give the skeleton a warm glass of milk for his bones and he lets you pass.",
            "You stab the guard in the skull and it crumples to a pile of bones with a hissing noise. give out 1 drink.",
            85, 100, 60)
        mEvents.add(skeletonGEvent)
        val adultDragonBs = BadStuff(-2, "c", 5, "", "Take a shot, Lose 2 levels, Charm permanently decreased slightly")
        val adultDragonEvent = Event("Scary Fully Grown Dragon", R.drawable.e_adult_dragon,
            "A shadow is cast over the land as a fully grown adult dragon swoops down towards you, it lands and blocks your path, " +
                    "staring at you hungrily.", "The dragon roars and blasts a stream of fire at you, burning all your hair off.",
            adultDragonBs, null, 5, "You barter with the dragon and exchange your life for half your gold, you are now poor and must" +
                    " drink your sorrows away, take 1 shot", "You heroically fight the dragon and stab it in the neck, you are a crowned hero of the land, " +
                    "everybody else finish their drinks.", 170, 170, 60)
        mEvents.add(adultDragonEvent)
        val wiseWizardBs = BadStuff(0, "", 0, "", "Drink X, Miss 1 turn")
        val wiseWizardEvent = Event("Wise Wizard of the West", R.drawable.e_wize_wizard,
            "You come across a wise old wizard in a tavern you blocks your way as he smokes his magical pipe",
            "The wizard casts a spell on you, drink X times by playing rock paper scissors with every player," +
                    " every loss adds 1 drink.", wiseWizardBs, null, 2,
            "You charm the wizard with your beautiful face and give him a kiss, making him blush, give the person to your " +
                    "left or right a kiss.", "You stab the wizard and he is too old and decrepit to react quick enough, " +
                    "his magical spirit proceeds to briefly haunt you, take 3 drinks to keep the spirit away.", 90, 110, 60)
        mEvents.add(wiseWizardEvent)
        val fishmanBs = BadStuff(-1, "", 0, "", "Drink 3")
        val fishmanEvent = Event("A Fish Person", R.drawable.e_fish_man,
            "A three-legged fish person comes to greet you, they smell rather fishy.",
            "They stab you with their rather pointed spear and it hurts quite a bit.", fishmanBs,
            null, 1, "You charm the fish person with your charismatic smile, you are now chums," +
                    " give out a drink.", "You disarm the fish person and skewer them with their own spear.",
            85, 60, 60)
        mEvents.add(fishmanEvent)
        val cyclopsBs = BadStuff(-1, "", 0, "l", "Drink 2, Lose your leg gear")
        val cyclopsEvent = Event("A Giant Cyclops", R.drawable.e_cyclops,
            "A giant cyclops blocks your path, it's beady eye tracks your movements as they " +
                    "have a take a fighting stance", "The cyclops beats you close to death with it's giant club " +
                    "and steals your trousers.", cyclopsBs, null, 2, "You tell the cyclops a funny joke and " +
                    "it laughs hysterically, letting you past, tell a joke, drink because it was probably bad.",
            "You poke the cyclops in it's eye and it runs off screaming, give out 2 drinks.",
            110, 75, 60)
        mEvents.add(cyclopsEvent)
        val rMilitiaBs = BadStuff(-1, "", 0, "", "Everybody drinks, Miss a turn (fruit may be thrown at you), Lose a level")
        val rMilitiaEvent = Event("Royal Guardsmen", R.drawable.e_royal_militia,
            "A small unit of royal guardsmen come charging down the hill towards you, looking tough and angry, " +
                    "they mean business.", "You are arrested and put in the stocks to be mocked and made fun of.",
            rMilitiaBs, null, 2, "You convince the guards you are just passing through and will cause no trouble, " +
                    "they sheath their swords but keep an eye on you.", "You weave and stab at the guardsmen and they fall dead " +
                    "at your feet.", 100, 70, 60)
        mEvents.add(rMilitiaEvent)
        val carniverousPlantBs = BadStuff(-1, "", 0, "w", "Drink 3, Lose Weapon")
        val carniverousPlantEvent = Event("Man-Eating Plant", R.drawable.e_carniverous_plant,
            "It's a chomper and it's coming for you, chomp chomp chomp, It looks pretty damn hungry.",
            "You get chomped and the plant chews your weapon to pieces and coughs up the remains.",
            carniverousPlantBs, null, 1, "You feed the plant some fertiliser and it goes away," +
                    " give out 1 drink", "You cut the plants chompy bit off and it dies instantly, give out 1 drink",
            80, 60, 60)
        mEvents.add(carniverousPlantEvent)
        val hooliganBs = BadStuff(0, "", 0, "", "Drink 2")
        val hooliganEvent = Event("Hooligan", R.drawable.e_hooligan,
            "A hooligan blocks your path, you try and befriend him but he takes it as an insult, raising his club.",
            "You get bonked with by the hooligan and it hurts a bit.", hooliganBs, null, 1,
            "You perform a simple magic trick for the hooligan and he lets you past, dumbfounded.",
            "You stab the hooligan dead and that's the end of it.", 70, 70, 60)
        mEvents.add(hooliganEvent)
        val hooligansBs = BadStuff(-1, "f", 5, "", "Drink 3, Fight Decreased Slightly, Lose a level")
        val hooligansEvent = Event("Hooligan Family", R.drawable.e_hooligans,
            "A family of hooligans block your path, they look angry yet also slightly confused.",
            "You are defeated and repeatedly bonked on the head, scrambling your brains.", hooligansBs, null,
            2, "You perform a series of magic tricks and the family gives you a look of amazement and lets you pass.",
            "You defeat the family in combat and take all their belongings, Give out 2 drinks",
            100, 75, 60)
        mEvents.add(hooligansEvent)
        val mudThingBs = BadStuff(0, "", 0, "", "Drink 2, Miss a turn")
        val mudThingEvent = Event("Mud Creature", R.drawable.e_mud_thing,
            "A mud create rises from the dirt around you are lets out a groaning roar",
            "Running is near impossible as you are stuck in the mud and creature swallows you, trapping you in mud",
            mudThingBs, null, 2, "You speak some mud person language to the creature and it moans, letting you past.",
            "You cast a small fireball spell and blast the creature to kingdom come, Give out 2 drinks", 95, 95, 1000)
        mEvents.add(mudThingEvent)
        val redOctopusBs = BadStuff(-1, "", 0, "", "Drink 1")
        val redOctopusEvent = Event("Angry Small Red Octopus", R.drawable.e_red_small_octopus,
            "An angry looking small red octopus slithers up to you and angrily slurps",
            "The octopus sucks your face and gives you a multitude of hickies.", redOctopusBs, null,
            1, "You stroke the octopus and calm it down, Give out 1 drink",
            "You slap the octopus with a gloved hand and it weeps, Drink 1 to live with yourself.",
            50,55, 60)
        mEvents.add(redOctopusEvent)
        val thiefBs = BadStuff(-1, "", 0, "t", "Drink 1, Lose your trinket, Lose a Level")
        val thiefEvent = Event("A Hooded Thief", R.drawable.e_thief,
            "A hooded thief emerges from the shadows with their dagger raised, ready to strike you",
            "The thief stabs you in the shoulder and steals your trinket before running away into a nearby alleyway.",
            thiefBs, null, 2, "The thief recognises you as a friend from the tavern and gives you some treasure to help you on your " +
                    "way, you go to the tavern to catch up, Everybody Drinks.", "You quickly react and the thief runs onto your blade, dying instantly, Give out 2 drinks",
            75, 70, 60)
        mEvents.add(thiefEvent)
        val sGhostBs = BadStuff(-1, "", 0, "", "Drink 2, Lose a Level, You've been spooked")
        val sGhostEvent = Event("A Not Very Spooky Ghost", R.drawable.e_ghost,
            "A not very spooky ghost comes through the wall and attempts to spook you.",
            "You poop yourself from fright and feel rather ashamed", sGhostBs, null, 1,
            "You are completely unaffected and the ghost looks rather disappointed and floats away.",
            "You grab the ghost and realise it's just a man wearing a cloth sheet, Give out 1 drink.", 50, 55, 60)
        mEvents.add(sGhostEvent)
        val sGhostDogBs = BadStuff(0, "", 0, "", "Nothing happens")
        val sGhostDogEvent = Event("A Spooky Ghost Dog", R.drawable.e_ghost_dog,
            "A spooky ghost dog appears, panting heavily with it's tongue out.",
            "The spooky dog jumps on you and licks your face, doing nothing.", sGhostDogBs, null,
            1, "You pet the ghost dog and it licks your hand happily.",
            "You stomp of the ghost dog and it explodes into ectoplasm, you're a bastard, finish your drink.",
            40, 40, 60)
        mEvents.add(sGhostDogEvent)
        val spikeTrapCurse = Curse("", 0, 0, 0)
        val spikeTrapEvent = Event("Spike Trap!!", R.drawable.c_spike_trap, "A pit of spike appears at your feet!! " +
                "The last person to jump into the air has to drink twice", "", null, null, 0,
            "", "", 0, 0, 0, spikeTrapCurse)
        mEvents.add(spikeTrapEvent)
        val lovePotionCurse = Curse("", 0, 0, 0)
        val lovePotionEvent = Event("Love Potion", R.drawable.c_love_potion, "You purchase a love potion!! " +
                "Choose another player, they must drink every time you do and vice versa, if you have another mate already, this cancels it out",
            "", null, null, 0, "", "", 0, 0, 0, lovePotionCurse)
        mEvents.add(lovePotionEvent)
        val eatSlugsCurse = Curse("", 0, 0)
        val eatSlugsEvent = Event("Eat Slugs!!", R.drawable.c_eat_slugs, "You have been enchanted!! You now have a wild hankering " +
                "for slimy slugs, miss a turn", "", null, null, 0, "", "",
            0,0,0, eatSlugsCurse)
        mEvents.add(eatSlugsEvent)
        val hypnotizedCurse = Curse("", 0, 0)
        val hypnotizedEvent = Event("Hypnotized!!", R.drawable.c_hypnotized, "You have been hypnotised!! " +
                "Next time someone must take a shot, you do it instead, if multiple people have " +
                "to take shots, nobody except you has to drink for one person", "", null, null, 0, "",
        "", 0, 0, 0, hypnotizedCurse)
        mEvents.add(hypnotizedEvent)
        val diseasedCurse = Curse("", 0, 0)
        val diseasedEvent = Event("Plagued!!", R.drawable.c_plagued, "You've caught the plague!! " +
                "Every time someone makes eye contact with you, they must drink. This lasts for 2 rounds.", "", null, null,
            0, "", "", 0, 0, 0, diseasedCurse)
        mEvents.add(diseasedEvent)
        val babyDragonBs = BadStuff(0, "", 0, "", "Drink 1, Unlucky buddy")
        val babyDragonEvent = Event("Adorable Baby Dragon", R.drawable.e_baby_dragon,
            "You stumble across a tiny little baby dragon looking up at you with it's big cute eyes",
            "The baby dragon bites your hand and embarrasses you in front of your friends", babyDragonBs,
            null, 1, "You give the baby dragon a cuddle and it looks very content",
            "You dropkick the baby dragon and it goes flying, bonking it's head on the ground, it waddles away grumpily, give out 1 drink",
            40, 40, 40)
        mEvents.add(babyDragonEvent)
        val dSwordsmanBs = BadStuff(-1, "", 0, "", "Lose a level, Drink 2")
        val dSwordsmanEvent = Event("Distinguished Swordsman", R.drawable.e_distinguished_swordsman,
            "You bump shoulders another traveller who takes offence at your impolite manner, his moustache is waxed and distinguished",
            "The gentleman swishes his sword, leaving you with multiple slashes and cuts", dSwordsmanBs,
            null, 2, "You bow politely at the gentleman and he accepts your apology, give out 1 drink",
            "You best the swordsman in a drawn out duel, give out a shot", 130, 70, 60)
        mEvents.add(dSwordsmanEvent)
        val undeadBs = BadStuff(-1, "", 0, "", "Lose a level, Drink 2")
        val undeadEvent = Event("Undead", R.drawable.e_undead, "A member of the undead approaches you, mumbling and stumbling slowly, " +
                "they don't look very friendly", "The zombie swipes at you, you pee yourself and run away",
            undeadBs, null, 1, "You distract the zombie with a piece of raw meat and it leaves you alone",
            "You stab the zombie in the head and it goes rigid and falls to the ground, double dead", 55, 60, 50)
        mEvents.add(undeadEvent)
        val gnomeBs = BadStuff(0, "", 0, "f", "Drink 1, Lose your foot gear")
        val gnomeEvent = Event("Garden Gnome", R.drawable.e_gnome, "You feel a poking in your leg, just to find " +
                "a small gnome looking up at you, turns out you have trespassed on his land",
            "The gnome smacks you in the face with a shovel and knocks you out, then he steals your shoes", gnomeBs,
            null, 1, "You apologise to the gnome and he invites you into his home, unfortunately you are " +
                    "too large and instead you have a beer and sit on some giant mushrooms",
            "You disarm the gnome and threaten him back into his home, give out one drink", 50, 50, 60, null)
        mEvents.add(gnomeEvent)
        val zombieHordeBs = BadStuff(-1, "", 0, "", "Drink 3, Lose a level")
        val zombieHordeEvent = Event("Zombie horde", R.drawable.e_zombie_horde, "A horrible stench fills your noses and you see a small horde of " +
                "the undead stumble slowly over a hill towards you.", "The horrible stench is so unbearable you have to flee or you might pass out",
            zombieHordeBs, null, 2, "You chop off your pinkie and give it to the alpha zombie as a peace offering, " +
                    "the horde carries on past you, give out 3 drinks", "You hack and slash with zombie parts flying every where as " +
                    "you cut the zombies to pieces, give out 3 drinks", 75, 90, 50)
        mEvents.add(zombieHordeEvent)
        val giantSquidBs = BadStuff(0, "", 0, "", "Drink for X times, X being your number of status points")
        val giantSquidEvent = Event("Giant Squid", R.drawable.e_giant_squid, "You go for a beach trip to soak in some sun only to " +
                "encounter a giant squid!! watch out before it inks you!!", "The squid squeezes you tightly and you inks on your face," +
                "the higher status you are the more embarrassing", giantSquidBs, null, 2,
            "You stand completely still and silent and the squids poor vision misses you and it passes by, drink 1",
            "The squid grabs you and brings you closer but you punch it in it's massive eye and it let's you go, give " +
                    "out 2 drinks you legend", 65, 75, 70)
        mEvents.add(giantSquidEvent)
        val chickenBs = BadStuff(-1, "", 0, "", "Drink for X times, X being your number of status points")
        val chickenEvent = Event("Relatively Large Chicken", R.drawable.e_chicken, "A relatively large chicken runs out in front of you and " +
                "starts clucking aggressively, maybe it can smell the fried chicken you had earlier...",
            "The chicken overpowers you and pecks your face, it hurts a bit", chickenBs, null, 1,
            "You throw some leftover bread to the chicken and you run past whilst it's distracted",
            "You stab the chicken dead and it let's out a pathetic squawk and keels over", 40, 40,
            60)
        mEvents.add(chickenEvent)
        val elderDragonBs = BadStuff(-2, "", 0, "", "Drink 3, Lose two levels")
        val elderDragonEvent = Event("Elderly Dragon", R.drawable.e_elder_dragon, "You hear a coughing behind you, " +
                "you turn around to see an old wrinkly dragon peering at you through it's reading glasses",
            "The dragon sweeps you legs away with it's walking stick and then steps on your head", elderDragonBs,
            null, 3, "You converse with the dragon about how taxes are too high and reminisce about the " +
                    "good old days, give out 1 shot", "You knock away the dragon's walking stick and break it's glasses, rendering it " +
                    "basically useless, it yells some curses at you and shakes it's fist, give out 3 drinks", 80, 100, 60)
        mEvents.add(elderDragonEvent)
        val barbarianBs = BadStuff(-1, "", 0, "", "Drink 2, Lose a level")
        val barbarianEvent = Event("Barbarian Warrior", R.drawable.e_barbarian, "Roaring and shouting an angry barbarian comes charging towards you, " +
                "coming to plunder your treasure", "The barbarian cuts you up, a lot, and it hurts",
            barbarianBs, null, 2, "You charge back towards the barbarian and let out your own roar, " +
                    "scaring the barbarian back to whence he came", "You dodge the barbarian's axe swings and stab him dead, Give out 2 drinks",
            60, 55, 60)
        mEvents.add(barbarianEvent)
        val rockGolemBs = BadStuff(-2, "", 0, "", "Drink 1, Lose two Levels")
        val rockGolemEvent = Event("Magical Rock Golem", R.drawable.e_rock_golem, "A hulking stone giant comes out of a stone rock face and barrels towards you",
            "The golem crushes you with it's giant fists and you get thrown into a river unconscious", rockGolemBs,
            null, 3, "You itch a scratch on the golems back with your sword as it doesn't have proper hands, give out 3 drinks",
            "With a mighty blow, you hit the golem and a crack appears on it's chest which grows until the golem splits in two, the poor golem grumbles and " +
                    "just looks sad, everybody drinks", 90, 120, 45)
        mEvents.add(rockGolemEvent)
        val bigOrcBs = BadStuff(-1, "", 0, "", "Drink 5, Lose a level")
        val bigOrcEvent = Event("Big Dumb Orc", R.drawable.e_big_orc, "You come across a village ransacked by one big orc, " +
                "the orc spots you and grins as it stomps on a villager, then makes it's way towards you",
            "The orc stomps on you and throws you around like a rag doll, however before it can finish you off it gets distracted by a butterfly and runs after it",
            bigOrcBs, null, 2, "You distract the orc with a large ball of string and it shoos you away so it can play with it's new toy, give out 2 drinks",
            "You dodge, weave and slash at the orc until it keels over and dies, give out 5 drinks", 90, 50, 60)
        mEvents.add(bigOrcEvent)
        val smallOrcBs = BadStuff(0, "", 0, "", "Drink 2")
        val smallOrcEvent = Event("Small Orc", R.drawable.e_single_orc, "A single angry yet slightly " +
                "confused looking orc blocks your path, it roars at you before picking up its spear and pointing it at you",
            "The orc pokes you in the head with its spear, ouchie", smallOrcBs, null, 1,
            "You lower your weapon and the orc is so confused it doesn't know what to do, it walks away in a mood because " +
                    "you refused to fight", "You stab the orc in the tummy and it dies horribly, give 2 drinks",
            55, 50, 60)
        mEvents.add(smallOrcEvent)
        val orcRaidingPartyBs = BadStuff(-2, "", 0, "", "Drink 5, Lose 2 levels")
        val orcRaidingPartyEvent = Event("Orc Raiding Party", R.drawable.e_orc_raiding_party,
            "The village you're staying in comes under attack from a small raiding party of orcs, they've come to " +
                    "steal your stuff", "The orcs beat you up and mercilessly embarrass you in front of the whole village",
            orcRaidingPartyBs, null, 4, "You convince the dumb orcs you are a powerful wizard who will turn them into frogs " +
                    "and they run away crying, give 2 drinks", "You nimbly weave between the orcs stabbing and slashing till no orc is left standing, " +
                    "you are the hero of the village, give 1 shot", 100, 75, 60)
        mEvents.add(orcRaidingPartyEvent)
        val unicornBs = BadStuff(0, "", 0, "w", "Drink 3, Lose your weapon")
        val unicornEvent = Event("Small Grumpy Unicorn", R.drawable.e_unicorn,
            "The unicorn grumbles and gives you an unimpressed look, it's cleary not very happy", "The unicorn zaps your weapon with it's " +
                    "magic horn and turns it into candy", unicornBs, null, 1, "You stroke the unicorn's horn and it looks " +
                    "a bit less grumpy, give out a shot", "You cut off the unicorn's horn and it wails in pain and curses you, take a shot", 65, 65, 60)
        mEvents.add(unicornEvent)
        val vampireBs = BadStuff(-1, "", 0, "", "Drink 3, Lose a level")
        val vampireEvent = Event("A Spooky Vampire", R.drawable.e_vampire,
            "A scary spooky vampire surprises you as you're falling asleep, it hisses and bears it's fangs",
            "The vampire sucks you dry and it hurts quite a bit, you need to get some fluid back into you", vampireBs,
            null, 2, "You barter with the vampire and convince it your blood tastes rubbish, give out 3 drinks",
            "You throw some garlic and the vampire and it scampers off hissing, give out 2 drinks", 50, 60, 60)
        mEvents.add(vampireEvent)

        return mEvents
    }
}