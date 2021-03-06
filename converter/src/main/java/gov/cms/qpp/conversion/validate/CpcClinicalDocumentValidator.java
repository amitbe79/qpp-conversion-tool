package gov.cms.qpp.conversion.validate;

import gov.cms.qpp.conversion.decode.ClinicalDocumentDecoder;
import gov.cms.qpp.conversion.model.Node;
import gov.cms.qpp.conversion.model.Program;
import gov.cms.qpp.conversion.model.TemplateId;
import gov.cms.qpp.conversion.model.Validator;

/**
 * Validates the Clinical Document level node for the given program: CPC+
 */
@Validator(value = TemplateId.CLINICAL_DOCUMENT, program = Program.CPC)
public class CpcClinicalDocumentValidator extends NodeValidator {

	static final String MISSING_PRACTICE_SITE_ADDRESS = "Must contain a practice site address "
			+ "for CPC+ conversions";
	static final String ONLY_ONE_APM_ALLOWED =
			"One and only one Alternative Payment Model (APM) Entity Identifier should be specified";
	static final String ONE_MEASURE_SECTION_REQUIRED = "Must contain one Measure (eCQM) section";

	/**
	 * Validates a single clinical document node
	 *
	 * @param node The node to validate.
	 */
	@Override
	protected void internalValidateSingleNode(Node node) {
			check(node)
					.valueIsNotEmpty(MISSING_PRACTICE_SITE_ADDRESS, ClinicalDocumentDecoder.PRACTICE_SITE_ADDR)
					.singleValue(ONLY_ONE_APM_ALLOWED, ClinicalDocumentDecoder.ENTITY_ID)
					.childMinimum(ONE_MEASURE_SECTION_REQUIRED, 1, TemplateId.MEASURE_SECTION_V2);
	}
}
