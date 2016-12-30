package edu.uci.ics.textdb.textql.statements.predicates;


/**
 * Object representation of an extraction predicate such as "KEYWORDEXTRACT(...)" predicate 
 * inside a { @code SelectExtractStatement }..
 * Subclasses have specific fields related to its extraction functionalities.
 * ExtractPredicate --+ KeywordExtractPredicate
 * 
 * @author Flavio Bayer
 * 
 */
public abstract class ExtractPredicate {
	
    

    @Override
    public boolean equals(Object other) {
        if (other == null) { return false; }
        if (other.getClass() != this.getClass()) { return false; }
        ExtractPredicate extractPredicate = (ExtractPredicate) other;
        return true;
    }
    
}