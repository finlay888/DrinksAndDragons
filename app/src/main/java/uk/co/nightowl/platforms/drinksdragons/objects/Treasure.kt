package uk.co.nightowl.platforms.drinksdragons.objects

import uk.co.nightowl.platforms.drinksdragons.R
import uk.co.nightowl.platforms.drinksdragons.models.Treasure

object Treasure {
    fun setTreasure() : ArrayList<Treasure> {
        val treasure = ArrayList<Treasure>()
        val spikyHelm = Treasure(
            "Spiky Helm", "Ouch, it's rather spiky", "h", 1, 5, 0, 0,
                R.drawable.t_spikey_helmet)
        treasure.add(spikyHelm)
        val fancySteel = Treasure(
            "Fancy Steel Plate", "Someone's rather fancy", "c", 2, 6, 2, 0,
                R.drawable.t_fancy_steel_plate)
        treasure.add(fancySteel)
        val woodenChest = Treasure(
            "Wooden Plank", "Plain and simple, mother nature's protection", "c", 1, 5, 0, 0,
                R.drawable.t_wooden_plank)
        treasure.add(woodenChest)
        val legendHat = Treasure(
            "Totally awesome hat", "This hat will guide you to becoming a total legend", "h", 3, 10, 10, 5,
                R.drawable.t_beer_hat)
        treasure.add(legendHat)
        val topHat = Treasure(
            "Distinguished Gentleman's hat", "For distinguished gentlemen only", "h", 1, 7, 0, 0,
                R.drawable.t_top_hat)
        treasure.add(topHat)
        val trafficCone = Treasure(
            "Weegie Warrior Helm","Provides great protection from the sharpest of knives", "h", 2, 5, 8, 0,
            R.drawable.t_traffic_cone_helmet)
        treasure.add(trafficCone)
        val bucketHat = Treasure("Really Cool Bucket Hat", "As soon as you put it on, you feel more vibey already", "h", 2, 0, 13, 0,
            R.drawable.t_bucket_hat)
        treasure.add(bucketHat)
        val wolverineGauntlet = Treasure("Wolverine Gauntlet", "Made of Adamantium and totally awesome", "w", 3, 15, 0, 0,
            R.drawable.t_wolverine_gauntlet)
        treasure.add(wolverineGauntlet)
        val spikyTrousers = Treasure("Rather Spiky Trousers", "Nobody is gonna come near you in these!", "l", 1, 5, 0, 0,
            R.drawable.t_spikey_trousers)
        treasure.add(spikyTrousers)
        val spikyBoots = Treasure("Spiky Boots", "You don't want to get kicked by these", "f", 1, 5, 0, 0,
            R.drawable.t_spikey_boots)
        treasure.add(spikyBoots)
        val smallFish = Treasure("Small Fish", "A small, one-handed fish", "w", 1, 5, 0, 0,
            R.drawable.t_small_fish)
        treasure.add(smallFish)
        val bigFish = Treasure("Big Fish", "This one's a big fella", "w", 2, 8, 0, 0,
            R.drawable.t_big_fish)
        treasure.add(bigFish)
        val rippedShorts = Treasure("Ripped Shorts", "They don't give much protection, but they do show off your booty",
            "l", 1, 0, 5, 0, R.drawable.t_ripped_shorts)
        treasure.add(rippedShorts)
        val stompers = Treasure("Stompers", "Stomp Stomp Stomp", "f", 2, 10, 0, 0,
            R.drawable.t_stompers)
        treasure.add(stompers)
        val cuteWellies = Treasure("Cute Wellies", "Mesmerisingly adorable polka dots", "f", 2, 0, 10, 5,
            R.drawable.t_cute_wellies)
        treasure.add(cuteWellies)
        val kitchenKnife = Treasure("Kitchen Knife", "It can cut more than just mushrooms", "w", 1, 5, 0, 0,
            R.drawable.t_kitchen_knife)
        treasure.add(kitchenKnife)
        val butcherKnife = Treasure("Butcher's Cleaver", "It could do with a sharpen", "w", 1, 6, 0, 0,
            R.drawable.t_butcher_knife)
        treasure.add(butcherKnife)
        val leatherBooties = Treasure("Leather Booties", "Smooth and comfy yet rather stylish", "f", 1, 0, 5, 5,
            R.drawable.t_leather_booties)
        treasure.add(leatherBooties)
        val standardTrousers = Treasure("Standard Trousers", "They'll probably protect you a bit", "l", 1, 5, 0, 0,
            R.drawable.t_standard_combat_trousers)
        treasure.add(standardTrousers)
        val samuraiHelmet = Treasure("Samurai Helmet", "Protects you as you feel the ancient samurai power flow through you", "h",
            3, 15, 5, 0, R.drawable.t_samurai_helmet)
        treasure.add(samuraiHelmet)
        val brokenBottle = Treasure("Broken Bottle", "It's pretty sharp, but somewhat useless", "w", 1, 5, 0, 0,
            R.drawable.t_broken_bottle)
        treasure.add(brokenBottle)
        val fancySteelBoots = Treasure("Fancy Steel Boots", "Fancy boots for fancy people", "f", 2, 6, 6, 0,
            R.drawable.t_fancy_steel_plate_boots)
        treasure.add(fancySteelBoots)
        val kilt = Treasure("Kilt", "Makes you look cool as heck and lets you air your private parts", "l", 2, 5, 10, 0,
            R.drawable.t_kilt)
        treasure.add(kilt)
        val noblemanBoots = Treasure("Fancy Nobleman Shoes", "Very stylish and cool", "f", 1, 0, 5, 0,
            R.drawable.t_fancy_nobleman_shoes)
        treasure.add(noblemanBoots)
        val dragonHelmet = Treasure("Dragon Hunter's Helmet", "For certified dragon hunters only", "h",
            2, 10, 0, 0, R.drawable.t_dragon_hunter_head)
        treasure.add(dragonHelmet)
        val dragonChest = Treasure("Dragon Hunter's Chestplate", "For certified dragon hunters only", "c",
            2, 10, 0, 0, R.drawable.t_dragon_hunter_chest)
        treasure.add(dragonChest)
        val dragonLegs = Treasure("Dragon Hunter's Legplates", "For certified dragon hunters only", "l",
            2, 5, 5, 0, R.drawable.t_dragon_hunter_trousers)
        treasure.add(dragonLegs)
        val dragonFeet = Treasure("Dragon Hunter's Boots", "For certified dragon hunters only", "f",
            2, 10, 0, 0, R.drawable.t_dragon_hunters_boots)
        treasure.add(dragonFeet)
        val dragonBow = Treasure("Dragon Hunter's Crossbow", "For certified dragon hunters only", "w",
            2, 10, 0, 0, R.drawable.t_dragon_hunter_crossbow)
        treasure.add(dragonBow)
        val blueTrousers = Treasure("Padded Blue Trousers", "Very blue and very comfy, they look like combat jeans", "l",
            1, 5, 0, 0, R.drawable.t_padded_blue_trousers)
        treasure.add(blueTrousers)
        val eternalFlame = Treasure("Bottle Of Eternal Flame", "It just seems to burn forever to be honest, It's not even that hot", "t", 1,
            3, 3, 0, R.drawable.t_bottle_of_eternal_flame)
        treasure.add(eternalFlame)
        val bonsaiTree = Treasure("Bonsai Tree", "People you show it to are impressed with how well kept it is, little do they know it's plastic", "t",
            2, 0, 10, 0, R.drawable.t_well_trimmed_bonsai)
        treasure.add(bonsaiTree)
        val rosary = Treasure("Rosary", "The power of christ compels you to fight better", "t", 1, 5, 0, 0,
            R.drawable.t_rosarry)
        treasure.add(rosary)
        val adChest = Treasure("Adventurer's Armour", "Putting it on gives you the thrill of adventure", "c", 2, 4, 4, 4,
            R.drawable.t_adventurer_chest)
        treasure.add(adChest)
        val avrgeSword = Treasure("Basic Sword", "Extremely average and basic in every way", "w", 1, 6, 0, 0,
            R.drawable.t_average_sword)
        treasure.add(avrgeSword)
        val bucketHelmet = Treasure("Bucket Helmet", "Provides ultimate protection from rocks and sticks, but not much else",
            "h", 1, 3, 0, 0, R.drawable.t_bucket_helmet)
        treasure.add(bucketHelmet)
        val bunnyEars = Treasure("Fluffy Bunny Ears", "Fluffy tail not included", "h", 2, 0, 10, 0,
            R.drawable.t_bunny_ears)
        treasure.add(bunnyEars)
        val coolGlasses = Treasure("Cool Glasses", "They don't even have lenses but they're still pretty dope.", "h", 1, 0, 5, 0,
            R.drawable.t_cool_glasses)
        treasure.add(coolGlasses)
        val exoticArmour = Treasure("Exotic Armour", "Very unique and feathery, must be from somewhere far away", "c",
            2, 10, 0, 5, R.drawable.t_exotic_armour)
        treasure.add(exoticArmour)
        val fethrdBandana = Treasure("Feathery Bandanna", "The feathers are from a pigeon but they'll do", "h", 1, 0, 5, 0,
            R.drawable.t_feathered_bandana)
        treasure.add(fethrdBandana)
        val hawaiianShirt = Treasure("Hawaiian Shirt", "The shirt lightens everyone's moods, making you all feel like you're on holiday", "c", 2, 0, 10, 0,
            R.drawable.t_hawaiin_shirt)
        treasure.add(hawaiianShirt)
        val headScarf = Treasure("Headscarf","Rather cosy, Protects from harsh sunlight","h", 1, 3, 0, 0,
            R.drawable.t_headscarf)
        treasure.add(headScarf)
        val ironChest = Treasure("Iron ChestPlate", "Sturdy and strong, made for proper battle n stuff", "c", 2, 10, 0, 0,
            R.drawable.t_iron_chest)
        treasure.add(ironChest)
        val leatherCap = Treasure("Leather Cap", "A simple leather hat, provides little protection against anything", "h", 1, 3, 0, 0,
            R.drawable.t_leather_cap)
        treasure.add(leatherCap)
        val nobleCap = Treasure("Nobleman's Cap", "The colour shows how fancy you are", "h", 2, 6, 6, 0,
            R.drawable.t_nobleman_cap)
        treasure.add(nobleCap)
        val oldWizardCap = Treasure("Old Wizard Cap", "It seems to have lost it's magical powers, it just looks cool", "h", 1, 0, 5, 0,
            R.drawable.t_old_wizards_hat)
        treasure.add(oldWizardCap)
        val paddedVest = Treasure("Padded Vest", "Protects the most vital organs from stabbing", "c", 1, 5, 0, 0,
            R.drawable.t_padded_vest)
        treasure.add(paddedVest)
        val potHelmet = Treasure("Pot Helmet", "It smells of fresh cooked bolognese sauce", "h", 1, 5, 0, 0,
            R.drawable.t_pot_helmet)
        treasure.add(potHelmet)
        val rGlasses = Treasure("Reinforced Glasses", "Reinforced lenses for sensitive eyes", "h", 1, 3, 0, 0,
            R.drawable.t_rienforced_glasses)
        treasure.add(rGlasses)
        val rGHelmet = Treasure("Royal Guardsmen Helmet", "Given to the royal guardsmen upon conscription, gives you authority over your average peasant",
            "h", 2, 8, 2, 0, R.drawable.t_royal_guardsmen_helmet)
        treasure.add(rGHelmet)
        val tShirt = Treasure("Clean T-Shirt", "Immaculately clean somehow", "c", 1, 0, 3, 0,
            R.drawable.t_shirt)
        treasure.add(tShirt)
        val sSpikeHelm = Treasure("Single Spike Helm", "Minimal spikes and minimal protection", "h", 1, 6, 0, 0,
            R.drawable.t_single_spike_helm)
        treasure.add(sSpikeHelm)
        val steelCap = Treasure("Steel Cap", "Hardened steel cap, protects you from heavy hits", "h", 1, 7, 0, 0,
            R.drawable.t_steel_cap)
        treasure.add(steelCap)
        val veganHelmet = Treasure("Vegan Helmet", "Wearing it instantly makes you hate bacon", "h", 1, 0, 5, 0,
            R.drawable.t_vegan_helmet)
        treasure.add(veganHelmet)
        val whip = Treasure("Archeologist's Whip", "Will help you on your way to finding the lost ark", "w", 2, 5, 0, 5,
            R.drawable.t_archiologists_whip)
        treasure.add(whip)
        val barbAxe = Treasure("Barbarian's Axe", "Covered in the blood of previous victims, very intimidating", "w", 2, 10, 3, 0,
            R.drawable.t_barbarian_axe)
        treasure.add(barbAxe)
        val bSpear = Treasure("Average Spear", "Extremely average and basic in every way", "w", 1, 5, 0, 0,
            R.drawable.t_basic_spear)
        treasure.add(bSpear)
        val fancySword = Treasure("Fancy Sword", "Fancy Sword for Fancy People", "w", 2, 8, 5, 0,
            R.drawable.t_fancy_sword)
        treasure.add(fancySword)
        val pencil = Treasure("Pencil", "Sharpened HB pencil for enhanced eye poking", "w", 1, 2, 0, 0,
            R.drawable.t_pencil)
        treasure.add(pencil)
        val pickaxe = Treasure("Rusty Pickaxe", "It can do more than just mine gold", "w", 1, 4, 0, 0,
            R.drawable.t_pickaxe)
        treasure.add(pickaxe)
        return treasure
    }
}