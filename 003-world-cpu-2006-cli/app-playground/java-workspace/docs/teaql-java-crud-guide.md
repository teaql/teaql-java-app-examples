# TeaQL Java CRUD Guide

Generated for `com.example.fifaworldcupservice`. Use this guide when adding controllers, services, jobs, or integration code in this workspace.

## Setup

```java
import com.example.fifaworldcupservice.Q;
import com.example.fifaworldcupservice.FifaWorldCup2026ServiceUserContext;
import io.teaql.core.web.WebResponse;
```

Most workspace code receives a TeaQL context from Spring:

```java
public WebResponse handle(@TQLContext UserContext userContext) {
    // use Q, WebResponse, and entity.auditAs("comment").save(userContext)
}
```

## Non-Negotiable Database Rule

Never use SQL to operate on the database from workspace business code. This includes select, insert, update, delete, schema changes, JDBC templates, native queries, direct repositories, and ad hoc SQL helpers.

If the generated TeaQL API does not provide a path for the requested change, stop and report the missing API. Do not implement a SQL workaround.

## Mandatory Update Method Rule

Use generated `updateXxx(...)` methods for all entity field changes. Do not use `setXxx(...)` in new code. Setters are deprecated even when the IDE or generated class makes them visible.

```java
entity.updateName("new value");
```

Do not write:

```java
entity.setName("new value");
```

## Read One Entity

Prefer typed generated query entry points. Controller methods that return one object should wrap the result in `WebResponse.of(...)`:

```java
public WebResponse getOne(@TQLContext UserContext userContext, Long id) {
    try {
        var entity = Q.tournaments()
            .filterById(id)
            .selectSelf()
            .comment("load detail by id")
            .purpose("get task detail")
            .executeForOne(userContext);
        return WebResponse.of(entity);
    } catch (Exception e) {
        return WebResponse.fail(e.getMessage());
    }
}
```

## Read A Page

Controller methods that return multiple objects should wrap the list in `WebResponse.of(...)`:

```java
public WebResponse list(@TQLContext UserContext userContext) {
    try {
        var list = Q.tournaments()
            .selectSelf()
            .page(1, 20)
            .comment("list tasks")
            .purpose("render dashboard list")
            .executeForList(userContext);
        return WebResponse.of(list);
    } catch (Exception e) {
        return WebResponse.fail(e.getMessage());
    }
}
```

## Create

```java
var entity = new Tournament();
// Fill fields with generated updateXxx(...) methods, not setXxx(...).
entity.auditAs("Create new item").save(userContext);
```

## Update

```java
var entity = Q.tournaments()
    .filterById(id)
    .selectSelf()
    .comment("load for update")
    .purpose("edit entity")
    .executeForOne(userContext);

// Use updateXxx(...) methods for state changes.
// entity.updateName("new value");
entity.auditAs("Update entity properties").save(userContext);
```

## Load Relations

Use generated selectors. Do not write a loop that queries children one row at a time. The examples below focus on the entities with the highest reverse relation counts because they are stronger aggregate-root candidates.

```java
var list = Q.tournaments()
    .selectMatchStageListWith(Q.matchStages().selectSelf())
    .comment("load with matchStageList")
    .purpose("fetch child matchStageList")
    .executeForList(userContext);
```

```java
var list = Q.tournaments()
    .selectMatchStatusListWith(Q.matchStatuses().selectSelf())
    .comment("load with matchStatusList")
    .purpose("fetch child matchStatusList")
    .executeForList(userContext);
```

```java
var list = Q.tournaments()
    .selectGoalCategoryListWith(Q.goalCategories().selectSelf())
    .comment("load with goalCategoryList")
    .purpose("fetch child goalCategoryList")
    .executeForList(userContext);
```

```java
var list = Q.tournaments()
    .selectCardCategoryListWith(Q.cardCategories().selectSelf())
    .comment("load with cardCategoryList")
    .purpose("fetch child cardCategoryList")
    .executeForList(userContext);
```

```java
var list = Q.tournaments()
    .selectConfederationListWith(Q.confederations().selectSelf())
    .comment("load with confederationList")
    .purpose("fetch child confederationList")
    .executeForList(userContext);
```

```java
var list = Q.tournaments()
    .selectTournamentTeamListWith(Q.tournamentTeams().selectSelf())
    .comment("load with tournamentTeamList")
    .purpose("fetch child tournamentTeamList")
    .executeForList(userContext);
```

```java
var list = Q.tournaments()
    .selectMatchGroupListWith(Q.matchGroups().selectSelf())
    .comment("load with matchGroupList")
    .purpose("fetch child matchGroupList")
    .executeForList(userContext);
```

```java
var list = Q.tournaments()
    .selectTournamentMatchListWith(Q.tournamentMatches().selectSelf())
    .comment("load with tournamentMatchList")
    .purpose("fetch child tournamentMatchList")
    .executeForList(userContext);
```

