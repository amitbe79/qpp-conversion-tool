package gov.cms.qpp.conversion.decode;


import gov.cms.qpp.conversion.model.Node;
import gov.cms.qpp.conversion.model.XmlDecoder;
import org.jdom2.Element;

/**
 * Decoder to read XML Data for an ACI Section.
 *
 */
@XmlDecoder(templateId="2.16.840.1.113883.10.20.27.2.5")
public class AciSectionDecoder extends QppXmlDecoder {

	/**
	 * Decodes an ACI Section into the QPP format
	 *
	 * @param element XML element that represents the ACI Section
	 * @param thisNode Node represents the aci section
	 * @return DecodeResult.TreeContinue thisNode gets the newly parsed XML Fragments
	 */
	@Override
	protected DecodeResult internalDecode(Element element, Node thisNode) {
		thisNode.putValue("category", "aci");
		return DecodeResult.TREE_CONTINUE;
	}
}
