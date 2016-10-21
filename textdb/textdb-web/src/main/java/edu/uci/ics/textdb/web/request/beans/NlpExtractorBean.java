package edu.uci.ics.textdb.web.request.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.uci.ics.textdb.dataflow.nlpextrator.NlpPredicate.NlpTokenType;
import edu.uci.ics.textdb.plangen.operatorbuilder.NlpExtractorBuilder;

import java.util.HashMap;

/**
 * This class defines the properties/data members specific to the NlpExtractor operator
 * and extends the OperatorBean class which defines the data members general to all operators
 * Created by kishorenarendran on 10/17/16.
 */
@JsonTypeName("NlpExtractor")
public class NlpExtractorBean extends OperatorBean {
    @JsonProperty("nlp_type")
    private NlpTokenType nlpTokenType;

    public NlpExtractorBean() {
    }

    public NlpExtractorBean(String operatorID, String operatorType, String attributes, String limit, String offset,
                            NlpTokenType nlpTokenType) {
        super(operatorID, operatorType, attributes, limit, offset);
        this.nlpTokenType = nlpTokenType;
    }

    @JsonProperty("nlp_type")
    public NlpTokenType getNlpTokenType() {
        return nlpTokenType;
    }

    @JsonProperty("nlp_type")
    public void setNlpTokenType(NlpTokenType nlpTokenType) {
        this.nlpTokenType = nlpTokenType;
    }

    @Override
    public HashMap<String, String> getOperatorProperties() {
        HashMap<String, String> operatorProperties = super.getOperatorProperties();
        operatorProperties.put(NlpExtractorBuilder.NLP_TYPE, this.getNlpTokenType().name());
        return operatorProperties;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof OperatorBean)) return false;
        NlpExtractorBean nlpExtractorBean = (NlpExtractorBean) other;
        return super.equals(other) &&
                this.getNlpTokenType().name().equals(nlpExtractorBean.getNlpTokenType().name());
    }
}
