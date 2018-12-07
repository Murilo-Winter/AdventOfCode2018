package day2;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Day2Part1 {

	private Collection<String> inputList = Arrays
			.asList("naosmkcwtdbfivxuphzweraljq", "nvssmicltdbfiyxuphzgeraljq", "nvosmkcwwdbfiyxuphzeeraljx",
					"nvosmkcqtdbfiyxupkzgeraljw", "qvosmkcwtdbhiyxuphzgeraljh", "nvocqkcktdbfiyxuphzgeraljq",
					"nvosmhcwtdbfiyxmphzgekaljq", "nvosmkcwtdbfuyxwpszgeraljq", "nvosmocwtcbfiyxupfzgeraljq",
					"nvosmkcwtdbfiyxubczgeraljv", "nvosmkswtdbfiyxuphzgeruejq", "nlosmkcwtqbfiyxuphzgyraljq",
					"nvosmkcwtdbficxuphzgwraljk", "nvosmkkwtdbfiyxxphzgeralcq", "vvosmkcetdbfiyxumhzgeraljq",
					"evosmkcdtdbfiyxuphkgeraljq", "nvosmkvwtdbkiyxuphzgeraejq", "nvoszkcwtdbfimxuphzgeraljb",
					"nvozmkcwtdbfiyxuphzgrrcljq", "nvosvacwtdbfiyxuphzgeralzq", "nvosmkcwgdofiyxuthzgeraljq",
					"nvosmkcwasbfiyxuphzgeradjq", "nvosmkcatobfiyxtphzgeraljq", "nvosmkewtdsfiyxuphzgekaljq",
					"tvormkcwtdbfiyxuphzieraljq", "nvosgkcwtdbfiyxuuhzgeraqjq", "nvosmkcwtdbqiwxuphzgeralvq",
					"nvosmkcwtybfiydcphzgeraljq", "nvosnkcwtdbfiyxuphzulraljq", "nvosmkcwtdbbiyuupnzgeraljq",
					"nvosmwcwtdbfiyxuphzneraojq", "nvohlkcwtdbftyxuphzgeraljq", "nvasmkcwbdbfiyiuphzgeraljq",
					"nvosmkujtdbfiyxuphzgeraljz", "nvosmgcstdbfiyxuphzgeraljd", "nvoswkcwtsbziyxuphzgeraljq",
					"nvosmmcwtdbfiyxupbzzeraljq", "nvosmkcwtdbfifxulhzgeralji", "nvolmkcwtdbmiyxuphzgeraljv",
					"lvnsmkcwtdbfiyxuphzzeraljq", "nvqsmkcwtdbfiyxuphageralfq", "nvosmkcwtdmfiyluphzgeralzq",
					"nvommvcwtdbfiyxupjzgeraljq", "naosmkcwtdbfsyxuphzgsraljq", "avosmkcwtdbfiyxuphzgebafjq",
					"ndozmkcwtdbfiyxuhhzgeraljq", "nvosmkcwtubfiyxuphooeraljq", "nvosmkcwtdbliyxuphzgmraljx",
					"nvosmkcuddbfimxuphzgeraljq", "wvosmkzwrdbfiyxuphzgeraljq", "nvosmkcqtdbfiyxupjzgeraijq",
					"nvosbkcwtdbfiyduphzgeruljq", "yzosmkcntdbfiyxuphzgeraljq", "nvolmkcwtdbfiyxuphugeralfq",
					"nvrsmkcwtdbjiyxuphzgejaljq", "nvgsmkcwtdbfiyxuphoglraljq", "nvosmkcwtdbfioxuphzgezalhq",
					"nvosjkcwtdbfipxuphzgekaljq", "nvosmkcwtabfiyxlpazgeraljq", "nvosmkfwtpnfiyxuphzgeraljq",
					"nvokmbcwtdbeiyxuphzgeraljq", "nvosmkcwtdbfiyxupmzgmlaljq", "nvosmkcwtdhfiykurhzgeraljq",
					"nvosmkcwwdbfiyxumhzgiraljq", "cvosmscwtdbfikxuphzgeraljq", "nvosmkcwtdnzirxuphzgeraljq",
					"nvosmscwtdbfiyxuuhbgeraljq", "nvosmkcwtdbfidxpphzgeraajq", "nvosmkcwtdbfiyxuqhzgurcljq",
					"nvosmkcwtekfiyxrphzgeraljq", "ntosmkcwtpqfiyxuphzgeraljq", "nvosmkcdtdbfhyxsphzgrraljq",
					"nvolmkkwtdbfiyxuphzgeralgq", "nvosmrcwtdbfiyxuphzgefkljq", "nvoxmkcwtdbfiysuphzeeraljq",
					"nvjsmkswtdbfiyxuphzqeraljq", "nvosmkcetdbfiyfuphdgeraljq", "nvosmkkwtpbfsyxuphzgeraljq",
					"nvosdgcwtdbfiyxupyzgeraljq", "nvosmkcwudbfiyzvphzgeraljq", "nvosmkcwtlbfiyxupkzgerzljq",
					"nvosmkcwtdbfiywuphyzeraljq", "nvocmkcwtdufiyxukhzgeraljq", "nvosmkcwtdqfiyxuphzgevaxjq",
					"nvosvkcwtdbgiyxuphzgeralzq", "nqosmkcwtdbfiyxuphzeeraljr", "nvosmkcetdbfiyxuphzgeroljo",
					"nvosmkcwtdvfiyxuphzceraliq", "nvosmkcwtnxfiyxuphzgyraljq", "nvosmkfwtdefiyxupxzgeraljq",
					"nvosmacwtdbfiyxuphzseragjq", "nvpsmkcwtdbfzyxuvhzgeraljq", "nvormkcwtdbfiyxuphzairaljq",
					"rvysmkcwtdbfmyxuphzgeraljq", "nvosmscwzdbfiyxuphzgerbljq", "nvosmkcwtdufmyxuphzqeraljq",
					"nvosmkcwtxbfiyxxphzgeralxq", "nvosmkcwtdbsiyxupsfgeraljq", "nvosmccwtdbfiqxuthzgeraljq",
					"nvosmtcwtqbuiyxuphzgeraljq", "nvosmkcwtdbfiysurbzgeraljq", "nvowmkcwtdbfiyxuywzgeraljq",
					"xvosmkcktdbfiyxuhhzgeraljq", "nvosmkgwsdbfiyxmphzgeraljq", "jvofmkcwtdbfiyxupyzgeraljq",
					"nvozakcwtdbfiexuphzgeraljq", "nvosmkcptdbfiyxuphzgepaljn", "nvosmkcwtdbpiyxuphzgeraxjw",
					"nvoszkcwtdbfiyjuphzeeraljq", "nvosmkcwtdbfiyxuppzoeraejq", "nvosmkiytdbfiyhuphzgeraljq",
					"nvosmkcwtdvfiywupyzgeraljq", "nvosmecwtdofiyxuphzgeralja", "nvosmkqwtdbfixxuphzgeraojq",
					"nvosmkwwtdbfiyxfpdzgeraljq", "nvosmkgwtdbfiyzupwzgeraljq", "nmosmucwtdvfiyxuphzgeraljq",
					"nvosmdcwtdbmiyxuphzveraljq", "wvosmkcwtpbfiyxuphzgetaljq", "nvosmmcwtdlfbyxuphzgeraljq",
					"nvosmkcwtabmiexuphzgeraljq", "nvosqpcwtdbfiyxuphzgqraljq", "nvosmecwjdbfiyxuphzgeraljk",
					"nyohmkcwtdbfiyxuphzgzraljq", "nlosmkcwtkbfiyxuphzgeraejq", "nvosmkcwrdbliyxuphzgerpljq",
					"nvusmkzwtdbfxyxuphzgeraljq", "nvosmkcwtdbfiyxuhizgerazjq", "nvosmkhptdbfbyxuphzgeraljq",
					"nvosmfcwtdbgiyxupdzgeraljq", "nvosmkmwtdbfiyxuphzgevalpq", "nvosmkcwtdwfiyxuphzherjljq",
					"nvosmkcwjwbfiyxuphzgeualjq", "nvosmkcwxdbflymuphzgeraljq", "nvosmkcwpdbriyxuphzoeraljq",
					"nvoshkcwcdbfiyxuphzgeravjq", "nvosmkcetcbfiyxgphzgeraljq", "nvosmkcwtdyfiyxuphzgerwqjq",
					"nuosmkcwedbfiyxurhzgeraljq", "nvosmkcwtdbfiixuphzctraljq", "nvoszkcwtdbfwyxuphzgerpljq",
					"nvormkcwtdbfiyxuphzgeralzn", "nvosmkyttdbfiywuphzgeraljq", "nvosmkcwtdbhiyxupazgeralhq",
					"nvotmkcwtdbfiyxuphzgevalbq", "nvosmkcwedbfiyxuphzguraljr", "nvssmkcwtdbfiyxushzgeralbq",
					"nvosmkcwtdeziyxuphzgeralhq", "nvogmkcwtdbfiyxuphzgerrxjq", "ncormkcwtdbfiyxuphzgeraloq",
					"nvosmkcwbdbfiyeuphzgerqljq", "nvosxkcwtdbfsyxupfzgeraljq", "nvohmkcwtdbfiyxuphzseraajq",
					"nvoscdcwtdbfiyxuphzgeralqq", "neosmkcwtdbfiyxuchzgeralgq", "njosmvcwpdbfiyxuphzgeraljq",
					"nvosmkcwtwbfiyxuphzgehamjq", "nvosmkcwtdbfiyxushzgejaljv", "nvosmkcwodbfiyxuphzgeryqjq",
					"nvoymqcwtdbfiyxuphzgeralbq", "nvosmkcwtdjfiyxuphzgesaljb", "nvjsmdcwedbfiyxuphzgeraljq",
					"nvosmkcwydbfiyxuihzmeraljq", "nvrsmkcwtdifiyxuphzgqraljq", "nposmkcwtdbfiyxiohzgeraljq",
					"dvosmkcwtdbfiyxuphzrvraljq", "pvosmkcwudbfsyxuphzgeraljq", "noosmkcwtdbfiyxuphtgexaljq",
					"nvosmkcwtdbfiaxuphyferaljq", "nvhsmlcwtdbfiyxuphzgeualjq", "nvosekcwtdbbiyxuphzgerabjq",
					"nvosvkcitdbfiyxuphzgerarjq", "nvotmkkwtdbfiyxuphzgeraljj", "nvosmecwtdbfiyxuphzgyralwq",
					"hvosmkcwtdbfiyxuphzysraljq", "nvosmkcvtdbfiyxlphzgeraljb", "nvosmkcwttbfiyxuphngtraljq",
					"nvoslkcwtdbfiyxuphzqeraljr", "nxosmkcwtdbfibxuphzgrraljq", "nvokmkhwtdbfiyxuphzgwraljq",
					"nvosmkfwtdbfiyxuphzgdraljo", "nvcsmkcwtdbfibxuphzgeraljl", "nvosmkcwtdcfiaxuphzeeraljq",
					"wvosmkcwtdbyiyxjphzgeraljq", "nyosmbcwtjbfiyxuphzgeraljq", "nvosmkcwtdbiiyxuahzieraljq",
					"nqosmkcwtdbfiyxuyhzgerapjq", "nvosmkcwtdbfiyxuwhzzetaljq", "nvosmkcwfgbfiyxuphzgerrljq",
					"nvosmbcwtdbfipxuphzderaljq", "nvosmkcwtdgfiyxupdzgerjljq", "noosmkcwtdcfiyxuphlgeraljq",
					"nvonmkcutdbfiyxuphzieraljq", "nvocmkcwtdbfiyyuphageraljq", "nvosmkcwtdbfoyxuphzneraqjq",
					"nvoskkcwtdbtiyxuphzgevaljq", "ocosmkswtdbfiyxuphzgeraljq", "nvosmkcqtdbfiyxfvhzgeraljq",
					"noosmkcwtdbfiyquphzberaljq", "nvosmkcwttbfijxuchzgeraljq", "nvogmkcwtdbfiyxupazgeralaq",
					"nvqsmkcwtdbfikxuphzgeraliq", "nvosmkuwtdbfiyxuphzjwraljq", "nyosmhcwtdbfiyxuphzgereljq",
					"nvosmncwtdbfietuphzgeraljq", "gvpsmkcwtdbfiyxuyhzgeraljq", "nvozmkewtlbfiyxuphzgeraljq",
					"nvostkcltpbfiyxuphzgeraljq", "nvosmkcwtdbdiyxuphzgehaljz", "nvosmkcwtjbziyxuphzgexaljq",
					"nvosmkcwtdbfiyptphzggraljq", "nvosmkcwtdbliyxupjzgebaljq", "nvosmkawtdbfiyxupxzgtraljq",
					"vvosmkcwtdbfiyxfphzperaljq", "nvosmkawtdbfiyxutczgeraljq", "nvosmkcbtdbuiyxrphzgeraljq",
					"nvbsmkcwtdbfiyxdphzgerasjq", "nvosnkcwqdsfiyxuphzgeraljq", "nvosmkcwtdbfiyxwphzgzzaljq",
					"nvosmkcwtdbffyquphzgeralcq", "nvosmkcwtzbfiyxdphzgzraljq", "nvysmkcwtdbfiycvphzgeraljq",
					"nvowmkcwtdbfiycuyhzgeraljq", "nvosbkcwtdbfiyiuphzgeraqjq", "nvosmecwtdbfiyxupqzmeraljq",
					"nvosmkcdtdbfhyxsphzgeraljq", "nmosmkcwtdbziyxuphzgercljq", "nvosmkcwtdbfiyxupfmgersljq",
					"nvosmkcvtdbpyyxuphzgeraljq", "nvosmkcwtkbfiyaupxzgeraljq", "nvosmkcwtzbiiyxuphzgerazjq",
					"nvoxmkcwtdbfiyxuphztegaljq", "nvonmkcwtdafiyxuphzgerkljq", "rvommkcwtdbfiyxzphzgeraljq",
					"nvosmkcwthbfiysuphzgeraxjq", "nvosmkcwtdbfnyxuphzgerccjq", "nrosmzcwtdbfiyxuphkgeraljq",
					"nvolmkcdtdbfiyxuphtgeraljq", "nvosfkcwtdbfiyeuphcgeraljq", "nvowmkcwtdbfhyxuphzgerafjq",
					"gvosmkcwtdbfiyxupbpgeraljq", "nvosmkcwtdbkiyxuphegebaljq", "nvommufwtdbfiyxuphzgeraljq",
					"uvksmkcwtdbfiysuphzgeraljq", "nvosmkcwevbfiyxuphtgeraljq", "nvosmkcmtdbfiycuphzgeraxjq",
					"nvcsxkcwtdbfiyxuphzgeraljn", "nvosmkcwtdbtiymuphzgeraltq", "nvosmfcwtdlfjyxuphzgeraljq",
					"svosmkcitdbfiyxuphzgsraljq");

	public int execute() {

		int times2 = 0;
		int times3 = 0;

		for(String entry : inputList) {

			Map<Character, Integer> charCount = new HashMap<>();
			for(int i = 0; i < entry.length(); i++) {
				Character character = entry.charAt(i);

				if ( charCount.containsKey(character) ) {
					charCount.replace(character, charCount.get(character)+1);
				}
				else {
					charCount.put(character, 1);
				}
			}

			Iterator it = charCount.entrySet().iterator();
			boolean has2 = false;
			boolean has3 = false;

			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				if ( pair.getValue().equals(2))
					has2 = true;
				if ( pair.getValue().equals(3))
					has3 = true;
				if (has2 && has3)
					break;
			}

			if (has2)
				times2++;
			if (has3)
				times3++;
		}

		return (times2 * times3);
	}

}
