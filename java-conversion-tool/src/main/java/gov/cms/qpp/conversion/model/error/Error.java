package gov.cms.qpp.conversion.model.error;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds a list of validation errors associated with a single source.
 *
 * The source could be a file, a stream, or some other entity.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Error {

	private String sourceIdentifier;
	private String type;
	private String message;
	@JsonProperty("details")
	private List<Detail> details;

	/**
	 * Constructs an empty {@code Error}.
	 */
	public Error() {
		//empty on purpose
	}

	/**
	 * Constructs an {@code Error} with the specified source identifier and list of
	 * {@link Detail}.
	 *
	 * @param sourceIdentifier The identifier of a source that contains the validation errors
	 * @param details The list of {@code Detail}s.
	 */
	public Error(final String sourceIdentifier, final List<Detail> details) {
		this.sourceIdentifier = sourceIdentifier;
		this.details = details;
	}

	/**
	 * Gets the source identifier.
	 *
	 * @return The source identifier.
	 */
	public String getSourceIdentifier() {
		return sourceIdentifier;
	}

	/**
	 * Sets the source identifier.
	 *
	 * @param sourceIdentifier The source identifier.
	 */
	public void setSourceIdentifier(final String sourceIdentifier) {
		this.sourceIdentifier = sourceIdentifier;
	}

	/**
	 * Gets the type.
	 *
	 * @return The type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type The type.
	 */
	public void setType(final String type) {
		this.type = type;
	}

	/**
	 * Gets the message.
	 *
	 * @return The message.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message The message.
	 */
	public void setMessage(final String message) {
		this.message = message;
	}

	/**
	 * getDetails returns the list of ValidationErrors
	 *
	 * @return A list of ValidationErrors.
	 */
	@JsonProperty("details")
	public List<Detail> getDetails() {
		return details;
	}

	/**
	 * setDetails sets the internal List of Detail
	 *
	 * @param details A list of ValidationErrors.
	 */
	@JsonProperty("details")
	public void setDetails(final List<Detail> details) {
		this.details = details;
	}

	/**
	 * addValidationError will add an error to the list of validation errors
	 *
	 * @param detail The Detail to add.
	 */
	public void addValidationError(final Detail detail) {
		if (null == details) {
			details = new ArrayList<>();
		}

		details.add(detail);
	}
}
