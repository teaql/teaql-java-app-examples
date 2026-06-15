package com.example.fifaworldcupservice.cardcategory;

import com.example.fifaworldcupservice.Q;
import com.example.fifaworldcupservice.matchcard.MatchCard;
import com.example.fifaworldcupservice.matchcard.MatchCardRequest;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;

public class CardCategoryRequest<T extends CardCategory> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public CardCategoryRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public CardCategoryRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public CardCategoryRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public CardCategoryRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public CardCategoryRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public CardCategoryRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public CardCategoryRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (CardCategoryRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public CardCategoryRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public CardCategoryRequest<T> matchingAnyOf(CardCategoryRequest cardCategory){
        super.internalMatchAny(cardCategory);
        return this;
    }

    public CardCategoryRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public CardCategoryRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public CardCategoryRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public CardCategoryRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectName().selectCode().selectTournamentIdOnly().selectVersion();
    }

    public CardCategoryRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public CardCategoryRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectName().selectCode().selectTournament().selectVersion();
    }

    public CardCategoryRequest<T> selectChildren(){
        super.selectAny();
        selectMatchCardList();
        return selectId().selectName().selectCode().selectTournament().selectVersion();
    }


    public CardCategoryRequest<T> selectId(){
       selectProperty(CardCategory.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CardCategoryRequest<T> unselectId(){
       unselectProperty(CardCategory.ID_PROPERTY);
       return this;
    }
    public CardCategoryRequest<T> selectName(){
       selectProperty(CardCategory.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CardCategoryRequest<T> unselectName(){
       unselectProperty(CardCategory.NAME_PROPERTY);
       return this;
    }
    public CardCategoryRequest<T> selectCode(){
       selectProperty(CardCategory.CODE_PROPERTY);
       return this;
    }

    /**
     * fill the code with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  code) to fetch code property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CardCategoryRequest<T> unselectCode(){
       unselectProperty(CardCategory.CODE_PROPERTY);
       return this;
    }
    public CardCategoryRequest<T> selectTournamentIdOnly(){
       selectProperty(CardCategory.TOURNAMENT_PROPERTY);
       return this;
    }

    public CardCategoryRequest<T> selectTournament(){
        return selectTournamentWith(Q.tournaments().unlimited().selectSelf());
    }

    public CardCategoryRequest<T> selectTournamentWith(TournamentRequest tournament){
       selectProperty(CardCategory.TOURNAMENT_PROPERTY);
       enhanceRelation(CardCategory.TOURNAMENT_PROPERTY, tournament);
       return this;
    }

    public CardCategoryRequest<T> unselectTournament(){
       unselectProperty(CardCategory.TOURNAMENT_PROPERTY);
       return this;
    }
    public CardCategoryRequest<T> selectVersion(){
       selectProperty(CardCategory.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CardCategoryRequest<T> unselectVersion(){
       unselectProperty(CardCategory.VERSION_PROPERTY);
       return this;
    }
    public CardCategoryRequest<T> selectMatchCardList(){
       return selectMatchCardListWith(Q.matchCards().selectSelf());
    }

    public CardCategoryRequest<T> selectMatchCardListWith(MatchCardRequest matchCardList){
       enhanceRelation(CardCategory.MATCH_CARD_LIST_PROPERTY, matchCardList);
       return this;
    }

    public CardCategoryRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(CardCategory.ID_PROPERTY, operator, values);
    }

    public CardCategoryRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public CardCategoryRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public CardCategoryRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public CardCategoryRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public CardCategoryRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public CardCategoryRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(CardCategory.NAME_PROPERTY, operator, values);
    }

    public CardCategoryRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public CardCategoryRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public CardCategoryRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public CardCategoryRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public CardCategoryRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public CardCategoryRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public CardCategoryRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public CardCategoryRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public CardCategoryRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public CardCategoryRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public CardCategoryRequest<T> filterByCode(String... code){
      if (code == null || code.length == 0) {
        throw new IllegalArgumentException("filterByCode parameter code cannot be empty");
      }
      return appendSearchCriteria(createCodeCriteria(Operator.EQUAL, (Object[])code));
    }

    public CardCategoryRequest<T> withCode(Operator operator, Object... values){
       return appendSearchCriteria(createCodeCriteria(operator, values));
    }

    public CardCategoryRequest<T> withCodeIsUnknown(){
       return withCode(Operator.IS_NULL);
    }

    public CardCategoryRequest<T> withCodeIsKnown(){
       return withCode(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCodeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(CardCategory.CODE_PROPERTY, operator, values);
    }

    public CardCategoryRequest<T> withCodeGreaterThan(String code){
       return withCode(Operator.GREATER_THAN, code);
    }

    public CardCategoryRequest<T> withCodeGreaterThanOrEqualTo(String code){
       return withCode(Operator.GREATER_THAN_OR_EQUAL, code);
    }

    public CardCategoryRequest<T> withCodeLessThan(String code){
       return withCode(Operator.LESS_THAN, code);
    }

    public CardCategoryRequest<T> withCodeLessThanOrEqualTo(String code){
       return withCode(Operator.LESS_THAN_OR_EQUAL, code);
    }

    public CardCategoryRequest<T> withCodeBetween(String startOfCode, String endOfCode){
       return withCode(Operator.BETWEEN, startOfCode, endOfCode);
    }
    public CardCategoryRequest<T> withCodeStartingWith(String code){
       return withCode(Operator.BEGIN_WITH, code);
    }
    public CardCategoryRequest<T> withCodeContaining(String code){
       return withCode(Operator.CONTAIN, code);
    }

    public CardCategoryRequest<T> withCodeEndingWith(String code){
       return withCode(Operator.END_WITH, code);
    }

    public CardCategoryRequest<T> withCodeIs(String code){
       return withCode(Operator.EQUAL, code);
    }

    public CardCategoryRequest<T> withCodeSoundingLike(String code){
       return withCode(Operator.SOUNDS_LIKE, code);
    }



    public CardCategoryRequest<T> filterByTournament(Tournament... tournament){
      if (tournament == null || tournament.length == 0) {
        throw new IllegalArgumentException("filterByTournament parameter tournament cannot be empty");
      }
      return appendSearchCriteria(createTournamentCriteria(Operator.EQUAL, (Object[])tournament));
    }

    public CardCategoryRequest<T> withTournament(Operator operator, Object... values){
       return appendSearchCriteria(createTournamentCriteria(operator, values));
    }

    public CardCategoryRequest<T> withTournamentIsUnknown(){
       return withTournament(Operator.IS_NULL);
    }

    public CardCategoryRequest<T> withTournamentIsKnown(){
       return withTournament(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTournamentCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(CardCategory.TOURNAMENT_PROPERTY, operator, values);
    }

    public CardCategoryRequest<T> filterByTournament(Long tournament){
      if(tournament == null){
         return this;
      }
      return withTournament(Operator.EQUAL, tournament);
    }
    public CardCategoryRequest<T> withTournamentMatching(TournamentRequest tournament){
       return appendSearchCriteria(new SubQuerySearchCriteria(CardCategory.TOURNAMENT_PROPERTY, tournament, Tournament.ID_PROPERTY));
    }

    public CardCategoryRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public CardCategoryRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public CardCategoryRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public CardCategoryRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(CardCategory.VERSION_PROPERTY, operator, values);
    }

    public CardCategoryRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public CardCategoryRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public CardCategoryRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public CardCategoryRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public CardCategoryRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public CardCategoryRequest<T> withMatchCardListMatching(MatchCardRequest matchCardRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(CardCategory.ID_PROPERTY, matchCardRequest, MatchCard.CARD_CATEGORY_PROPERTY));
    }

    public CardCategoryRequest<T> withoutMatchCardListMatching(MatchCardRequest matchCardRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(CardCategory.ID_PROPERTY, matchCardRequest, MatchCard.CARD_CATEGORY_PROPERTY)));
    }

    public CardCategoryRequest<T> haveMatchCards(){
        return withMatchCardListMatching(Q.matchCards().unlimited());
    }

    public CardCategoryRequest<T> haveNoMatchCards(){
        return withoutMatchCardListMatching(Q.matchCards().unlimited());
    }

    public CardCategoryRequest<T> count(){
        super.count();
        return this;
    }
    public CardCategoryRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public CardCategoryRequest<T> groupByTournamentWithDetails(){
       return groupByTournamentWithDetails(Q.tournaments().unlimited());
    }

    public CardCategoryRequest<T> groupByTournamentWithDetails(TournamentRequest subRequest){
       aggregate(CardCategory.TOURNAMENT_PROPERTY, subRequest);
       return this;
    }


    public CardCategoryRequest<T> groupByMatchCardsWithDetails(MatchCardRequest subRequest){
       aggregate(CardCategory.MATCH_CARD_LIST_PROPERTY, subRequest);
       return this;
    }

    public CardCategoryRequest<T> groupById(){
       groupBy(CardCategory.ID_PROPERTY);
       return this;
    }

    public CardCategoryRequest<T> groupByIdAs(String retName){
       groupBy(retName, CardCategory.ID_PROPERTY);
       return this;
    }

    public CardCategoryRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, CardCategory.ID_PROPERTY, function);
       return this;
    }

    public CardCategoryRequest<T> groupByName(){
       groupBy(CardCategory.NAME_PROPERTY);
       return this;
    }

    public CardCategoryRequest<T> groupByNameAs(String retName){
       groupBy(retName, CardCategory.NAME_PROPERTY);
       return this;
    }

    public CardCategoryRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, CardCategory.NAME_PROPERTY, function);
       return this;
    }

    public CardCategoryRequest<T> groupByCode(){
       groupBy(CardCategory.CODE_PROPERTY);
       return this;
    }

    public CardCategoryRequest<T> groupByCodeAs(String retName){
       groupBy(retName, CardCategory.CODE_PROPERTY);
       return this;
    }

    public CardCategoryRequest<T> groupByCodeWithFunction(String retName, AggrFunction function){
       groupBy(retName, CardCategory.CODE_PROPERTY, function);
       return this;
    }
    public CardCategoryRequest<T> groupByTournamentWith(TournamentRequest subRequest){
       groupBy(CardCategory.TOURNAMENT_PROPERTY, subRequest);
       return this;
    }
    public CardCategoryRequest<T> groupByTournament(){
       groupBy(CardCategory.TOURNAMENT_PROPERTY);
       return this;
    }

    public CardCategoryRequest<T> groupByTournamentAs(String retName){
       groupBy(retName, CardCategory.TOURNAMENT_PROPERTY);
       return this;
    }

    public CardCategoryRequest<T> groupByTournamentWithFunction(String retName, AggrFunction function){
       groupBy(retName, CardCategory.TOURNAMENT_PROPERTY, function);
       return this;
    }

    public CardCategoryRequest<T> groupByVersion(){
       groupBy(CardCategory.VERSION_PROPERTY);
       return this;
    }

    public CardCategoryRequest<T> groupByVersionAs(String retName){
       groupBy(retName, CardCategory.VERSION_PROPERTY);
       return this;
    }

    public CardCategoryRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, CardCategory.VERSION_PROPERTY, function);
       return this;
    }



    public CardCategoryRequest<T> orderByIdAscending(){
       addOrderByAscending(CardCategory.ID_PROPERTY);
       return this;
    }

    public CardCategoryRequest<T> orderByIdDescending(){
       addOrderByDescending(CardCategory.ID_PROPERTY);
       return this;
    }

    public CardCategoryRequest<T> orderByNameAscending(){
       addOrderByAscending(CardCategory.NAME_PROPERTY);
       return this;
    }

    public CardCategoryRequest<T> orderByNameDescending(){
       addOrderByDescending(CardCategory.NAME_PROPERTY);
       return this;
    }
    public CardCategoryRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(CardCategory.NAME_PROPERTY);
       return this;
    }

    public CardCategoryRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(CardCategory.NAME_PROPERTY);
       return this;
    }
    public CardCategoryRequest<T> orderByCodeAscending(){
       addOrderByAscending(CardCategory.CODE_PROPERTY);
       return this;
    }

    public CardCategoryRequest<T> orderByCodeDescending(){
       addOrderByDescending(CardCategory.CODE_PROPERTY);
       return this;
    }
    public CardCategoryRequest<T> orderByCodeAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(CardCategory.CODE_PROPERTY);
       return this;
    }

    public CardCategoryRequest<T> orderByCodeDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(CardCategory.CODE_PROPERTY);
       return this;
    }
    public CardCategoryRequest<T> orderByTournamentAscending(){
       addOrderByAscending(CardCategory.TOURNAMENT_PROPERTY);
       return this;
    }

    public CardCategoryRequest<T> orderByTournamentDescending(){
       addOrderByDescending(CardCategory.TOURNAMENT_PROPERTY);
       return this;
    }

    public CardCategoryRequest<T> orderByVersionAscending(){
       addOrderByAscending(CardCategory.VERSION_PROPERTY);
       return this;
    }

    public CardCategoryRequest<T> orderByVersionDescending(){
       addOrderByDescending(CardCategory.VERSION_PROPERTY);
       return this;
    }


    public CardCategoryRequest<T> statsFromMatchCardsAs(String name, MatchCardRequest subRequest){
       return statsFromMatchCardsAs(name, subRequest, false);
    }

    public CardCategoryRequest<T> statsFromMatchCardsAs(String name, MatchCardRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(MatchCard.CARD_CATEGORY_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public CardCategoryRequest<T> statsFromMatchCards(MatchCardRequest subRequest){
       return statsFromMatchCardsAs(REFINEMENTS, subRequest);
    }
    public TournamentRequest rollUpToTournament(){
       TournamentRequest tournament = Q.tournaments().unlimited();
       this.withTournamentMatching(tournament)
           .groupByTournamentWith(tournament);
       return tournament;
    }


    public CardCategoryRequest<T> countMatchCards(){
        return countMatchCardsAs("Count");
    }

    public CardCategoryRequest<T> countMatchCardsAs(String name){
        return countMatchCardsWith(name, Q.matchCards().unlimited());
    }

    public CardCategoryRequest<T> countMatchCardsWith(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.count(), true);
    }
    public CardCategoryRequest<T> minMinuteIssuedOfMatchCards(){
        return minMinuteIssuedOfMatchCardsAs("minMinuteIssuedOfMatchCards");
    }

    public CardCategoryRequest<T> minMinuteIssuedOfMatchCardsAs(String name){
        return minMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public CardCategoryRequest<T> minMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.minMinuteIssued(), true);
    }
    public CardCategoryRequest<T> maxMinuteIssuedOfMatchCards(){
        return maxMinuteIssuedOfMatchCardsAs("maxMinuteIssuedOfMatchCards");
    }

    public CardCategoryRequest<T> maxMinuteIssuedOfMatchCardsAs(String name){
        return maxMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public CardCategoryRequest<T> maxMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.maxMinuteIssued(), true);
    }
    public CardCategoryRequest<T> sumMinuteIssuedOfMatchCards(){
        return sumMinuteIssuedOfMatchCardsAs("sumMinuteIssuedOfMatchCards");
    }

    public CardCategoryRequest<T> sumMinuteIssuedOfMatchCardsAs(String name){
        return sumMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public CardCategoryRequest<T> sumMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.sumMinuteIssued(), true);
    }
    public CardCategoryRequest<T> avgMinuteIssuedOfMatchCards(){
        return avgMinuteIssuedOfMatchCardsAs("avgMinuteIssuedOfMatchCards");
    }

    public CardCategoryRequest<T> avgMinuteIssuedOfMatchCardsAs(String name){
        return avgMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public CardCategoryRequest<T> avgMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.avgMinuteIssued(), true);
    }
    public CardCategoryRequest<T> standardDeviationMinuteIssuedOfMatchCards(){
        return standardDeviationMinuteIssuedOfMatchCardsAs("stdDevMinuteIssuedOfMatchCards");
    }

    public CardCategoryRequest<T> standardDeviationMinuteIssuedOfMatchCardsAs(String name){
        return standardDeviationMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public CardCategoryRequest<T> standardDeviationMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.standardDeviationMinuteIssued(), true);
    }
    public CardCategoryRequest<T> squareRootOfPopulationStandardDeviationMinuteIssuedOfMatchCards(){
        return squareRootOfPopulationStandardDeviationMinuteIssuedOfMatchCardsAs("stdDevPopMinuteIssuedOfMatchCards");
    }

    public CardCategoryRequest<T> squareRootOfPopulationStandardDeviationMinuteIssuedOfMatchCardsAs(String name){
        return squareRootOfPopulationStandardDeviationMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public CardCategoryRequest<T> squareRootOfPopulationStandardDeviationMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.squareRootOfPopulationStandardDeviationMinuteIssued(), true);
    }
    public CardCategoryRequest<T> sampleVarianceMinuteIssuedOfMatchCards(){
        return sampleVarianceMinuteIssuedOfMatchCardsAs("varSampMinuteIssuedOfMatchCards");
    }

    public CardCategoryRequest<T> sampleVarianceMinuteIssuedOfMatchCardsAs(String name){
        return sampleVarianceMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public CardCategoryRequest<T> sampleVarianceMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.sampleVarianceMinuteIssued(), true);
    }
    public CardCategoryRequest<T> samplePopulationVarianceMinuteIssuedOfMatchCards(){
        return samplePopulationVarianceMinuteIssuedOfMatchCardsAs("varPopMinuteIssuedOfMatchCards");
    }

    public CardCategoryRequest<T> samplePopulationVarianceMinuteIssuedOfMatchCardsAs(String name){
        return samplePopulationVarianceMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public CardCategoryRequest<T> samplePopulationVarianceMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.samplePopulationVarianceMinuteIssued(), true);
    }

   public CardCategoryRequest<T> facetByTournamentAs(String facetName, TournamentRequest tournament){
       return facetByTournamentAs(facetName, tournament, true);
   }

   public CardCategoryRequest<T> facetByTournamentAs(String facetName, TournamentRequest tournament, boolean includeAllFacets){
       addFacet(facetName, CardCategory.TOURNAMENT_PROPERTY, tournament, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public CardCategoryRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public CardCategoryRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public CardCategoryRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public CardCategoryRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public CardCategoryRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}