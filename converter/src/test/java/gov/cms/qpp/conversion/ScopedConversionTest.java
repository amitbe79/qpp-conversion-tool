package gov.cms.qpp.conversion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.common.collect.Sets;
import gov.cms.qpp.conversion.encode.JsonWrapper;
import gov.cms.qpp.conversion.model.TemplateId;
import gov.cms.qpp.conversion.model.error.TransformException;
import gov.cms.qpp.conversion.segmentation.QrdaScope;
import gov.cms.qpp.conversion.util.JsonHelper;
import gov.cms.qpp.conversion.validate.AciDenominatorValidator;
import gov.cms.qpp.conversion.validate.AciNumeratorDenominatorValidator;
import gov.cms.qpp.conversion.validate.AciNumeratorValidator;
import gov.cms.qpp.conversion.validate.AciSectionValidator;
import gov.cms.qpp.conversion.validate.AggregateCountValidator;
import gov.cms.qpp.conversion.validate.IaMeasureValidator;
import gov.cms.qpp.conversion.validate.IaSectionValidator;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.google.common.truth.Truth.assertWithMessage;
import static gov.cms.qpp.conversion.util.JsonHelper.readJson;

/**
 * Verify scoped conversions
 */
public class ScopedConversionTest {

	private static final String SUCCESS_MAKER = "../qrda-files/valid-QRDA-III-latest.xml";
	private static final String ERROR_MAKER = "src/test/resources/negative/angerTheConverter.xml";

	private static Map<String, Object> fixtures;

	/**
	 * Load fixture json for use as a baseline for expected scoped conversion outcomes.
	 */
	@BeforeClass
	@SuppressWarnings("unchecked")
	public static void loadFixtures() throws IOException {
		fixtures = readJson(Paths.get("src/test/resources/converter/scopedConversionFixture.json"), HashMap.class);
	}

	/**
	 * Verify CMS V2 Measure Section conversion
	 */
	@Test
	public void testScopedV2MeasureSectionConversion() throws IOException {
		//when
		QrdaScope testSection = QrdaScope.getInstanceByName(TemplateId.MEASURE_SECTION_V2.name());
		Map<String, Object> content = scopedConversion(testSection);

		//then
		assertWithMessage("content should match valid %s fixture", testSection)
				.that(fixtures.get(testSection.name()))
				.isEqualTo(getScoped(content).get(0));
	}

	/**
	 * Verify CMS V2 Measure Reference Results conversion
	 */
	@Test
	public void testScopedCmsV2MeasureReferenceResultsConversion() throws IOException {
		//when
		QrdaScope testSection = QrdaScope.getInstanceByName(TemplateId.MEASURE_REFERENCE_RESULTS_CMS_V2.name());
		Map<String, Object> content = scopedConversion(testSection);

		//then
		assertWithMessage("content should match valid %s fixture", testSection)
				.that(fixtures.get(testSection.name()))
				.isEqualTo(getScoped(content));
	}

	/**
	 * Verify CMS V2 Measure Data conversion
	 */
	@Test
	public void testScopedV2MeasureDataConversion() throws IOException {
		//when
		QrdaScope testSection = QrdaScope.getInstanceByName(TemplateId.MEASURE_DATA_CMS_V2.name());
		Map<String, Object> content = scopedConversion(testSection);

		//then
		assertWithMessage("content should match valid %s fixture", testSection)
				.that(fixtures.get(testSection.name()))
				.isEqualTo(getScoped(content));
	}

	/**
	 * Verify ACI Section conversion
	 */
	@Test
	public void testScopedAciSectionConversion() throws IOException {
		//setup
		QrdaScope testSection = QrdaScope.getInstanceByName(TemplateId.ACI_SECTION.name());
		Map<String, Object> content = scopedConversion(testSection);

		//then
		assertWithMessage("content should match valid %s fixture", testSection)
				.that(fixtures.get(testSection.name()))
				.isEqualTo(getScoped(content).get(0));
	}


	/**
	 * Verify IA Section conversion
	 */
	@Test
	public void testScopedIaSectionConversion() throws IOException {
		//when
		QrdaScope testSection = QrdaScope.getInstanceByName(TemplateId.IA_SECTION.name());
		Map<String, Object> content = scopedConversion(testSection);

		//then
		assertWithMessage("content should match valid %s fixture", testSection)
				.that(fixtures.get(testSection.name()))
				.isEqualTo(getScoped(content).get(0));
	}