```java
var list = Q.tournaments()
    .selectMatchGoalListWith(Q.matchGoals().selectSelf())
    .comment("load with matchGoalList")
    .purpose("fetch child matchGoalList")
    .executeForList(userContext);
```

```java
var list = Q.tournaments()
    .selectMatchCardListWith(Q.matchCards().selectSelf())
    .comment("load with matchCardList")
    .purpose("fetch child matchCardList")
    .executeForList(userContext);
```

```java
var list = Q.tournaments()
    .selectGroupStandingListWith(Q.groupStandings().selectSelf())
    .comment("load with groupStandingList")
    .purpose("fetch child groupStandingList")
    .executeForList(userContext);
```

```java
var list = Q.tournamentTeams()
    .selectConfederationWith(Q.confederations().selectSelf())
    .comment("load with confederation")
    .purpose("fetch associated confederation")
    .executeForList(userContext);
```

```java
var list = Q.tournamentTeams()
    .selectTournamentWith(Q.tournaments().selectSelf())
    .comment("load with tournament")
    .purpose("fetch associated tournament")
    .executeForList(userContext);
```



```java
var list = Q.tournamentTeams()
    .selectTournamentMatchListAsHomeTeamWith(Q.tournamentMatches().selectSelf())
    .comment("load with tournamentMatchListAsHomeTeam")
    .purpose("fetch child tournamentMatchListAsHomeTeam")
    .executeForList(userContext);
```

```java
var list = Q.tournamentTeams()
    .selectTournamentMatchListAsAwayTeamWith(Q.tournamentMatches().selectSelf())
    .comment("load with tournamentMatchListAsAwayTeam")
    .purpose("fetch child tournamentMatchListAsAwayTeam")
    .executeForList(userContext);
```

```java
var list = Q.tournamentTeams()
    .selectMatchGoalListWith(Q.matchGoals().selectSelf())
    .comment("load with matchGoalList")
    .purpose("fetch child matchGoalList")
    .executeForList(userContext);
```

```java
var list = Q.tournamentTeams()
    .selectMatchCardListWith(Q.matchCards().selectSelf())
    .comment("load with matchCardList")
    .purpose("fetch child matchCardList")
    .executeForList(userContext);
```

```java
var list = Q.tournamentTeams()
    .selectGroupStandingListWith(Q.groupStandings().selectSelf())
    .comment("load with groupStandingList")
    .purpose("fetch child groupStandingList")
    .executeForList(userContext);
```

```java
var list = Q.matchGroups()
    .selectTournamentWith(Q.tournaments().selectSelf())
    .comment("load with tournament")
    .purpose("fetch associated tournament")
    .executeForList(userContext);
```



```java
var list = Q.matchGroups()
    .selectTournamentMatchListWith(Q.tournamentMatches().selectSelf())
    .comment("load with tournamentMatchList")
    .purpose("fetch child tournamentMatchList")
    .executeForList(userContext);
```

```java
var list = Q.matchGroups()
    .selectGroupStandingListWith(Q.groupStandings().selectSelf())
    .comment("load with groupStandingList")
    .purpose("fetch child groupStandingList")
    .executeForList(userContext);
```


## Delete

Use the generated TeaQL soft-delete API available on the entity/request class in this domain. If unsure, inspect the generated request class for the target entity and use the soft-delete operation it exposes.

Do not hard-delete rows. Do not write SQL `DELETE` or `UPDATE` statements. If the soft-delete API is not visible, stop and report that blocker instead of changing data through SQL.

## Common Mistakes

- Do not instantiate repositories directly in workspace business code.
- Do not use SQL for any database operation.
- Do not use deprecated `setXxx(...)` methods for updates. Use `updateXxx(...)`.
- Do not return raw entities or lists from controller query methods. Return `WebResponse.of(entity)` or `WebResponse.of(list)`.
- Do not forget `.executeForOne(userContext)` or `.executeForList(userContext)`.
- Do not forget `.comment("...")` and `.purpose("...")` on queries.
- Do not forget `.auditAs("...")` before calling `.save(ctx)` on entities.
- Do not assume relations are loaded unless the query selected them.
- Do not bypass `UserContext`; context carries logging, tenant, security, and repository resolution behavior.

## Entity Cheat Sheet

These entities are selected by reverse relation count, not by model declaration order.

- `Tournament`: reverse relations `11`, query `Q.tournaments()`, save `new Tournament().auditAs("comment").save(userContext)`, request `com.example.fifaworldcupservice.tournament.TournamentRequest`
- `TournamentTeam`: reverse relations `5`, query `Q.tournamentTeams()`, save `new TournamentTeam().auditAs("comment").save(userContext)`, request `com.example.fifaworldcupservice.tournamentteam.TournamentTeamRequest`
- `MatchGroup`: reverse relations `2`, query `Q.matchGroups()`, save `new MatchGroup().auditAs("comment").save(userContext)`, request `com.example.fifaworldcupservice.matchgroup.MatchGroupRequest`