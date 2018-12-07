package day2;

import java.util.Arrays;
import java.util.List;

public class Day2Part2 {

	private List<String> inputList = Arrays.asList
					("naosmkcwtdbfivxuphzweraljq", "nvssmicltdbfiyxuphzgeraljq", "nvosmkcwwdbfiyxuphzeeraljx",
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

	private List<String> sampleImput = Arrays.asList("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz");

	public String execute() {
		int lowestDifference = 26;
		int lowestDifferenceIdA = 0;
		int lowestDifferenceIdB = 0;

		for (int i = 0; i < inputList.size(); i++) {
			for (int j = i + 1; j < inputList.size(); j++) {
				String elementA = inputList.get(i);
				String elementB = inputList.get(j);

				int difference = 0;
				for (int k = 0; k < elementA.length(); k++) {
					Character characterA = elementA.charAt(k);
					Character characterB = elementB.charAt(k);

					if (characterA != characterB) {
						difference++;
						if (difference > lowestDifference)
							break;
					}
				}
				if (difference < lowestDifference) {
					lowestDifference = difference;
					lowestDifferenceIdA = i;
					lowestDifferenceIdB = j;
				}
			}
		}

		//Remote different characters
		String elementA = inputList.get(lowestDifferenceIdA);
		String elementB = inputList.get(lowestDifferenceIdB);
		StringBuilder result = new StringBuilder();
		for (int l = 0; l < elementA.length(); l++) {
			Character characterA = elementA.charAt(l);
			Character characterB = elementB.charAt(l);

			if (characterA.equals(characterB))
				result.append(characterA);
		}
		return result.toString();
	}

}
