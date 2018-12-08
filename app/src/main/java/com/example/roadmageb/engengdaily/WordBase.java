package com.example.roadmageb.engengdaily;


import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;

public class WordBase extends AppCompatActivity {
    private HashMap<String, String> wordDB;
    private ArrayList<String> todayWord;
    public ArrayList<WordStat> wordStat;
    private ArrayList<String> unWord;
    private ArrayList<String> words;
    public static WordBase inst = new WordBase();
    String wonmoon = "abacus\tframe with balls for calculating\n" +
            "abate\tto lessen to subside\n" +
            "abdication\tgiving up control authority\n" +
            "aberration\tstraying away from what is normal\n" +
            "abet\thelp/encourage smb (in doing wrong)\n" +
            "abeyance\tsuspended action\n" +
            "abhor\tto hate to detest\n" +
            "abide\tbe faithful to endure\n" +
            "abjure\tpromise or swear to give up\n" +
            "abraded\trubbed off worn away by friction\n" +
            "abrogate\trepeal or annul by authority\n" +
            "abscond\tto go away suddenly (to avoid arrest)\n" +
            "abstruse\tdifficult to comprehend obscure\n" +
            "abut\tborder on\n" +
            "abysmal\tbottomless extreme\n" +
            "acarpous\teffete no longer fertile worn out\n" +
            "acclaimed\twelcomed with shouts and approval\n" +
            "accolade\tpraise approval\n" +
            "accretion\tthe growing of separate things into one\n" +
            "adamant\tkind of stone inflexible\n" +
            "admonitory\tcontaining warning\n" +
            "adorn\tadd beauty decorate\n" +
            "adulteration\tmaking unpure poorer in quality\n" +
            "affable\tpolite and friendly\n" +
            "affinity\tclose connection relationship\n" +
            "aggravate\tmake worse irritate\n" +
            "agile\tactive quick-moving\n" +
            "agog\teager/excited\n" +
            "ail\ttrouble be ill\n" +
            "alacrity\teager and cheerful readiness\n" +
            "alcove\trecess/partially enclosed place\n" +
            "allegiance\tduty support loyalty\n" +
            "alleviate\tmake (pain) easier to bear\n" +
            "alloy\tto debase by mixing with something inferior\n" +
            "aloof\treserved indifferent\n" +
            "amalgamate\tmix combine unite societies\n" +
            "ambidextrous\table to use the left hand or the right equally well\n" +
            "ambiguous\tdoubtful uncertain\n" +
            "ambivalent\thaving both of two contrary meanings\n" +
            "ameliorate\timprove make better\n" +
            "amortize\tend (a debt) by setting aside money\n" +
            "anguish\tsevere suffering\n" +
            "animosity\tstrong dislike\n" +
            "antidote\tmedicine used against a poison or a disease\n" +
            "antithetical\tdirect opposing\n" +
            "apartheid\tbrutal racial discrimination\n" +
            "aplomb\tself-confidence\n" +
            "apostate\tone who abandons long-held religious or political convictions\n" +
            "apotheosis\tdeification glorification to godliness\n" +
            "appease\tmake quiet or calm\n" +
            "apprehensive\tgrasping understanding fear unhappy feeling about future\n" +
            "apprise\tgive notice to inform\n" +
            "approbation\tapproval\n" +
            "apropos\tappropriate to the situation apt\n" +
            "apt\twell-suited quick-witted\n" +
            "arabesque\ta complex ornate design\n" +
            "arboreal\tof connected with trees\n" +
            "ardor\tenthusiasm\n" +
            "arduous\tsteep difficult ascent laborious\n" +
            "argot\tjargon slang\n" +
            "arrant\tin the highest degree\n" +
            "arrogance\tproud superior manner of behaviour\n" +
            "articulate\tspeak distinctly connect by joints\n" +
            "ascend\tgo or come up\n" +
            "ascertain\tget to know\n" +
            "ascetic\tpracticing self-denial austere stark\n" +
            "ascribe\tconsider to be the origin of or belonging to\n" +
            "aseptic\tsurgically clean\n" +
            "asperity\troughness harshness ill temper irritability\n" +
            "aspersion\tslander\n" +
            "assail\twith attack violently\n" +
            "assiduous\tdiligent hard-working sedulous\n" +
            "assuage\tmake smth (pain desire) less\n" +
            "asterisk\tthe mark * (e.g.. omitted letters)\n" +
            "astringent\tsubstance that shrinks\n" +
            "astute\tclever quick at seeing to get an advantage\n" +
            "atonement\trepayment death of Jesus\n" +
            "attenuate\tmake thin. weaken enervate\n" +
            "attune\tbring into harmony\n" +
            "audacious\tdaring foolishly bold impudent\n" +
            "augury\tomen sign\n" +
            "august\tmajestic venerable\n" +
            "auspicious\tfavorable successful prosperous\n" +
            "austere\tseverely moral and strict simple and plain\n" +
            "auxiliary\thelping supporting\n" +
            "aver\taffirm assert prove justify\n" +
            "aversion\tstrong dislike\n" +
            "avid\teager greedy\n" +
            "avow\tadmit. Declare openly\n" +
            "baleful\tharmful ominous causing evil\n" +
            "balk\tobstacle purposely to get on the way of\n" +
            "baneful\tcausing harm or ruin pernicious destructive\n" +
            "barrage\tartificial obstacle built across a river\n" +
            "barren\tnot good enough unable to have young ones without value\n" +
            "bask\tin enjoy warmth and light\n" +
            "beatify\tto bless make happy or ascribe a virtue to\n" +
            "bedizen\tto adorn especially in a cheap showy manner\n" +
            "belabor\tbeat hard\n" +
            "bellicose\tbelligerent pugnacious warlike\n" +
            "belligerent\t(person nation) waging war\n" +
            "benefactor\tperson who has given help\n" +
            "benevolence\twish or activity in doing good\n" +
            "benign\tkind and gentle mild (climate)\n" +
            "bequest\tarrangement to give smth at death\n" +
            "berate\tscold sharply\n" +
            "bereft\trob or dispossess of smth (material)\n" +
            "bewilder\tpuzzle confuse\n" +
            "bigot\tstubborn narrow-minded person\n" +
            "bilge\tbulge the protuberance of a cask\n" +
            "blandishment\tflattery coaxing\n" +
            "blandness\tpolite manner comforting uninteresting\n" +
            "blatant\tnoisy and rough\n" +
            "blithe\tcheerful casual carefree\n" +
            "bogus\tsham counterfeit not genuine\n" +
            "boisterous\tloud noisy rough lacking restraint\n" +
            "bolster\tgive greatly needed support\n" +
            "boorish\tcrude offensive rude\n" +
            "brash\thasty rush cheeky saucy\n" +
            "brass\tyellow metal (mixing copper and zinc)\n" +
            "brazen\tmade of brass\n" +
            "breach\topening broken place breaking\n" +
            "brittle\teasily broken\n" +
            "broach\tbring up announce begin to talk about\n" +
            "brook\tto tolerate endure\n" +
            "buoyant\table to float light-hearted\n" +
            "burgeon\tgrow forth send out buds\n" +
            "burnish\tto polish rub to a shine\n" +
            "cabal\ta scheme or plot a group of plotters\n" +
            "cadge\tto beg to get by begging\n" +
            "cajole\tuse flattery or deceit to persuade\n" +
            "calipers\tmetal supports attached to the legs measuring instrument\n" +
            "calumny\tslander aspersion\n" +
            "candid\tfrank straight-forward\n" +
            "cant\tinsincere talk/jargon\n" +
            "cantankerous\tbad-tempered/quarrelsome\n" +
            "canvass\tdiscuss thoroughly sort of touting\n" +
            "castigate\tto chastise correct by punishing\n" +
            "castigation\tsevere punishment\n" +
            "catalyst\tsubstance that causes speeding up\n" +
            "caustic\tbiting sarcastic\n" +
            "censure\texpression of blame or disapproval a rebuke\n" +
            "centurion\tleader of a unit of 100 soldiers\n" +
            "chary\tcautious wary\n" +
            "chastened\tcorrected punished\n" +
            "chastisement\tpunishment\n" +
            "chauvinist\ta blindly devoted patriot\n" +
            "chicanery\tlegal trickery/false argument\n" +
            "chisel\tsteel tool for shaping materials\n" +
            "churl\tbad-tempered person\n" +
            "clamor\tshout complain with a lot of noise\n" +
            "clientele\tcustomers\n" +
            "clinch\tcome to grips/settle conclusively\n" +
            "cling\tto resist separation\n" +
            "clot\thalf-solid lump formed from liquid\n" +
            "cloture\tclosing device (in Parliament) to end a debate by voting\n" +
            "coagulation\tchange to a thick and solid state\n" +
            "coalescing\tcoming together and uniting into one substance\n" +
            "coax\tget smb to do smth by kindness\n" +
            "coda\tpassage that completes a piece of music\n" +
            "coddle\ttreat with care and tenderness\n" +
            "coerce\tcompel to force to make obedient\n" +
            "coeval\tof the same period coexisting\n" +
            "cogent\tstrong convincing\n" +
            "cogitate\tthink deeply mediate\n" +
            "cognizant\tbeing fully aware of\n" +
            "colander\tbowl-shaped vessel with many holes used to drain off water\n" +
            "collusion\tsecret agreement for a deceitful purpose\n" +
            "combustion\tprocess of burning\n" +
            "commemorate\tkeep the memory of\n" +
            "commodious\thaving plenty of space for what is needed\n" +
            "commuter\tperson who travels regularly\n" +
            "complaisance\ttending to comply obliging willingness to please\n" +
            "compunction\tfeeling of regret for one's action\n" +
            "conceal\thide keep secret\n" +
            "conceit\tover-high opinion of too much pride\n" +
            "conciliatory\treconciling soothing comforting mollifying\n" +
            "concord\tagreement or harmony\n" +
            "concur\tagree in opinion happen together\n" +
            "condense\tincrease in density strength make laconic\n" +
            "condone\tforgive\n" +
            "congeal\tmake or become stiff and solid\n" +
            "conjoin\tto join together\n" +
            "connoisseur\ta person with good judgement (e.g.. in art)\n" +
            "connotation\tsuggestion in addition to\n" +
            "consequential\tpompous self important\n" +
            "console\tgive comfort or sympathy to\n" +
            "conspicuous\teasily seen remarkable\n" +
            "consternation\tsurprise and fear dismay\n" +
            "constrain\tcompel\n" +
            "constrict\tmake tight or smaller\n" +
            "consume\tget to the end of\n" +
            "consummate\tperfect/make perfect/complete\n" +
            "contemn\tto scorn or despise\n" +
            "contentious\targumentative pugnacious combative quarrelsome\n" +
            "contiguous\ttouching neighboring near\n" +
            "contrite\tfilled with deep sorrow for wrongdoing\n" +
            "contumacious\tinsubordinate rebellious\n" +
            "conundrum\ta riddle dilemma enigma\n" +
            "conviction\tconvincing firm belief\n" +
            "convoke\tcall together summon\n" +
            "convoluted\tcomplicated coiled twisted\n" +
            "cordial\twarm and sincere\n" +
            "cordon\tline (of police acting as a guard)\n" +
            "cornucopia\tabundant supply\n" +
            "corporeal\tphysical of or for the body\n" +
            "correlate\thave a mutual relation\n" +
            "corroboration\tadditional strengthening evidence\n" +
            "countenance\tto favor or approve of\n" +
            "counterfeit\tforgery\n" +
            "countervail\tcounterbalance\n" +
            "covert\tdisguised\n" +
            "covetous\teagerly desirous\n" +
            "cower\tcrouch shrink back\n" +
            "coy\tshy/modest (esp of a girl)\n" +
            "crass\tvery great (es. stupidity)\n" +
            "cravat\tpiece of linen worn as a necktie\n" +
            "craven\tcowardly\n" +
            "crease\tline made by crushing white line on the ground in cricket\n" +
            "credulity\ttoo great a readiness to believe things\n" +
            "credulous\tready to believe things\n" +
            "crush\tpress lose shape subdue overwhelm\n" +
            "cryptic\tsecret with a hidden meaning\n" +
            "cumbersome\tburdensome heavy and awkward to carry\n" +
            "curmudgeon\tbad-tempered person\n" +
            "curriculum\tcourse of study\n" +
            "cursory\tquick hurried\n" +
            "curtail\tmake shorter then was planned\n" +
            "dainty\tpretty/delicate(food)/difficult to please\n" +
            "daunt\tintimidate make fearful\n" +
            "dawdler\tperson who is slow waste of time\n" +
            "dearth\tshortage\n" +
            "debacle\ta breakup overthrow sudden disaster\n" +
            "decorum\tpropriety properness\n" +
            "decree\torder given by authority\n" +
            "decry\tdisapprove of\n" +
            "defer\tpostpone give way (to show respect)\n" +
            "deferential\tshowing respect\n" +
            "defiance\topen disobedience or resistance\n" +
            "delineate\tto portray depict sketch out\n" +
            "deluge\tgreat flood heavy rush of water\n" +
            "demagogue\tperson appealing not to reasons\n" +
            "demur\tto hesitate raise objections\n" +
            "denigrate\tblacken belittle sully defame\n" +
            "denouement\tan outcome or solution the unraveling of a plot\n" +
            "deplete\tuse until none remains\n" +
            "deposition\tdethronement depositing\n" +
            "deprave\tmake morally bad corrupt\n" +
            "deprecate\tprotest against express disapproval of\n" +
            "dereliction\tdeserting and leaving to fall into ruins\n" +
            "derision\tridicule mockery deriding\n" +
            "derivative\tunoriginal obtained from another source\n" +
            "derogatory\tinsulting tending to damage\n" +
            "descry\tcatch sight of see smth in the distance\n" +
            "desiccant\tsubstance used to absorb moisture\n" +
            "desuetude\tcessation of use disuse\n" +
            "desultory\taimless haphazard digressing at random\n" +
            "deter\tdiscourage hinder\n" +
            "detraction\tslandering verbal attack aspersion\n" +
            "detumescence\tdiminishing or lessening of swelling\n" +
            "deviance\tbeing different in moral standards (from normal)\n" +
            "dexterity\tskill (esp. in handling)\n" +
            "diaphanous\ttransparent gauzy\n" +
            "diatribe\tbitter and violent attack in words\n" +
            "diffidence\tshyness\n" +
            "dilate\tspeak comprehensively become wider large\n" +
            "disallow\trefuse to allow or accept as a correct\n" +
            "discern\tsee with an effort but clearly\n" +
            "discomfit\tconfuse embarrass\n" +
            "disconcert\tupset the self-possession of\n" +
            "discountenance\trefuse to approve of\n" +
            "discourse\tspeech lecture\n" +
            "discredit\trefuse to believe\n" +
            "discreet\tcareful/prudent\n" +
            "discrete\tindividually distinct\n" +
            "disdain\tlook on with contempt\n" +
            "disencumber\tfree from encumbrance\n" +
            "disheveled\tuntidy\n" +
            "disingenuous\tsophisticated artful trying to deceive cunning\n" +
            "disinter\tdig up from the earth\n" +
            "dislodge\tmove force from the place occupied\n" +
            "dismal\tsad gloomy miserable\n" +
            "disparate\tessentially different\n" +
            "disproof\tproof to the contrary\n" +
            "dissemble\tspeak or behave so as to hide smth (in mind)\n" +
            "disseminate\tdistribute (esp. ideas)\n" +
            "dissent\thave a different opinion refuse to assent\n" +
            "dissolution\tdisintegration looseness in morals\n" +
            "distraught\tdistracted violently upset in mind\n" +
            "divergence\tgetting farther apart from a point\n" +
            "divestiture\ttaking off getting rid of giving up\n" +
            "divulge\tmake known smth secret\n" +
            "doggerel\ttrivial poorly constructed verse\n" +
            "dogmatic\tpositive certain arbitrary without room for discussion\n" +
            "dolt\tstupid fellow\n" +
            "dormant\tin a state of inactivity but awaiting development\n" +
            "dote\tshow much fondness center one's attention\n" +
            "drawl\tslow way of speaking\n" +
            "droll\tjesting\n" +
            "drone\tmale bee person who isn't self-employed\n" +
            "drowsiness\tfeeling sleepy half asleep\n" +
            "dubious\tfeeling doubt\n" +
            "dud\tno use person smth that fails\n" +
            "dulcet\tmelodious harmonious\n" +
            "dupe\tcheat make a fool of\n" +
            "duplicity\tdeliberate deception\n" +
            "duress\tthreats to compel smb\n" +
            "dwarf\tperson or smb much below the usual size\n" +
            "dynamo\ta generator something that produces electric current\n" +
            "earthenware\tdishes made of baked clay\n" +
            "ebullience\texuberance outburst of feeling\n" +
            "ebullient\toverflowing with enthusiasm showing excitement\n" +
            "ecumenical\trepresenting the whole Christian world\n" +
            "edacious\tvoracious devouring\n" +
            "eddy\tcircular or spiral movement (e.g.. of wind)\n" +
            "edible\tfit to be eaten/not poisonous\n" +
            "effete\tinfertile worn out weak\n" +
            "efficacy\tproduction of a desired result\n" +
            "effluvia\toutflow in a stream of particles a noxious odor or vapor\n" +
            "effrontery\tboldness impudence arrogance\n" +
            "egress\tway out exit\n" +
            "elaborate\tworked out with much care in great detail\n" +
            "elegy\ta lament a melancholy composition\n" +
            "elicit\tdraw out\n" +
            "eloquence\tfluent speaking skillful use of language\n" +
            "emaciate\tmake thin and weak\n" +
            "embellish\tmake beautiful\n" +
            "embezzle\tuse in a wrong way for one's own benefit\n" +
            "emote\tstir up excite\n" +
            "empirical\trelying on experiment\n" +
            "encapsulate\tenclose in capsule\n" +
            "encomium\twarm or glowing praise eulogy panegyric\n" +
            "encumbrance\tburden things that get on the way of\n" +
            "endearing\tmaking dear or liked\n" +
            "endemic\tepidemic\n" +
            "endorse\twrite one's name on the back of\n" +
            "enduring\tlasting\n" +
            "enervate\tweaken deprive of strength attenuate\n" +
            "engender\tcause produce give rise to\n" +
            "engrave\timpress deeply\n" +
            "engrossing\ttaken up all the time or attention writing in large or formal\n" +
            "engulf\tswallow up\n" +
            "enigma\tsmth that is puzzling\n" +
            "enmity\thatred being an enemy\n" +
            "ensign\tflag/badge\n" +
            "entangle\tput into difficulties\n" +
            "enthral\tplease greatly/enslave (fig)\n" +
            "entice\ttempt or persuade\n" +
            "entreat\task earnestly\n" +
            "enunciate\tpronounce (words)/express a theory\n" +
            "enzyme\tcatalyst\n" +
            "epicurean\tdevoted to pleasure (sensuous enjoyment)\n" +
            "epistle\tletter\n" +
            "epithet\tadjective\n" +
            "epitome\tbrief summary representative example a typical model\n" +
            "equable\tsteady regular\n" +
            "equanimity\tcalmness of temperament\n" +
            "equilibrium\tstate of being balanced\n" +
            "equipoise\tequal distribution of weight equilibrium\n" +
            "equivocal\thaving a double or doubtful meaning suspicious\n" +
            "equivocate\ttry to deceive by equivocal language\n" +
            "eradicate\tget rid of pull up by the roots\n" +
            "erratic\tirregular in behaviour or opinion\n" +
            "erudite\tlearned scholarly\n" +
            "eschew\tavoid\n" +
            "esoteric\tabstruse intended only for a small circle of\n" +
            "espouse\tmarry give one's support to\n" +
            "eulogy\tformal praise panegyric\n" +
            "euphoria\telation state of pleasant excitement\n" +
            "euthanasia\teasy and painless death\n" +
            "evasive\ttending to evade\n" +
            "evince\tto show clearly to indicate\n" +
            "evoke\tcall up bring out\n" +
            "excoriation\tsevere criticism\n" +
            "exculpate\tto clear from a charge of guilt\n" +
            "exhaustive\tcomplete thorough\n" +
            "exigency\temergency an urgent situation\n" +
            "exoneration\tset smb clear free (e.g.. from blame)\n" +
            "exorbitant\tmuch too high or great\n" +
            "expatiate\tto roam wander freely\n" +
            "expedient\tlikely to be useful for a purpose\n" +
            "expiation\tending expiring\n" +
            "exploit\tbrilliant achievement develop use selfishly\n" +
            "expostulate\targue earnestly to dissuade correct or protest\n" +
            "expurgate\tto remove obscenity purify censor\n" +
            "exscind\tto cut out cut away\n" +
            "extant\tstill in existence\n" +
            "extempore\twithout previous thought or preparation\n" +
            "extenuate\treduce the strength of lessen seriousness partially excuse\n" +
            "extinct\tno longer active\n" +
            "extinguish\tend the existence of/wipe or put out\n" +
            "extirpate\tto destroy exterminate cut out exscind\n" +
            "extol\tpraise highly\n" +
            "extort\tobtain by threats violence\n" +
            "extralegal\toutside the law\n" +
            "extricable\tthat can be freed\n" +
            "extrovert\tcheerful person\n" +
            "exuberance\tstate of growing vigorously being full of life\n" +
            "facetious\thumorous funny jocular\n" +
            "facile\teasily done\n" +
            "fallacious\tbased on error\n" +
            "falter\twaver/move in an uncertain manner\n" +
            "fatuous\twithout sense foolish self-satisfaction\n" +
            "fawn\tyoung deer try to win smb's favor\n" +
            "feckless\tlacking purpose or vitality ineffective careless\n" +
            "fecund\tfertile\n" +
            "feint\tpretend\n" +
            "felicitous\tapt suitably expressed well chosen apropos\n" +
            "felon\tperson guilty of murder\n" +
            "ferment\tsubstance become excited\n" +
            "ferocity\tsavage cruelty\n" +
            "ferret\tdiscover by searching search\n" +
            "fervid\tshowing earnest feeling\n" +
            "fervor\twarmth of feelings earnestness\n" +
            "fetid\tstinking\n" +
            "fetter\tto shackle put in chains\n" +
            "feud\tbitter quarrel over a long period of time\n" +
            "fidelity\tloyalty accuracy\n" +
            "fidget\tmove restlessly make nervous\n" +
            "figurehead\tcarved image on the prow of a ship\n" +
            "finesse\tdelicate way of dealing with a situation\n" +
            "finical\ttoo fussy about food clothing etc.\n" +
            "finicky\tfinical\n" +
            "fission\tsplitting or division (esp. of cells)\n" +
            "fixate\tstare at\n" +
            "flak\tcriticism/anti-aircraft guns\n" +
            "flamboyant\tbrightly colored florid\n" +
            "flaunting\tshow off complacently\n" +
            "flax\tpale yellow (hair) a plant\n" +
            "fledged\table to fly trained experienced\n" +
            "fleet\tnumber of ships quick-moving\n" +
            "flinch\tdraw move back wince\n" +
            "flop\tfail/move/fall clumsily\n" +
            "florid\tvery much ornamented naturally red (e.g.. of face)\n" +
            "flout\treject mock to go against (as in going against tradition)\n" +
            "fluke\tlucky stroke\n" +
            "fluster\tmake nervous or confused\n" +
            "foible\tdefect of character (a person is wrongly proud)\n" +
            "foil\tprevent from carrying out contrast\n" +
            "foment\tput smth warm (to lessen the pain)\n" +
            "foolproof\tincapable of failure or error\n" +
            "foppish\tlike a man who pays too much attention to his clothes\n" +
            "forage\tfood for horses and cattle\n" +
            "forbear\trefrain from be patient ancestor\n" +
            "forbearance\tpatience willingness to wait\n" +
            "ford\tshallow place in a river (to cross)\n" +
            "forestall\tprevent by taking action in advance preempt\n" +
            "forfeit\tsuffer the loss of smth\n" +
            "forge\tworkshop for the shaping of metal to shape metal lead\n" +
            "forgery\tcounterfeit\n" +
            "forswear\trenounce disallow repudiate\n" +
            "foster\tnurture care for\n" +
            "fracas\tnoisy quarrel\n" +
            "fragile\teasily injured broken or destroyed\n" +
            "fragrant\tsweet-smelling\n" +
            "frantic\twildly excited with joy pain anxiety\n" +
            "frenetic\tfrantic frenzied\n" +
            "fret\tworry irritation wear away\n" +
            "fringe\tedge ornamental border part of hair over the forehead\n" +
            "froward\tintractable not willing to yield or comply stubborn\n" +
            "frugal\tcareful economical\n" +
            "fulmination\tbitter protest\n" +
            "fulsome\tdisgusting offensive due to excessiveness\n" +
            "gainsay\tto deny to oppose\n" +
            "garble\tmake unfair selection from facts\n" +
            "garment\tarticle of clothing\n" +
            "garner\tto gather and save to store up\n" +
            "garrulity\ttalkativeness\n" +
            "garrulous\ttoo talkative\n" +
            "gaucherie\tsocially awkward tactless behavior\n" +
            "germane\trelevant pertinent to\n" +
            "gist\tthe point general sense\n" +
            "glean\tgather facts in small quantities\n" +
            "glib\tready and smooth but not sincere\n" +
            "glimmer\tweak/unsteady light\n" +
            "gloat\tover look at with selfish delight\n" +
            "glut\tsupply to much fill to excess\n" +
            "gnaw\twaste away bite steadily\n" +
            "goad\tsmth urging a person to action\n" +
            "gorge\teat greedily/narrow opening with a stream\n" +
            "gossamer\tsoft light delicate material\n" +
            "gouge\ttool for cutting grooves in wood\n" +
            "grandiloquent\tusing pompous words\n" +
            "grave\tserious requiring consideration\n" +
            "graze\ttouch or scrape lightly in passing\n" +
            "gregarious\tliving in societies liking the company\n" +
            "grievous\tcausing grief or pain serious dire grave\n" +
            "grovel\tcrawl humble oneself\n" +
            "guile\tdeceit cunning\n" +
            "gullible\teasily gulled\n" +
            "gush\tburst out suddenly/talk ardently\n" +
            "gust\toutburst of feeling sudden rain wind fire etc.\n" +
            "hack\tcut roughly hired horse\n" +
            "halcyon\tcalm and peaceful\n" +
            "hallow\tto make holy consecrate\n" +
            "harangue\ta long passionate speech\n" +
            "harbinger\tsmth or smb that foretells the coming of\n" +
            "harrow\tto distress create stress or torment\n" +
            "haughty\tarrogant conceited\n" +
            "heed\tattention/give notice to\n" +
            "heinous\todious (of crime)\n" +
            "heresy\tbelief contrary to what is generally accepted\n" +
            "hermetic\tsealed by fusion\n" +
            "heterogeneous\tmade up of different kinds\n" +
            "hew\tmake by hard work cut (by striking)\n" +
            "highbrow\t(person) with superior tastes\n" +
            "hirsute\thairy shaggy\n" +
            "hoax\tmischievous trick played on smb for a joke\n" +
            "hoi\tpolloi the masses the rabble\n" +
            "hollow\tnot soled with hole\n" +
            "holster\tleather case for a pistol\n" +
            "homiletics\tact of preaching\n" +
            "hone\tstone used for sharpening tools\n" +
            "hoodwink\ttrick mislead\n" +
            "hospitable\tliking to give hospitality\n" +
            "hubris\tarrogant pride\n" +
            "hush\tmake or become silent\n" +
            "husk\tworthless outside part of anything\n" +
            "hypocrisy\tfalsely making oneself appear to be good\n" +
            "iconoclast\tperson who attacks popular beliefs\n" +
            "idiosyncrasy\tpersonal mannerism\n" +
            "idolatry\texcessive admiration of\n" +
            "idyll\ta carefree episode or experience\n" +
            "ignoble\tdishonorable common undignified\n" +
            "ignominious\tshameful dishonorable undignified disgraceful\n" +
            "illicit\tunlawful forbidden\n" +
            "imbroglio\tcomplicated and embarrassing situation\n" +
            "immaculate\tpure faultless\n" +
            "imminent\tlikely to come or happen soon\n" +
            "immutable\tthat cannot be changed\n" +
            "impair\tworsen diminish in value\n" +
            "impassive\tunmoved feeling no sign of passion\n" +
            "impecunious\thaving little or no money\n" +
            "impede\thinder get in the way of\n" +
            "impediment\tsmth that hinders (e.g. stammer)\n" +
            "impending\timminent being about to happen expected\n" +
            "imperative\turgent essential\n" +
            "imperious\tcommanding haughty arrogant\n" +
            "impermeable\tthat cannot be permeated\n" +
            "imperturbable\tcalm not capable of being excited\n" +
            "impervious\tnot allowing to pass through (of materials)\n" +
            "imperviousness\thaughty arrogant commanding\n" +
            "impetuous\thaving sudden energy impulsive thrusting ahead forceful\n" +
            "impiety\tlack of reverence or dutifulness\n" +
            "implacable\tincapable of being placated unpleasable\n" +
            "implicate\tshow that smb has a share\n" +
            "implicit\timplied though not plainly expressed\n" +
            "implosion\tcollapse bursting inward\n" +
            "importune\tbeg urgently solicit (of a prostitute)\n" +
            "imprecation\tan invocation of evil a curse\n" +
            "impromptu\twithout preparation\n" +
            "impudent\trash indiscreet\n" +
            "impugned\tchallenged to be doubted\n" +
            "impute\tto attribute to a cause or source ascribe\n" +
            "inadvertent\tnot paying proper attention\n" +
            "inane\tsilly senseless\n" +
            "inasmuch\tsince because\n" +
            "incense\tmake angry\n" +
            "incessant\toften repeated continual\n" +
            "inchoate\tnot yet fully formed rudimentary elementary\n" +
            "incipient\tbeginning\n" +
            "incise\tengrave make a cut in\n" +
            "incite\tstir up rouse\n" +
            "inclined\tdirecting the mind in a certain direction\n" +
            "incongruous\tout of place not in harmony or agreement\n" +
            "incorrigibility\tcannot be cured or corrected\n" +
            "incredulous\tskeptical unwilling to believe\n" +
            "inculcate\tfix firmly by repetition\n" +
            "incumbents\tofficial duties\n" +
            "incursion\ta raid a sudden attack\n" +
            "indefatigability\tnot easily exhaustible tirelessness\n" +
            "indelible\tthat cannot be rubbed out\n" +
            "indigence\tpoverty\n" +
            "indigenous\tnative\n" +
            "indistinct\tnot easily heard seen clearly marked\n" +
            "indolence\tlaziness\n" +
            "indomitable\tnot easily discouraged or subdued\n" +
            "indulge\tgratify give way to satisfy allow oneself\n" +
            "indulgent\tinclined to indulge\n" +
            "ineffable\tto great to be described in words\n" +
            "ineluctable\tcertain inevitable\n" +
            "inept\tunskillful said or done at the wrong time\n" +
            "ineptitude\tquality of being unskillful\n" +
            "inferno\thell\n" +
            "infuriate\tfill with fury or rage\n" +
            "infuse\tput pour fill\n" +
            "ingenuous\tnaive young artless frank honest sincere\n" +
            "ingest\ttake in by swallowing\n" +
            "inimical\tharmful or friendly\n" +
            "inimitable\tdefying imitation unmatchable\n" +
            "innocuous\tcausing no harm\n" +
            "inscrutable\tincapable of being discovered or understood\n" +
            "insensible\tunconscious unresponsive unaffected\n" +
            "insinuate\tsuggest unpleasantly make a way for smth gently\n" +
            "insipid\twithout taste or flavor\n" +
            "insouciant\tunconcerned carefree\n" +
            "insularity\tnarrow-mindedness isolated\n" +
            "insurrection\trising of people to open resistance to\n" +
            "interdict\tprohibit forbid\n" +
            "interim\tas an installment\n" +
            "intersperse\tplace here and there\n" +
            "intransigence\tunwillingness to compromise stubbornness intractability\n" +
            "intransigent\tuncompromising\n" +
            "intrepid\tfearless brave undaunted\n" +
            "introspection\texamining one's own thoughts and feelings\n" +
            "inundate\tflood cover by overflowing\n" +
            "inured\taccustomed to adapted\n" +
            "invective\tabusive language curses\n" +
            "inveigh\tto attack verbally denounce deprecate\n" +
            "inveterate\tdeep-rooted. long-established\n" +
            "invincible\ttoo strong to be defeated\n" +
            "involute\tcomplex\n" +
            "irascible\tirritable easily angered\n" +
            "irate\tangry\n" +
            "ire\tanger\n" +
            "irksome\ttiresome\n" +
            "irresolute\thesitating undecided\n" +
            "irrevocable\tfinal and unalterable\n" +
            "itinerate\tto travel from place to place to peregrinate\n" +
            "jabber\ttalk excitedly utter rapidly\n" +
            "jibe\tgibe make fun of\n" +
            "jocular\tmeant as a joke\n" +
            "judicious\tsound in judgment wise\n" +
            "knit\tdraw together unite firmly\n" +
            "labyrinthine\tto entangle the state of affairs\n" +
            "lachrymose\tcausing tears tearful\n" +
            "lackluster\t(of eyes) dull\n" +
            "lament\tshow feel great sorrow\n" +
            "lassitude\tweariness tiredness\n" +
            "latent\tpresent but not yet active developed or visible\n" +
            "laudatory\texpressing or giving praise\n" +
            "lavish\tgiving or producing freely liberally or generously\n" +
            "legacy\tsmth handed down from ancestors\n" +
            "levee\tformal reception/embankment\n" +
            "levity\tlack of seriousness\n" +
            "libel\tstatement that damages reputation\n" +
            "liberality\tfree giving generosity\n" +
            "libertine\timmoral person\n" +
            "lien\tlegal claim until a debt on it is repaid\n" +
            "limn\tpaint portray\n" +
            "limp\tlacking strength walking unevenly\n" +
            "lionize\ttreat as a famous person\n" +
            "lithe\tbending twisting\n" +
            "loll\trest to sit or stand in a lazy way hang (dog's tongue)\n" +
            "lope\tmove along with long strides\n" +
            "loquacious\ttalkative garrulous\n" +
            "lucubrate\twrite in scholarly fashion\n" +
            "luculent\teasily understood lucid clear\n" +
            "lugubrious\tmournful excessively sad\n" +
            "lull\tbecome quiet or less active\n" +
            "lumber\tmove in a clumsy/noisy way\n" +
            "luminary\tstar light-giving body\n" +
            "lurk\tbe out of view ready to attack\n" +
            "lustrous\tbeing bright polished\n" +
            "macabre\tgruesome suggesting death\n" +
            "macerate\tmake or become soft by soaking in water\n" +
            "machination\tplot scheme (esp. evil)\n" +
            "maladroit\ttactless clumsy\n" +
            "malapropism\tmisuse of a word (for one that resembles it)\n" +
            "malevolence\twishing to do evil\n" +
            "malign\tinjurious speak ill of smb tell lie\n" +
            "malinger\tto fake illness or injury in order to shirk a duty\n" +
            "malleable\tyielding easily shaped moldable adapting\n" +
            "manacle\tchains for the hands or feet\n" +
            "massacre\tcruel killing of a large number of people\n" +
            "matriculation\tbe admitted enter a university as a student\n" +
            "maudlin\tsentimental in a silly or tearful way\n" +
            "maul\thurt by rough handling\n" +
            "maverick\trebel nonconformist\n" +
            "mellifluous\tsweetly flowing\n" +
            "mendacity\tdishonesty\n" +
            "mendicant\ta beggar\n" +
            "mercurial\tquick changeable in character fleeting\n" +
            "meretricious\tattractive on the surface but of little value\n" +
            "mesmerize\thypnotize\n" +
            "meticulous\tgiving great attention to details\n" +
            "mettle\tquality of endurance or courage\n" +
            "mettlesome\tcourageous high-spirited\n" +
            "middling\tfairly good but not very good\n" +
            "minatory\tmenacing threatening\n" +
            "mince\tpronounce or speak affectedly euphemize\n" +
            "misanthrope\tperson who hates mankind\n" +
            "mischievous\tharmful causing mischief\n" +
            "miser\tperson who loves wealth and spends little\n" +
            "misogynist\tone who hates women/females\n" +
            "moderation\tquality of being limited not extreme\n" +
            "mollify\tmake calmer or quieter\n" +
            "molt\tmoult lose hair feathers before new growing\n" +
            "morbid\tdiseased unhealthy (e.g.. about ideas)\n" +
            "morose\till-tempered unsocial\n" +
            "muffler\tcloth worn round the neck/silencer\n" +
            "multifarious\tvaried motley greatly diversified\n" +
            "mundane\tworldly as opposed to spiritual commonplace everyday\n" +
            "myriad\tvery great number\n" +
            "nadir\tlowest weakest point\n" +
            "nascent\tcoming into existence emerging\n" +
            "nebulous\tcloud-like hazy vague indistinct\n" +
            "negligent\ttaking too little care\n" +
            "neophyte\tperson who has been converted to a belief\n" +
            "nexus\ta connection tie or link\n" +
            "nibble\tshow some inclination to accept (an offer)\n" +
            "noisome\toffensive disgusting (smell)\n" +
            "nonchalant\tnot having interest\n" +
            "nonplused\tgreatly surprised\n" +
            "nostrum\ta quack remedy an untested cure\n" +
            "noxious\tharmful\n" +
            "nugatory\ttrifling/worthless\n" +
            "obdurate\thardened and unrepenting stubborn inflexible\n" +
            "obfuscate\tto darken make obscure muddle\n" +
            "oblivious\tunaware having no memory\n" +
            "obloquy\tabusively detractive language sharp criticism vituperation\n" +
            "obsequious\ttoo eager to obey or serve\n" +
            "obstreperous\tnoisy loud\n" +
            "obtain\tto be established accepted or customary\n" +
            "obtrusive\tprojecting prominent undesirably noticeable\n" +
            "obtuse\tblunt/stupid\n" +
            "obviate\tto make unnecessary get rid of\n" +
            "occluded\tblocked up\n" +
            "odious\trepulsive hateful\n" +
            "odium\tcontempt dislike aversion\n" +
            "odor\tsmell favor reputation\n" +
            "officious\ttoo eager or ready to help offer advice\n" +
            "ominous\tthreatening\n" +
            "onerous\tneeding effort burdensome\n" +
            "opaqueness\tdullness/not allowing light to pass through\n" +
            "opprobrious\tshowing scorn or reproach\n" +
            "ossify\tto turn to bone to settle rigidly into an idea\n" +
            "ostensible\tseeming appearing as such professed\n" +
            "ostentation\tdisplay to obtain admiration or envy\n" +
            "ostracism\tshut out from society refuse to meet talk\n" +
            "overhaul\texamine thoroughly to learn about the condition\n" +
            "overweening\tpresumptuously arrogant overbearing immoderate being a jerk\n" +
            "paean\tsong of praise or triumph\n" +
            "palate\troof of the mouth sense of taste\n" +
            "palatial\tmagnificent\n" +
            "palliate\tlessen the severity of\n" +
            "palpability\tcan be felt touched understood\n" +
            "palpitate\ttremble beat rapidly and irregularly\n" +
            "panegyric\tformal praise eulogy\n" +
            "paradigm\ta model example or pattern\n" +
            "parenthesis\tsentence within another one smth separated\n" +
            "pariah\tan outcast a rejected and despised person\n" +
            "parsimonious\ttoo economical miserly\n" +
            "partisan\tone-sided committed to a party biased or prejudiced\n" +
            "patron\tregular customer person who gives support\n" +
            "paucity\tscarcity a lacking of\n" +
            "peccadillo\tsmall sin small weakness in one's character\n" +
            "pedantic\tbookish showing off learning\n" +
            "pedestrian\tcommonplace trite unremarkable\n" +
            "pellucid\ttransparent easy to understand\n" +
            "penchant\tstrong inclination a liking\n" +
            "penitent\tfeeling or showing regret\n" +
            "penurious\tpoor/stingy\n" +
            "penury\textreme poverty\n" +
            "peregrination\ttraveling about wandering\n" +
            "peremptory\turgent imperative unchallengeable ending debate\n" +
            "perfidious\ttreacherous faithless\n" +
            "perfidy\ttreachery breaking of faith\n" +
            "perfunctory\tdone as a duty without care\n" +
            "perilous\tdangerous\n" +
            "peripatetic\twandering\n" +
            "perish\tbe destroyed decay\n" +
            "perjury\twillful FALSE statement unlawful act\n" +
            "permeate\tspread into every part of\n" +
            "pernicious\tharmful injurious\n" +
            "perpetrate\tbe guilty commit (a crime)\n" +
            "personable\tpleasing in appearance attractive\n" +
            "perspicacity\tquick judging and understanding\n" +
            "pertain\tbelong as a part have reference\n" +
            "pest\tdestructive thing or a person who is nuisance\n" +
            "petrified\ttaken away power (to think feel act)\n" +
            "petrify\tto make hard rocklike\n" +
            "petrous\tlike a rock hard stony\n" +
            "petulant\tunreasonably impatient\n" +
            "philistine\ta smug ignorant person one who lacks knowledge\n" +
            "phlegmatic\tcalm sluggish temperament unemotional\n" +
            "picaresque\tinvolving clever rogues or adventurers\n" +
            "pied\tof mixed colors\n" +
            "pinch\tbe too tight take between the thumb and finger\n" +
            "pine\twaste away through sorrow or illness\n" +
            "pious\tdutiful to parents devoted to religion\n" +
            "piquant\tagreeably pungent stimulating\n" +
            "pique\thurt the pride or self-respect stir (curiosity)\n" +
            "pitfall\tcovered hole as a trap unsuspected danger\n" +
            "pith\tessential part force soft liquid substance\n" +
            "pivotal\tof great importance (others depend on it)\n" +
            "placate\tsoothe pacify calm\n" +
            "plaintive\tmournful melancholy sorrowful\n" +
            "plaque\tflat metal on a wall as a memorial\n" +
            "platitude\ta trite or banal statement unoriginality\n" +
            "plea\trequest\n" +
            "plead\taddress a court of law as an advocate\n" +
            "plethora\tglut\n" +
            "pliant\tpliable easily bent shaped or twisted\n" +
            "plod\tcontinue doing smth without resting\n" +
            "pluck\tpull the feathers off pick (e.g.. flowers)\n" +
            "plumb\tget to the root of\n" +
            "plummet\tfall plunge steeply\n" +
            "plunge\tmove quickly suddenly and with force\n" +
            "poignant\tdeeply moving keen\n" +
            "poncho\tlarge piece of cloth\n" +
            "ponderous\theavy bulky dull\n" +
            "portent\tomen marvelous threatening\n" +
            "precarious\tuncertain risky dangerous\n" +
            "precepts\trules establishing standards of conduct\n" +
            "preclude\tprevent make impossible\n" +
            "precursory\tpreliminary anticipating\n" +
            "predilection\tspecial liking mental preference\n" +
            "predominate\thave more power than others\n" +
            "preen\ttidy/show self-satisfaction\n" +
            "premature\tdoing or happening smth before the right time\n" +
            "preponderance\tgreatness in number strength weight\n" +
            "presage\twarning sign\n" +
            "presumption\tarrogance\n" +
            "preternatural\tnot normal or usual\n" +
            "prevalent\tcommon\n" +
            "prevaricate\tto equivocate to stray from the truth\n" +
            "prim\tneat formal\n" +
            "pristine\tprimitive unspoiled pure as in earlier times unadulterated\n" +
            "probity\tuprightness incorruptibility principle\n" +
            "proclivity\tinclination\n" +
            "procrastination\tkeeping on putting off\n" +
            "prodigal\twasteful reckless with money\n" +
            "prodigious\tenormous wonderful\n" +
            "profane\tworldly having contempt for God\n" +
            "profligacy\tshameless immorality\n" +
            "profligate\twasteful prodigal licentious extravagant\n" +
            "profundity\tdepth\n" +
            "profuse\tabundant/lavish\n" +
            "proliferate\tgrow reproduce by rapid multification\n" +
            "prolix\ttiring because too long\n" +
            "prone\tprostrate inclined to (undesirable things)\n" +
            "propagation\tincreasing the number spreading extending\n" +
            "propinquity\tnearness in time or place affinity of nature\n" +
            "propitiatory\tconciliatory appeasing mitigating\n" +
            "propitious\tauspicious presenting favorable circumstances\n" +
            "prosaic\teveryday mundane commonplace trite pedestrian\n" +
            "proscribe\tdenounce as dangerous\n" +
            "protracted\tprolonged\n" +
            "provident\tfrugal looking to the future\n" +
            "provisional\tof the present time only\n" +
            "provoke\tmake angry vax\n" +
            "prudence\tcareful forethought\n" +
            "prudish\teasily shocked excessively modest\n" +
            "prune\tdried plum silly person\n" +
            "pry\tget smth inquire too curiously\n" +
            "pucker\twrinkle\n" +
            "pugnacious\tfond of in the habit of fighting\n" +
            "puissance\tstrength\n" +
            "punctilious\tprecise paying attention to trivialities\n" +
            "pundit\tpedant authority on a subject\n" +
            "pungency\tsharpness stinging quality\n" +
            "purvey\tprovide supply\n" +
            "pusillanimous\tcowardly craven\n" +
            "putrefaction\tbecoming rotten\n" +
            "pyre\tlarge pile of wood for burning\n" +
            "quack\tperson dishonestly claiming to smth\n" +
            "quaff\tdrink deeply\n" +
            "quail\tlose courage turn frightened\n" +
            "qualm\tfeeling of doubt temporary feeling of sickness\n" +
            "quandary\tstate of doubt or perplexity\n" +
            "quell\tsuppress subdue\n" +
            "quibble\ttry to avoid by sophistication\n" +
            "quiescence\tstate of being passive/motionless\n" +
            "quiescent\tat rest dormant torpid\n" +
            "quirk\thabit or action peculiar to smb or smth\n" +
            "quixotic\tgenerous unselfish\n" +
            "quotidian\tbanal everyday\n" +
            "rabble\tmob crowd the lower classes of populace\n" +
            "raconteur\tperson who tells anecdotes\n" +
            "raffish\tlow vulgar base tawdry\n" +
            "ramify\tto be divided or subdivided to branch out\n" +
            "rancorous\tfeeling bitterness spitefulness\n" +
            "rant\tuse extravagant language\n" +
            "rapacious\tgreedy (esp for money)\n" +
            "rarefy\tto make thin to make less dense to purify or refine\n" +
            "rave\tact with excessive enthusiasm\n" +
            "reactionary\topposing progress\n" +
            "rebuff\tsnub\n" +
            "recalcitrant\tdisobedient\n" +
            "recant\ttake back as being FALSE give up\n" +
            "recast\tcast or fashion anew\n" +
            "recidivism\trelapse into antisocial or criminal behavior\n" +
            "reciprocity\tgranting of privileges in return for similar\n" +
            "recitals\ta number of performance of music\n" +
            "recluse\tperson who lives alone and avoids people\n" +
            "recompense\tmake payment to reward punish\n" +
            "reconcile\tsettle a quarrel restore peace\n" +
            "recondite\tlittle known abstruse\n" +
            "recreancy\tcowardice a cowardly giving up\n" +
            "recuperate\tbecome strong after illness loss exhaustion\n" +
            "redeem\tget back by payment compensate\n" +
            "redoubtable\tformidable causing fear\n" +
            "refine\tmake or become pure cultural\n" +
            "refractory\tstubborn unmanageable untractable\n" +
            "refulgent\tshining brilliant\n" +
            "regale\tto delight or entertain to feast\n" +
            "regicide\tcrime of killing a king\n" +
            "reiterate\tsay or do again several times\n" +
            "rejuvenation\tbecoming young in nature or appearance\n" +
            "relapse\tfall back again\n" +
            "remonstrate\tto protest object\n" +
            "render\tdeliver provide represent\n" +
            "renovate\trestore smth to better condition\n" +
            "renowned\tcelebrated famous\n" +
            "repast\tmeal\n" +
            "repel\trefuse to accept/cause dislike\n" +
            "repine\tat be discontented with\n" +
            "reproach\tscold upbraid\n" +
            "reprobate\tperson hardened in sin one devoid of decency\n" +
            "repudiate\tdisown refuse to accept or pay\n" +
            "repulsive\tcausing a feeling of disgust\n" +
            "requite\trepay give in return\n" +
            "rescind\trepeal/annul/cancel\n" +
            "resigned\tunresisting submissive\n" +
            "resilience\tquality of quickly recovering the original shape\n" +
            "resort\tto frequently visit\n" +
            "restive\trefusing to move reluctant to be controlled\n" +
            "resuscitation\tcoming back to consciousness\n" +
            "retard\tcheck hinder\n" +
            "reticent\treserved untalkative silent taciturn\n" +
            "revere\thave deep respect for\n" +
            "reverent\tfeeling or showing deep respect\n" +
            "riddle\tpuzzling person or thing\n" +
            "rift\tsplit crack dissension\n" +
            "rivet\tfix take up secure metal pin\n" +
            "roll\tcall calling of names\n" +
            "rotund\trich and deep plump and round\n" +
            "ruffian\tviolent cruel man\n" +
            "rumple\tmake rough\n" +
            "sagacious\thaving sound judgment perceptive wise like a sage\n" +
            "salacious\tobscene\n" +
            "salubrious\thealthful\n" +
            "salutary\tremedial wholesome causing improvement\n" +
            "sanctimony\tself-righteousness hypocritical with FALSE piety\n" +
            "sanction\tapproval (by authority) penalty\n" +
            "sanguine\tcheerful confident optimistic\n" +
            "sanity\thealth of mind soundness of judgement\n" +
            "sash\tlong strip worn round the waist\n" +
            "satiate\tsatisfy fully\n" +
            "saturnine\tgloomy dark sullen morose\n" +
            "savant\tperson of great learning\n" +
            "savor\ttaste flavor smth\n" +
            "sawdust\ttiny bits of wood\n" +
            "scabbard\tsheath for the blade\n" +
            "scent\tsmell (esp pleasant)\n" +
            "scorch\tbecome discolored/dry up/go at high speed\n" +
            "scribble\twrite hastily\n" +
            "scurvy\tmean contemptible\n" +
            "secular\tmaterial (not spiritual) living outside monasteries\n" +
            "sedulous\tpersevering\n" +
            "seminal\tlike a seed constituting a source originative\n" +
            "sententious\tshort and pithy full of maxims/proverbs\n" +
            "sequence\tsuccession connected line of\n" +
            "sere\tmake hard and without feeling\n" +
            "sermon\treproving a person for his faults\n" +
            "serrated\thaving a toothed edge\n" +
            "serration\thaving a toothed edge\n" +
            "servile\tlike a slave lacking independence\n" +
            "sever\tbreak off\n" +
            "severance\tsevering\n" +
            "shallow\tlittle depth not earnest\n" +
            "shard\tpiece of broken earthenware\n" +
            "sheath\tcover for the blade of a weapon or a tool\n" +
            "shrewd\tastute showing sound judgement\n" +
            "shrill\tsharp piercing\n" +
            "shun\tkeep away from avoid\n" +
            "shunt\tsend from one track to another lay aside evade discussion\n" +
            "sidestep\tstep to one side\n" +
            "simper\t(give a) silly/self-conscious smile\n" +
            "sinuous\twinding undulating serpentine\n" +
            "skiff\tsmall boat\n" +
            "skit\tshort piece of humorous writing\n" +
            "slack\tsluggish dull not tight\n" +
            "slake\tto assuage to satisfy allay\n" +
            "slate\tking of blue-grey stone propose criticize\n" +
            "sluggard\tlazy slow-moving person\n" +
            "slur\tjoin sounds/words (indistinct)\n" +
            "smolder\tburn slowly without flame\n" +
            "snare\ttrap\n" +
            "snub\ttreat with contempt\n" +
            "soar\trise fly high\n" +
            "sober\tself-controlled\n" +
            "sobriety\tquality or condition of being sober\n" +
            "sodden\tsoaked saturated\n" +
            "soggy\theavy with water\n" +
            "solvent\tof the power of forming a solution\n" +
            "somatic\tof the body\n" +
            "soot\tblack powder in smoke\n" +
            "sophisticated\tcomplex subtle refined\n" +
            "sophistry\tfallacious reasoning faulty logic\n" +
            "sophomoric\tself-assured though immature affected bombastic overblown\n" +
            "soporific\tproducing sleep\n" +
            "sordid\twretched comfortless contemptible\n" +
            "spear\tweapon with a metal point on a long shaft\n" +
            "specious\tillogical of questionable truth or merit\n" +
            "splenetic\tbad-tempered irritable\n" +
            "splice\tjoin (two ends)\n" +
            "sponge\tporous rubber for washing live at once expense\n" +
            "spurious\tFALSE counterfeit\n" +
            "spurn\thave nothing to do reject or refuse\n" +
            "squalid\tfoul filthy\n" +
            "squander\tspend wastefully\n" +
            "squat\tcrouch/settle without permission\n" +
            "stanch\tto stop the flow of a fluid\n" +
            "steeply\trising or falling sharply\n" +
            "stentorian\textremely loud and powerful\n" +
            "stickler\tperson who insists on importance of smth\n" +
            "stigma\tmark of shame or disgrace\n" +
            "stigmatize\tdescribe smb scornfully\n" +
            "sting\tsmth sharp\n" +
            "stingy\tspending using unwillingly\n" +
            "stint\tto be thrifty to set limits\n" +
            "stipple\tpaint with dots\n" +
            "stipulate\tstate or put forward as a necessary condition\n" +
            "stolid\tshowing no emotion impassive\n" +
            "stray\twander lose one's way\n" +
            "streak\tlong thin move very fast\n" +
            "striated\tstriped grooved or banded\n" +
            "stride\twalk with long steps\n" +
            "strut\ta supporting bar\n" +
            "stygian\thence dark gloomy\n" +
            "stymie\tto hinder obstruct or block\n" +
            "subdue\tovercome bring under control\n" +
            "sublime\textreme astounding\n" +
            "submerge\tput under water liquid sink out of sight\n" +
            "suborn\tinduce by bribery or smth to commit perjury\n" +
            "subpoena\twritten order requiring a person to appear in a low court\n" +
            "substantiation\tgiving facts to support (statement)\n" +
            "subsume\tinclude under a rule\n" +
            "succor\tassistance relief in time of distress\n" +
            "suffice\tbe enough\n" +
            "suffocate\tcause or have difficulty in breathing\n" +
            "sullied\tto be stained or discredited\n" +
            "summarily\tbriefly without delay\n" +
            "sumptuous\tmagnificent\n" +
            "sundry\tvarious miscellaneous separate\n" +
            "supercilious\tdisdainful characterized by haughty scorn\n" +
            "superfluous\tmore then is needed or wanted\n" +
            "superimpose\tput smth on the top\n" +
            "supersede\ttake the place of\n" +
            "supine\tlying on the back slow to act passive\n" +
            "suppliant\tasking humbly beseeching\n" +
            "supplicate\tmake a humble petition to\n" +
            "suppress\tprevent from being known put an end to\n" +
            "surcharge\tadditional load/charge\n" +
            "surfeit\tsatiate feed to fulness or to excess\n" +
            "susceptibility\tsensitiveness\n" +
            "swerve\tchange direction suddenly\n" +
            "sycophant\tperson who flatter to the rich and powerful\n" +
            "synopsis\tsummary or outline\n" +
            "taciturn\tuntalkative silent\n" +
            "tadpole\tform of a frog when it leaves the egg\n" +
            "talon\tclaw of a bird of prey\n" +
            "tamp\ttap or drive down by repeated light blows\n" +
            "tamper\tinterfere with\n" +
            "tangential\tsuddenly changeable\n" +
            "tarnished\tlost brightness\n" +
            "tassel\tbunch of threads\n" +
            "taunt\tcontemptuous reproach hurtful remark\n" +
            "taut\ttightly stretched\n" +
            "tautology\ta repetition a redundancy\n" +
            "tawdry\tcheap gaudy showy tacky\n" +
            "teetotal\toppose to alcohol\n" +
            "temerity\tboldness brashness intrepidness\n" +
            "temperance\tabstinence from alcohol self-control moderation\n" +
            "temperate\tshowing self-control\n" +
            "tenacity\tfirmness persistency adhesiveness tending to hang on\n" +
            "tenuous\tinsubstantial flimsy weak\n" +
            "tepid\tlukewarm\n" +
            "terse\tbrief and to the point\n" +
            "testiness\twitness/evidence\n" +
            "thrift\tcare economy thriving prosperous\n" +
            "thwart\tobstruct/frustrate\n" +
            "timid\tshy easily frightened\n" +
            "timorous\tfearful timid afraid\n" +
            "toady\tobsequious flatterer\n" +
            "tonic\tsmth giving strength or energy\n" +
            "topple\tbe unsteady and overturn\n" +
            "torment\tsevere pain or suffering\n" +
            "torpid\tsleeping sluggish lethargic dormant\n" +
            "torque\ttwisting force causing rotation\n" +
            "tortuous\tdevious/not straightforward\n" +
            "tout\tperson who worries others to buy smth to use his service\n" +
            "tractable\teasily controlled or guided\n" +
            "transgress\tbreak go beyond (a limit)\n" +
            "transient\ttemporary fleeting\n" +
            "transitory\tbrief\n" +
            "travesty\tparody/imitation\n" +
            "trenchant\tforceful effective vigorous extremely perceptive incisive\n" +
            "trepidation\talarm excited state of mind\n" +
            "trickle\tflow in drops\n" +
            "trifling\tunimportant\n" +
            "trite\tnot new\n" +
            "truce\t(agreement) stop of fighting for a time\n" +
            "truculence\taggressiveness ferocity\n" +
            "trudge\twalk heavily\n" +
            "turbid\tmuddy having the sediment stirred up\n" +
            "turbulence\tbeing uncontrolled violent\n" +
            "turgid\texcessively ornate swollen or bloated\n" +
            "turmoil\ttrouble disturbance\n" +
            "turpitude\twickedness shamefulness\n" +
            "turquoise\tgreenish-blue precious stone\n" +
            "tyro\ttiro beginner\n" +
            "ubiquitous\tpresent everywhere\n" +
            "ulterior\tsituated beyond\n" +
            "umbrage\toffense resentment\n" +
            "uncouth\trough awkward\n" +
            "underbid\tmake a lower bid then smb else\n" +
            "undermine\tweaken gradually at the base make smth under\n" +
            "undulate\tto move in wavelike fashion fluctuate\n" +
            "unearth\tdiscover and bring to light\n" +
            "unencumbered\teasy-going trifle\n" +
            "unfeigned\tnot pretended sincere\n" +
            "unscathed\tunharmed unhurt\n" +
            "untoward\tunfortunate inconvenient\n" +
            "upbraid\tscold reproach\n" +
            "urbane\telegant refined in manners\n" +
            "vacillation\tbeing uncertain hesitating\n" +
            "vagary\tstrange act or idea\n" +
            "vain\twithout use result conceited\n" +
            "valiant\tbrave\n" +
            "valorous\tbrave\n" +
            "vanquish\tconquer\n" +
            "veer\tchange direction\n" +
            "venal\tready to do smth dishonest\n" +
            "veneer\tsurface appearance covering the TRUE nature\n" +
            "veneration\tregard with deep respect\n" +
            "veracity\ttruth\n" +
            "verdant\tfresh and green\n" +
            "verisimilitude\tappearing TRUE or real\n" +
            "veritable\treal rightly named\n" +
            "verve\tspirit vigor enthusiasm\n" +
            "vestige\ttrace or sign\n" +
            "vex\tannoy distress trouble\n" +
            "vigilance\twatchfulness self-appointed group who maintain order\n" +
            "vigilant\tmember of a vigilance committee\n" +
            "vigorous\tstrong energetic\n" +
            "vilify\tslander say evil things\n" +
            "vindictive\thaving a desire to revenge\n" +
            "virago\ta loud domineering woman a scold or nag\n" +
            "visceral\tof the internal organs of the body\n" +
            "viscous\tsticky/semi-fluid\n" +
            "vitiate\tlower the quality weaken the strength\n" +
            "vituperate\tcurse abuse in words\n" +
            "vivacious\tlively high-spirited\n" +
            "volatile\tchangeable inconstant fickle unstable explosive\n" +
            "volubility\tfluency verbosity easy use of spoken language\n" +
            "voluble\tfluent\n" +
            "waffle\ttalk vaguely and without much result\n" +
            "waft\tscent waving movement carry lightly through\n" +
            "wag\tmerry person\n" +
            "warmonger\tperson who stirs up war\n" +
            "warrant\tauthority written order guarantee\n" +
            "wean\tto turn away (from a habit)\n" +
            "weigh\tmeasure hoe heavy smth is\n" +
            "welter\tturmoil a bewildering jumble\n" +
            "wend\tto go proceed\n" +
            "whimsical\tfull of odd and fanciful ideas\n" +
            "wince\tshow bodily or mental pain\n" +
            "woo\ttry to win\n" +
            "writ\twritten order\n" +
            "yarn\ttale story fibers for knitting";

