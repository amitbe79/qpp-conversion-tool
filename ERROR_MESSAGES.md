# Error messages
Current list of all error messages being output by the converter.
Any text in the following format `(Example)` are considered variables to be filled in.

## List of errors that output to users upon decoding and encoding failures:
* Unexpected exception occurred during conversion
* The file is not a valid XML document
* The file is not a QRDA-III XML document
* Failure to encode
* Failed to find an encoder
* Failed to find an encoder for child node `(specific template id name)`
	* Ex. : Failed to find an encoder for child node AGGREGATE_COUNT
* No encoder for decoder : `(specific template id name)`
	* Ex. : No encoder for decoder : AGGREGATE_COUNT
* Error parsing reporting parameter performance start
* Error parsing reporting parameter performance end

## List of errors that output to users upon validation failure:
* This Denominator Node does not have an Aggregate Count Node
* This Denominator Node Aggregate Value is not an integer
* This Denominator Node Aggregate Value has an invalid value
* This Denominator Node does not have any child Nodes
* This Denominator Node has too many child Nodes
* An ACI Measure Performed RnR's requires a single Measure ID
* The ACI Measure Performed RnR's Measure Performed is required
* The ACI Measure Performed RnR's Measure Performed can only be present once
* This ACI Numerator Denominator Node should have an ACI Section Node as a parent
* This ACI Numerator Denominator Node does not contain a measure name ID
* This ACI Numerator Denominator Node does not contain a Numerator Node child
* This ACI Numerator Denominator Node contains too many Numerator Node children
* This ACI Numerator Denominator Node does not contain a Denominator Node child
* This ACI Numerator Denominator Node contains too many Denominator Node children
* This ACI Numerator Denominator Node does not have any child Nodes
* This Numerator Node does not have an Aggregate Count Node
* This Numerator Node Aggregate Value is not an integer
* This Numerator Node Aggregate Value has an invalid value
* This Numerator Node does not have any child Nodes
* This Numerator Node has too many child Nodes
* The ACI Section must have one Reporting Parameter ACT
* A single aggregate count value is required.
* Aggregate count value must be an integer.
* Clinical Document Node must have at least one Aci or IA or eCQM Section Node as a child
* Clinical Document must have one and only one program name
* Clinical Document program name is not recognized
* Clinical Document contains duplicate ACI sections
* Clinical Document contains duplicate IA sections
* Clinical Document contains duplicate eCQM sections
* Must contain a practice site address for CPC+ conversions
* One and only one Alternative Payment Model (APM) Entity Identifier should be specified
* Must contain one Measure (eCQM) section
* Must have at least one NPI/TIN combination
* Must be 01/01/2017 _Performance Start Period_
* Must be 12/31/2017 _Performance End Period_
* Must contain correct number of performance rate(s). Correct Number is `(Number of performance rates required)`
	* Ex. : Must contain correct number of performance rate(s). Correct Number is 3
* Missing strata `(Reporting Stratum UUID)` for `(Current subpopulation type)` measure `(Current subpopulation UUID)`
	* Ex. : Missing strata EFB5B088-CE10-43DE-ACCD-9913B7AC12A2 for DENEX measure (56BC7FA2-C22A-4440-8652-2D3568852C60) 
* Amount of stratifications `(Current number of Reporting Stratifiers)` does not meet expectations `(Number of stratifiers required)` for `(Current subpopulation type)` measure `(Current Subpopulation UUID)`. Expected strata: `(Expected strata uuid list)`
	* Ex. : Amount of stratifications 0 does not meet expectations 2 for DENEX measure (56BC7FA2-C22A-4440-8652-2D3568852C60). Expected strata: \[EFB5B088-CE10-43DE-ACCD-9913B7AC12A2, 94B9555F-8700-45EF-B69F-433EBEDE8051\]
* A single measure performed value is required and must be either a Y or an N.
* Measure performed must have exactly one child.
* The IA Section must have at least one IA Measure
* The IA Section must have one Reporting Parameter ACT
* The IA Section must contain only measures and reporting parameter
* Measure performed must have exactly one Aggregate Count.
* Measure data must be a positive integer value
* Clinical Document Node is required
* Only one Clinical Document Node is allowed
* Must enter a valid Performance Rate value
* The measure reference results must have a measure GUID
* The measure reference results must have a single measure population
* The measure reference results must have a single measure type
* The measure reference results must have at least one measure
* The Denominator count must be less than or equal to Initial Population count 
for an eCQM that is proportion measure
* The eCQM (electronic measure id: `(Current eMeasure ID)`) requires `(Number of Subpopulations required)` `(Type of Subpopulation required)`(s) but there are `(Number of Subpopulations existing)`
	* Ex. : The eCQM (electronic measure id: CMS165v5) requires 1 DENEX(s) but there are 0
* The eCQM (electronic measure id: `(Current eMeasure ID)`) requires a `(Subpopulation type)` with the correct UUID of `(Correct uuid required)`
	* Ex. : The eCQM (electronic measure id: CMS165v5) requires a DENEX with the correct UUID of 55A6D5F3-2029-4896-B850-4C7894161D7D
* The eCQM (electronic measure id: `(Current eMeasure ID)`) has a performanceRateId with an incorrect UUID of `(Incorrect UUID)`
	* Ex. : The eCQM (electronic measure id: CMS68v6) has a performanceRateUuid with an incorrect UUID of 00000000-0000-0000-0000-1NV4L1D
* A Performance Rate must contain a single Performance Rate UUID
* The Quality Measure Section must have only one Reporting Parameter ACT
* Must have a performance year
* Must have one and only one performance start
* Must have one and only one performance end