	/**
	 * Verify ACI Aggregate Count conversion
	 */
	@Test
	public void testScopedAciAggregateCountConversion() throws IOException {
		//when
		QrdaScope testSection = QrdaScope.getInstanceByName(TemplateId.ACI_AGGREGATE_COUNT.name());
		Map<String, Object> content = scopedConversion(testSection);

		//then
		assertWithMessage("content should match valid %s fixture", testSection)
				.that(fixtures.get(testSection.name()))
				.isEqualTo(getScoped(content));
	}

	/**
	 * Verify ACI Numerator conversion
	 */
	@Test
	public void testScopedAciNumeratorConversion() throws IOException {
		//when
		QrdaScope testSection = QrdaScope.getInstanceByName(TemplateId.ACI_NUMERATOR.name());
		Map<String, Object> content = scopedConversion(testSection);

		//then
		assertWithMessage("content should match valid %s fixture", testSection)
				.that(fixtures.get(testSection.name()))
				.isEqualTo(getScoped(content));
	}

	/**
	 * Verify ACI Denominator conversion
	 */
	@Test
	public void testScopedAciDenominatorConversion() throws IOException {
		//when
		QrdaScope testSection = QrdaScope.getInstanceByName(TemplateId.ACI_DENOMINATOR.name());
		Map<String, Object> content = scopedConversion(testSection);

		//then
		assertWithMessage("content should match valid %s fixture", testSection)
				.that(fixtures.get(testSection.name()))
				.isEqualTo(getScoped(content));
	}

	/**
	 * Verify ACI Numerator Denominator conversion
	 */
	@Test
	public void testScopedAciNumeratorDenominatorConversion() throws IOException {
		//when
		QrdaScope testSection = QrdaScope.getInstanceByName(TemplateId.ACI_NUMERATOR_DENOMINATOR.name());
		Map<String, Object> content = scopedConversion(testSection);

		//then
		assertWithMessage("content should match valid %s fixture", testSection)
				.that(fixtures.get(testSection.name()))
				.isEqualTo(getScoped(content));
	}

	/**
	 * Verify Clinical Document conversion
	 */
	@Test
	public void testFullScopeConversion() throws IOException {
		//when
		QrdaScope testSection = QrdaScope.getInstanceByName(TemplateId.CLINICAL_DOCUMENT.name());
		Map<String, Object> content = scopedConversion(testSection);

		//then
		assertWithMessage("content should match valid %s fixture", testSection)
				.that(fixtures.get(testSection.name()))
				.isEqualTo(content);
	}

	//negative

	/**
	 * Verify failure for attempted invalid Clinical Document conversion
	 */
	@Test
	public void testNegativeFullScopeConversion() throws IOException {
		//when
		QrdaScope testSection = QrdaScope.getInstanceByName(TemplateId.CLINICAL_DOCUMENT.name());
		List<Map<String, String>> content = getErrors(errantScopedConversion(testSection));

		//then
		assertWithMessage("Error count should be 7")
				.that(content.size())
				.isEqualTo(7);

		assertWithMessage("Errant %s fails as expected", TemplateId.CLINICAL_DOCUMENT)
				.that(getErrorMessages(content))
				.containsExactly(
						AciSectionValidator.MINIMUM_REPORTING_PARAM_REQUIREMENT_ERROR,
						AciNumeratorDenominatorValidator.TOO_MANY_NUMERATORS,
						String.format(AciNumeratorValidator.NOT_AN_INTEGER_VALUE, AciNumeratorValidator.NUMERATOR_NAME),
						String.format(AciDenominatorValidator.INVALID_VALUE, AciDenominatorValidator.DENOMINATOR_NAME),
						IaSectionValidator.REPORTING_PARAM_REQUIREMENT_ERROR,
						IaMeasureValidator.TYPE_ERROR);
	}

