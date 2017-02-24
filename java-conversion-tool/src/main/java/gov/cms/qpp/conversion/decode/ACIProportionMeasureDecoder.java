package gov.cms.qpp.conversion.decode;

import java.util.Arrays;
import java.util.List;

import org.jdom2.Element;

import gov.cms.qpp.conversion.model.XmlDecoder;
import gov.cms.qpp.conversion.model.Node;

@XmlDecoder(templateId="2.16.840.1.113883.10.20.27.3.28")
public class ACIProportionMeasureDecoder extends QppXmlDecoder {
	@Override
	protected Node internalDecode(Element element, Node thisnode) {
		
		String measureId = getMethodId(element);
		
		if (null != measureId) {
			thisnode.putValue("measureId", measureId);
		}
		
		List<Element> children = element.getChildren("component");
		
		if (children != null) {
			for (Element child : children) {
				this.decode(child, thisnode);
			}
		}
		
	
		
		return thisnode;
		
	}

	private String getMethodId(Element element) {
		String measureId = null;
		
		if (null == element) {
			return measureId;
		}
		
		List<String> nameList = Arrays.asList("reference", "externalDocument", "id");
		Element ele = element;
		for (String n : nameList) {
			ele = ele.getChild(n);
			if (null == ele) {
				break;
			}
			if ("id".equals(n)) {
				measureId = ele.getAttributeValue("extension");
			}
		}
		return measureId;
	}
		
}