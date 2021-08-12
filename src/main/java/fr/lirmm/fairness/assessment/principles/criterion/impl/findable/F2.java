package fr.lirmm.fairness.assessment.principles.criterion.impl.findable;

import java.io.IOException;

import fr.lirmm.fairness.assessment.principles.criterion.question.AbstractCriterionQuestion;
import fr.lirmm.fairness.assessment.principles.criterion.question.Testable;
import fr.lirmm.fairness.assessment.principles.criterion.question.Tester;
import fr.lirmm.fairness.assessment.principles.criterion.question.tests.MetaDataExistTest;
import org.json.JSONException;

import fr.lirmm.fairness.assessment.model.Ontology;
import fr.lirmm.fairness.assessment.principles.criterion.AbstractPrincipleCriterion;

public class F2 extends AbstractPrincipleCriterion {

    private static final long serialVersionUID = -3376420498708614002L;

    @Override
    protected void doEvaluation(Ontology ontology) throws JSONException, IOException {
;
        this.addResult(Tester.doEvaluation(ontology, questions.get(0), new Testable() {
            @Override
            public void doTest(Ontology ontology, AbstractCriterionQuestion question) {
                String[] props = {ontology.getName(), ontology.getAlternative(), ontology.getHiddenLabel(),
                        ontology.getIdentifier(), ontology.getHasOntoLang(), ontology.getDescription(), ontology.getHomePage(), ontology.getPullLocation(),
                        ontology.getKeyWords(), ontology.getCoverage(), ontology.getPrefNamSpacUri(), ontology.getUriRegexPat(),
                        ontology.getExpId(), ontology.getCreator(), ontology.getContributor(), ontology.getPublisher(), ontology.getCuratedBy(),
                        ontology.getTranslator(), ontology.getDomain(), ontology.getCompatWith(), ontology.getSameDomain(), ontology.getKnownUsage(),
                        ontology.getAudience(), ontology.getRepository(), ontology.getBugDatabase(), ontology.getMailingList(),
                };

                this.setScoreLevel(countExistentMetaData(props, question.getPoints().size()), question);
            }
        }));

        this.addResult(Tester.doEvaluation(ontology, questions.get(1), new Testable() {
            @Override
            public void doTest(Ontology ontology, AbstractCriterionQuestion question) {
                String[] props = { // should properties
                        ontology.getMetrics(),
                        ontology.getNumberOfClasses(),
                        ontology.getNumberOfProperties(),
                        ontology.getNumberOfIndividuals(),
                        ontology.getNumberOfAxioms()
                };

                this.setScoreLevel(countExistentMetaData(props, question.getPoints().size()), question);
            }
        }));

        this.addResult(Tester.doEvaluation(ontology, questions.get(2), new Testable() {
            @Override
            public void doTest(Ontology ontology, AbstractCriterionQuestion question) {
                String[] props = { // optional properties
                        ontology.getPreferredNamespacePrefix()
                };

                this.setScoreLevel(countExistentMetaData(props, question.getPoints().size()), question);
            }
        }));

        this.addResult(Tester.doEvaluation(ontology, questions.get(3), new Testable() {
            @Override
            public void doTest(Ontology ontology, AbstractCriterionQuestion question) {
                String[] props = {
                        String.join(";", ontology.getLanguage()), ontology.getAbstract(), ontology.getPublication(),
                        ontology.getNotes(), ontology.getDepiction(), ontology.getLogo(), ontology.getToDoList(),
                        ontology.getAward(), ontology.getAssociatedMedia(), String.join(";", ontology.getIsIncompatibleWith()),
                        ontology.getHasPart(), ontology.getWorkTranslation(), ontology.getHasDisparateModelling(),
                        String.join(";", ontology.getUsedBy()), ontology.getHasDisjunctionsWith(),
                        ontology.getKeyClasses(), ontology.getDataDump(), ontology.getOpenSearchDescription(),
                        ontology.getUriLookupEndpoint(), ontology.getReleased(), ontology.getModificationDate(),
                        ontology.getValid(), ontology.getType(),
                };

                this.setScoreLevel(countExistentMetaData(props, question.getPoints().size()), question);
            }
        }));

    }


}