	/**
	 * Verify failure for attempted invalid ACI Numerator Denominator conversion
	 */
	@Test
	public void testNegativeAciNumeratorDenominatorConversion() throws IOException {
		//when
		QrdaScope testSection = QrdaScope.getInstanceByName(TemplateId.ACI_NUMERATOR_DENOMINATOR.name());
		List<Map<String, String>> content = getErrors(errantScopedConversion(testSection));

		//then
		assertWithMessage("Error count should be 5")
				.that(content.size())
				.isEqualTo(5);

		assertWithMessage("Errant %s fails as expected", TemplateId.ACI_NUMERATOR_DENOMINATOR)
				.that(getErrorMessages(content))
				.containsExactly(
						AciSectionValidator.MINIMUM_REPORTING_PARAM_REQUIREMENT_ERROR,
						AciNumeratorDenominatorValidator.TOO_MANY_NUMERATORS,
						String.format(AciNumeratorValidator.NOT_AN_INTEGER_VALUE, AciNumeratorValidator.NUMERATOR_NAME),
						String.format(AciDenominatorValidator.INVALID_VALUE, AciDenominatorValidator.DENOMINATOR_NAME));
	}

	/**
	 * Verify failure for attempted invalid IA Section conversion
	 */
	@Test
	public void testNegativeIaSectionConversion() throws IOException {
		//when
		QrdaScope testSection = QrdaScope.getInstanceByName(TemplateId.IA_SECTION.name());
		List<Map<String, String>> content = getErrors(errantScopedConversion(testSection));

		//then
		assertWithMessage("Error count should be 2")
				.that(content.size())
				.isEqualTo(2);

		assertWithMessage("Errant %s fails as expected", TemplateId.IA_SECTION)
				.that(getErrorMessages(content))
				.containsExactly(
						IaSectionValidator.REPORTING_PARAM_REQUIREMENT_ERROR,
						IaMeasureValidator.TYPE_ERROR);
	}

	/**
	 * Verify failure for attempted invalid ACI Aggregate Count conversion
	 */
	@Test
	public void testNegativeAciAggregateCountConversion() throws IOException {
		//when
		QrdaScope testSection = QrdaScope.getInstanceByName(TemplateId.ACI_AGGREGATE_COUNT.name());
		List<Map<String, String>> content = getErrors(errantScopedConversion(testSection));

		//then
		assertWithMessage("Error count should be 3")
				.that(content.size())
				.isEqualTo(3);

		assertWithMessage("Errant %s fails as expected", TemplateId.ACI_AGGREGATE_COUNT)
				.that(getErrorMessages(content))
				.containsExactly(
						AggregateCountValidator.TYPE_ERROR,
						AggregateCountValidator.VALUE_ERROR);
	}

	@SuppressWarnings("unchecked")
	private Map<String, Object> scopedConversion(QrdaScope testSection) {
		Converter converter = new Converter(new PathQrdaSource(Paths.get(SUCCESS_MAKER)));
		converter.getContext().setScope(Sets.newHashSet(testSection));
		JsonWrapper qpp = converter.transform();
		return (Map<String, Object>) JsonHelper.readJson(qpp.toString(), HashMap.class);
	}

	@SuppressWarnings("unchecked")
	private Map<String, Object> errantScopedConversion(QrdaScope testSection) throws JsonProcessingException {
		Converter converter = new Converter(new PathQrdaSource(Paths.get(ERROR_MAKER)));
		converter.getContext().setScope(Sets.newHashSet(testSection));
		Map<String, Object> content = null;
		try {
			converter.transform();
		} catch (TransformException exception) {
			content = JsonHelper.readJson(getErrors(exception), HashMap.class);
		}
		return content;
	}

	private String getErrors(TransformException exception) throws JsonProcessingException {
		ObjectWriter jsonObjectWriter = new ObjectMapper()
				.setSerializationInclusion(JsonInclude.Include.NON_NULL)
				.writer()
				.withDefaultPrettyPrinter();
		return jsonObjectWriter.writeValueAsString(exception.getDetails());
	}

	private Set<String> getErrorMessages(List<Map<String, String>> content) {
		return content.stream()
				.map(map -> map.get("message"))
				.collect(Collectors.toSet());
	}

	/**
	 * Helper for retrieving validation errors
	 *
	 * @param content hash representing conversion error output
	 * @return list of validation errors
	 */
	@SuppressWarnings("unchecked")
	private <T> List<T> getErrors(Map<String, Object> content) {
		return (List<T>) ((Map<String, T>) ((List<T>) content.get("errors")).get(0)).get("details");
	}

	/**
	 * Helper for retrieving scoped conversion content
	 *
	 * @param content hash representing valid conversion output
	 * @return list of converted hashes / lists
	 */
	private List<?> getScoped(Map<String, Object> content) {
		return (List<?>) content.get("scoped");
	}
}
