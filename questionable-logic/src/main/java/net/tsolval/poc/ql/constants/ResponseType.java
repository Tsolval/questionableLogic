package net.tsolval.poc.ql.constants;

/**
 * Indicates the type of response for a question.
 * 
 * @author walker.d.adams
 * 
 *         TODO: This response type needs to be user expandable. Perhaps this
 *         should be an interface with implementations for each type. We can
 *         wire them into the questions with Spring or reflectively call the
 *         appropriate implementation.
 */
public enum ResponseType {
	/**
	 * Typical String binary responses such as "True"/"False", "Yes"/"No", or
	 * "0"/"1"
	 **/
	BOOLEAN,
	/** Text based answers using a text box. **/
	TEXTBOX,
	/** Text based answers using a text area. **/
	TEXTAREA,
	/** Numeric response type without decimals. **/
	INTEGER,
	/** Numeric response type with a decimal point. **/
	DECIMAL,
	/** A file attachment. **/
	ATTACHMENT,
	/** The response is indicated by a checkbox. **/
	CHECKBOX,
	/**
	 * Indicates that the response to this question is a list of checkbox
	 * responses. TODO: revist this explanation.
	 **/
	CHECKLIST,
	/** The response is indicated by a radio box. **/
	RADIO,
	/** The response is a list of questions in a radio set. **/
	RADIOLIST,
	/** The response type is a password-type obscured text box. **/
	SECRET,
	/**
	 * This Response Type represents a question that doesn't have answers.
	 * Usually used to group questions.
	 */
	NONE
}