    public WordBase () {
        Random random = new Random();

        wordDB = new HashMap<>();
        todayWord = new ArrayList<>();
        wordStat = new ArrayList<>();
        unWord = new ArrayList<>();
        words = new ArrayList<>();

        for(String wordmean : wonmoon.split("\n")){
            String splited[] = wordmean.split("\t");
            wordDB.put(splited[0],splited[1]);
        }

        loadStat();
        for(String str : wordDB.keySet()){
            Log.d("filedebug",str);
        }

        unWord.addAll(wordDB.keySet());
        words.addAll(wordDB.keySet());

        for(WordStat ws : wordStat)
            unWord.remove(ws.word);

        for(int i=0; i<10 && unWord.size()>0; i++){
            if(wordDB.isEmpty()) break;
            System.out.println(unWord.size());
            int tmp = random.nextInt(unWord.size());
            todayWord.add(unWord.get(tmp));
            unWord.remove(tmp);
        }
    }
    public int getWordNum() { return words.size(); }
    public String getWordByIndex(int index) { return words.get(index); }
    public boolean getContains(String key) { return wordDB.containsKey(key);}
    public String getMeaning (String key){
        return wordDB.get(key);
    }
    public String getTodayByIndex (int index){
        return todayWord.get(index);
    }
    public int getTodayWordNum(){
        return todayWord.size();
    }
    public void sortWordStat() {
        Collections.sort(wordStat, new Comparator<WordStat>() {
            @Override
            public int compare(WordStat o1, WordStat o2) {
                return o2.stat.compareTo(o1.stat);
            }
        });
    }
    public void loadStat() {
        try{
            BufferedReader br = new BufferedReader(new FileReader(getFilesDir() + "stat.txt"));
            String line;
            while((line = br.readLine())!=null){
                String splited[] = line.split("\t");
                wordStat.add(new WordStat(splited[0], Integer.parseInt(splited[1])));
            }
            br.close();
        }catch(Exception e){

        }
    }
    public void saveStat() {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(getFilesDir() + "stat.txt",false));

            for(WordStat tmpws : wordStat) {
                bw.write(tmpws.word + "\t" + tmpws.stat + "\n");
            }

            bw.close();
        }catch(Exception e){

        }
    }
}
