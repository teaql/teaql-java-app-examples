# TeaQL API Guide

Generated for `com.example.fifaworldcupservice`. Domain: **fifa-world-cup-2026-service**.

---

## Part 1 — API Rules

### 1.1 Query Chain

Every query follows this chain:

```java
var list = Q.tournaments()
    .filterByXxx(value)            // optional filters
    .selectSelf()                  // select own fields
    .comment("what this loads")    // REQUIRED — describe what query loads
    .purpose("why it is needed")   // REQUIRED — describe why data is needed
    .executeForList(ctx);          // terminal: returns SmartList
```

Single-object variant:

```java
var entity = Q.tournaments()
    .filterById(id)
    .selectSelf()
    .comment("load single entity")
    .purpose("display detail page")
    .executeForOne(ctx);
```

Pagination:

```java
var page = Q.tournaments()
    .selectSelf()
    .page(1, 20)
    .comment("page listing")
    .purpose("list view")
    .executeForList(ctx);
```

### 1.2 Filter Operators

#### String Filters

| Method | SQL Equivalent |
|--------|---------------|
| `.<prefix>Name(value)` | `= value` |
| `.<prefix>NameIsNull()` | `IS NULL` |
| `.<prefix>NameIsNotNull()` | `IS NOT NULL` |
| `.<prefix>NameIsEmpty()` | `= ''` |
| `.<prefix>NameNot(value)` | `<> value` |
| `.<prefix>NameContain<suffix>(text)` | `LIKE '%text%'` |
| `.<prefix>NameStartWith(text)` | `LIKE 'text%'` |
| `.<prefix>NameEndWith(text)` | `LIKE '%text'` |
| `.<prefix>NameIn(list)` | `IN (...)` |
| `.<prefix>NameNotIn(list)` | `NOT IN (...)` |
| `.<prefix>NameMatchPattern(pattern)` | `LIKE pattern` |

> `<prefix>` is `whose` for Human entities, `with` for Thing entities.
> `<suffix>` is `s` for Human entities, `ing` for Thing entities.

#### Number Filters

| Method | SQL Equivalent |
|--------|---------------|
| `.<prefix>Age(value)` | `= value` |
| `.<prefix>AgeGreaterThan(n)` | `> n` |
| `.<prefix>AgeLessThan(n)` | `< n` |
| `.<prefix>AgeBetween(min, max)` | `BETWEEN min AND max` |
| `.<prefix>AgeIn(list)` | `IN (...)` |

#### DateTime Filters

| Method | SQL Equivalent |
|--------|---------------|
| `.<prefix>CreateTime(value)` | `= value` |
| `.<prefix>CreateTimeGreaterThan(dt)` | `> dt` |
| `.<prefix>CreateTimeLessThan(dt)` | `< dt` |
| `.<prefix>CreateTimeBetween(from, to)` | `BETWEEN from AND to` |
| `.<prefix>CreateTimeIsNull()` | `IS NULL` |

#### Boolean Filters

| Method | SQL Equivalent |
|--------|---------------|
| `.<prefix>Active(true)` | `= true` |
| `.<prefix>Active(false)` | `= false` |
| `.whoAre<Property>()` / `.whichAre<Property>()` | `= true` |
| `.whoAreNot<Property>()` / `.whichAreNot<Property>()` | `= false` |

> Human entities use `whoAre` / `whoAreNot`. Thing entities use `whichAre` / `whichAreNot`.

### 1.3 Human vs Thing Naming

| Aspect | Human Entity | Thing Entity |
|--------|-------------|-------------|
| Filter prefix | `whose` | `with` |
| String contain suffix | `Contains` (e.g. `whoseNameContains`) | `Containing` (e.g. `withNameContaining`) |
| Boolean shortcut | `whoAre` / `whoAreNot` | `whichAre` / `whichAreNot` |
| Example | `Q.employees().whoseNameContains("John")` | `Q.tasks().withNameContaining("build")` |

### 1.4 Entity Field Methods

For every property `P` on an entity, three methods are generated:

| Method | Usage | Notes |
|--------|-------|-------|
| `getP()` | Read field value | Getter |
| `updateP(value)` | **Preferred** — change field | Use this for all updates |
| `setP(value)` | **DEPRECATED** — do not use | Exists for legacy compatibility |

```java
// Correct
entity.updateName("new value");

// WRONG — do not use setters
entity.setName("new value");
```

### 1.5 Relation Methods

For a relation `R` pointing to entity `Child`:

| Method | Description |
|--------|-------------|
| `selectR()` | Select the relation for loading |
| `selectRWith(Q.children().selectSelf())` | Select relation with nested query |
| `withRMatching(Q.children().whoseXxx(v))` | Filter parent by child criteria |
| `getRList()` | Get loaded child list from parent |
| `updateR(child)` | Set/change the relation target |

```java
// Load parent with children
var list = Q.tournaments()
    .selectSelf()
    .selectChildrenWith(Q.children().selectSelf())
    .comment("load with children")
    .purpose("display tree")
    .executeForList(ctx);
```

### 1.6 Status Enum Shortcuts

For constant/enum fields (e.g. `Status` with values `PLANNED`, `ACTIVE`), TeaQL generates filter and update shortcuts:

```java
// Filter shortcuts
Q.tasks().withStatusIsPlanned()
Q.tasks().withStatusIsActive()

// Update shortcuts
entity.updateStatusToPlanned();
entity.updateStatusToActive();
```

### 1.7 Mutation Patterns

#### Create

```java
var entity = new Tournament();
entity.updateName("example");
// set other fields with updateXxx(...)
entity.auditAs("Create new item").save(ctx);
```

#### Update

```java
var entity = Q.tournaments()
    .filterById(id)
    .selectSelf()
    .comment("load for update")
    .purpose("edit entity")
    .executeForOne(ctx);

entity.updateName("updated value");
entity.auditAs("Update name").save(ctx);
```

#### Delete (Soft Delete)

```java
var entity = Q.tournaments()
    .filterById(id)
    .selectSelf()
    .comment("load for delete")
    .purpose("soft delete entity")
    .executeForOne(ctx);

entity.markAsDeleted();
entity.auditAs("Soft delete entity").save(ctx);
```

> Never hard-delete. Never use SQL DELETE. Use `markAsDeleted()` + `save(ctx)`.

### 1.8 Expression Facade (E)

The generated `E` class provides null-safe expression chains:

```java
// Instead of manual null checks:
String name = E.tournament(entity).name().value();
// Returns "" if entity or name is null

int version = E.tournament(entity).version().value();
// Returns 0 if null
```

| Method | Returns |
|--------|---------|
| `.value()` | The actual value, or type-appropriate default (`0`, `""`, `false`) |
| `.isPresent()` | Whether the value is non-null |

---

## Part 2 — Domain Graph

Package: `com.example.fifaworldcupservice`

### Entity: MatchStage

- **Query**: `Q.matchStages()`
- **Filter prefix**: `with`
- **Filter suffix**: `ing`
- **Display name**: Match Stage
- **Category**: Thing — uses `with`, `Containing`, `whichAre`

| Property | Type | Getter | Updater |
|----------|------|--------|---------|
| name |  | `getName()` | `updateName(value)` |

| code |  | `getCode()` | `updateCode(value)` |

| tournament |  | `getTournament()` | `updateTournament(value)` |


**Relations (outgoing):**
- `tournament` → references another entity (select with `selectTournament()`)


**Children (incoming):**
- `tournamentMatchList` → TournamentMatch (select with `selectTournamentMatchList()`)


---

### Entity: MatchStatus

- **Query**: `Q.matchStatuses()`
- **Filter prefix**: `with`
- **Filter suffix**: `ing`
- **Display name**: Match Status
- **Category**: Thing — uses `with`, `Containing`, `whichAre`

| Property | Type | Getter | Updater |
|----------|------|--------|---------|
| name |  | `getName()` | `updateName(value)` |

| code |  | `getCode()` | `updateCode(value)` |

| tournament |  | `getTournament()` | `updateTournament(value)` |


**Relations (outgoing):**
- `tournament` → references another entity (select with `selectTournament()`)


**Children (incoming):**
- `tournamentMatchList` → TournamentMatch (select with `selectTournamentMatchList()`)


---

### Entity: GoalCategory

- **Query**: `Q.goalCategories()`
- **Filter prefix**: `with`
- **Filter suffix**: `ing`
- **Display name**: Goal Category
- **Category**: Thing — uses `with`, `Containing`, `whichAre`

| Property | Type | Getter | Updater |
|----------|------|--------|---------|
| name |  | `getName()` | `updateName(value)` |

| code |  | `getCode()` | `updateCode(value)` |

| tournament |  | `getTournament()` | `updateTournament(value)` |


**Relations (outgoing):**
- `tournament` → references another entity (select with `selectTournament()`)


**Children (incoming):**
- `matchGoalList` → MatchGoal (select with `selectMatchGoalList()`)


---

### Entity: CardCategory

- **Query**: `Q.cardCategories()`
- **Filter prefix**: `with`
- **Filter suffix**: `ing`
- **Display name**: Card Category
- **Category**: Thing — uses `with`, `Containing`, `whichAre`

| Property | Type | Getter | Updater |
|----------|------|--------|---------|
| name |  | `getName()` | `updateName(value)` |

| code |  | `getCode()` | `updateCode(value)` |

| tournament |  | `getTournament()` | `updateTournament(value)` |


**Relations (outgoing):**
- `tournament` → references another entity (select with `selectTournament()`)


**Children (incoming):**
- `matchCardList` → MatchCard (select with `selectMatchCardList()`)


---

### Entity: Confederation

- **Query**: `Q.confederations()`
- **Filter prefix**: `with`
- **Filter suffix**: `ing`
- **Display name**: Confederation
- **Category**: Thing — uses `with`, `Containing`, `whichAre`

| Property | Type | Getter | Updater |
|----------|------|--------|---------|
| name |  | `getName()` | `updateName(value)` |

| code |  | `getCode()` | `updateCode(value)` |

| tournament |  | `getTournament()` | `updateTournament(value)` |


**Relations (outgoing):**
- `tournament` → references another entity (select with `selectTournament()`)


**Children (incoming):**
- `tournamentTeamList` → TournamentTeam (select with `selectTournamentTeamList()`)


---

### Entity: Tournament

- **Query**: `Q.tournaments()`
- **Filter prefix**: `with`
- **Filter suffix**: `ing`
- **Display name**: Tournament
- **Category**: Thing — uses `with`, `Containing`, `whichAre`

| Property | Type | Getter | Updater |
|----------|------|--------|---------|
| tournamentName |  | `getTournamentName()` | `updateTournamentName(value)` |

| hostCountries |  | `getHostCountries()` | `updateHostCountries(value)` |

| startDate |  | `getStartDate()` | `updateStartDate(value)` |

| endDate |  | `getEndDate()` | `updateEndDate(value)` |

| totalTeams |  | `getTotalTeams()` | `updateTotalTeams(value)` |

| createTime |  | `getCreateTime()` | `updateCreateTime(value)` |

| updateTime |  | `getUpdateTime()` | `updateUpdateTime(value)` |


**Children (incoming):**
- `matchStageList` → MatchStage (select with `selectMatchStageList()`)

- `matchStatusList` → MatchStatus (select with `selectMatchStatusList()`)

- `goalCategoryList` → GoalCategory (select with `selectGoalCategoryList()`)

- `cardCategoryList` → CardCategory (select with `selectCardCategoryList()`)

- `confederationList` → Confederation (select with `selectConfederationList()`)

- `tournamentTeamList` → TournamentTeam (select with `selectTournamentTeamList()`)

- `matchGroupList` → MatchGroup (select with `selectMatchGroupList()`)

- `tournamentMatchList` → TournamentMatch (select with `selectTournamentMatchList()`)

- `matchGoalList` → MatchGoal (select with `selectMatchGoalList()`)

- `matchCardList` → MatchCard (select with `selectMatchCardList()`)

- `groupStandingList` → GroupStanding (select with `selectGroupStandingList()`)


---

### Entity: TournamentTeam

- **Query**: `Q.tournamentTeams()`
- **Filter prefix**: `with`
- **Filter suffix**: `ing`
- **Display name**: Tournament Team
- **Category**: Thing — uses `with`, `Containing`, `whichAre`

| Property | Type | Getter | Updater |
|----------|------|--------|---------|
| teamName |  | `getTeamName()` | `updateTeamName(value)` |

| teamCode |  | `getTeamCode()` | `updateTeamCode(value)` |

| emojiFlag |  | `getEmojiFlag()` | `updateEmojiFlag(value)` |

| fifaRanking |  | `getFifaRanking()` | `updateFifaRanking(value)` |

| managerName |  | `getManagerName()` | `updateManagerName(value)` |

| confederation |  | `getConfederation()` | `updateConfederation(value)` |

| groupLetter |  | `getGroupLetter()` | `updateGroupLetter(value)` |

| tournament |  | `getTournament()` | `updateTournament(value)` |

| createTime |  | `getCreateTime()` | `updateCreateTime(value)` |

| updateTime |  | `getUpdateTime()` | `updateUpdateTime(value)` |


**Relations (outgoing):**
- `confederation` → references another entity (select with `selectConfederation()`)

- `tournament` → references another entity (select with `selectTournament()`)


**Children (incoming):**
- `tournamentMatchListAsHomeTeam` → TournamentMatch (select with `selectTournamentMatchListAsHomeTeam()`)

- `tournamentMatchListAsAwayTeam` → TournamentMatch (select with `selectTournamentMatchListAsAwayTeam()`)

- `matchGoalList` → MatchGoal (select with `selectMatchGoalList()`)

- `matchCardList` → MatchCard (select with `selectMatchCardList()`)

- `groupStandingList` → GroupStanding (select with `selectGroupStandingList()`)


---

### Entity: MatchGroup

- **Query**: `Q.matchGroups()`
- **Filter prefix**: `with`
- **Filter suffix**: `ing`
- **Display name**: Match Group
- **Category**: Thing — uses `with`, `Containing`, `whichAre`

| Property | Type | Getter | Updater |
|----------|------|--------|---------|
| groupLetter |  | `getGroupLetter()` | `updateGroupLetter(value)` |

| tournament |  | `getTournament()` | `updateTournament(value)` |

| createTime |  | `getCreateTime()` | `updateCreateTime(value)` |

| updateTime |  | `getUpdateTime()` | `updateUpdateTime(value)` |


**Relations (outgoing):**
- `tournament` → references another entity (select with `selectTournament()`)


**Children (incoming):**
- `tournamentMatchList` → TournamentMatch (select with `selectTournamentMatchList()`)

- `groupStandingList` → GroupStanding (select with `selectGroupStandingList()`)


---

### Entity: TournamentMatch

- **Query**: `Q.tournamentMatches()`
- **Filter prefix**: `with`
- **Filter suffix**: `ing`
- **Display name**: Tournament Match
- **Category**: Thing — uses `with`, `Containing`, `whichAre`

| Property | Type | Getter | Updater |
|----------|------|--------|---------|
| matchNumber |  | `getMatchNumber()` | `updateMatchNumber(value)` |

| matchDate |  | `getMatchDate()` | `updateMatchDate(value)` |

| venueName |  | `getVenueName()` | `updateVenueName(value)` |

| venueCity |  | `getVenueCity()` | `updateVenueCity(value)` |

| venueCountry |  | `getVenueCountry()` | `updateVenueCountry(value)` |

| homeScore |  | `getHomeScore()` | `updateHomeScore(value)` |

| awayScore |  | `getAwayScore()` | `updateAwayScore(value)` |

| extraTimeHome |  | `getExtraTimeHome()` | `updateExtraTimeHome(value)` |

| extraTimeAway |  | `getExtraTimeAway()` | `updateExtraTimeAway(value)` |

| penaltyHome |  | `getPenaltyHome()` | `updatePenaltyHome(value)` |

| penaltyAway |  | `getPenaltyAway()` | `updatePenaltyAway(value)` |

| homeTeam |  | `getHomeTeam()` | `updateHomeTeam(value)` |

| awayTeam |  | `getAwayTeam()` | `updateAwayTeam(value)` |

| matchStage |  | `getMatchStage()` | `updateMatchStage(value)` |

| matchGroup |  | `getMatchGroup()` | `updateMatchGroup(value)` |

| matchStatus |  | `getMatchStatus()` | `updateMatchStatus(value)` |

| tournament |  | `getTournament()` | `updateTournament(value)` |

| createTime |  | `getCreateTime()` | `updateCreateTime(value)` |

| updateTime |  | `getUpdateTime()` | `updateUpdateTime(value)` |


**Relations (outgoing):**
- `homeTeam` → references another entity (select with `selectHomeTeam()`)

- `awayTeam` → references another entity (select with `selectAwayTeam()`)

- `matchStage` → references another entity (select with `selectMatchStage()`)

- `matchGroup` → references another entity (select with `selectMatchGroup()`)

- `matchStatus` → references another entity (select with `selectMatchStatus()`)

- `tournament` → references another entity (select with `selectTournament()`)


**Children (incoming):**
- `matchGoalList` → MatchGoal (select with `selectMatchGoalList()`)

- `matchCardList` → MatchCard (select with `selectMatchCardList()`)


---

### Entity: MatchGoal

- **Query**: `Q.matchGoals()`
- **Filter prefix**: `with`
- **Filter suffix**: `ing`
- **Display name**: Match Goal
- **Category**: Thing — uses `with`, `Containing`, `whichAre`

| Property | Type | Getter | Updater |
|----------|------|--------|---------|
| playerName |  | `getPlayerName()` | `updatePlayerName(value)` |

| minuteScored |  | `getMinuteScored()` | `updateMinuteScored(value)` |

| tournamentMatch |  | `getTournamentMatch()` | `updateTournamentMatch(value)` |

| tournamentTeam |  | `getTournamentTeam()` | `updateTournamentTeam(value)` |

| goalCategory |  | `getGoalCategory()` | `updateGoalCategory(value)` |

| tournament |  | `getTournament()` | `updateTournament(value)` |

| createTime |  | `getCreateTime()` | `updateCreateTime(value)` |

| updateTime |  | `getUpdateTime()` | `updateUpdateTime(value)` |


**Relations (outgoing):**
- `tournamentMatch` → references another entity (select with `selectTournamentMatch()`)

- `tournamentTeam` → references another entity (select with `selectTournamentTeam()`)

- `goalCategory` → references another entity (select with `selectGoalCategory()`)

- `tournament` → references another entity (select with `selectTournament()`)


---

### Entity: MatchCard

- **Query**: `Q.matchCards()`
- **Filter prefix**: `with`
- **Filter suffix**: `ing`
- **Display name**: Match Card
- **Category**: Thing — uses `with`, `Containing`, `whichAre`

| Property | Type | Getter | Updater |
|----------|------|--------|---------|
| playerName |  | `getPlayerName()` | `updatePlayerName(value)` |

| minuteIssued |  | `getMinuteIssued()` | `updateMinuteIssued(value)` |

| tournamentMatch |  | `getTournamentMatch()` | `updateTournamentMatch(value)` |

| tournamentTeam |  | `getTournamentTeam()` | `updateTournamentTeam(value)` |

| cardCategory |  | `getCardCategory()` | `updateCardCategory(value)` |

| tournament |  | `getTournament()` | `updateTournament(value)` |

| createTime |  | `getCreateTime()` | `updateCreateTime(value)` |

| updateTime |  | `getUpdateTime()` | `updateUpdateTime(value)` |


**Relations (outgoing):**
- `tournamentMatch` → references another entity (select with `selectTournamentMatch()`)

- `tournamentTeam` → references another entity (select with `selectTournamentTeam()`)

- `cardCategory` → references another entity (select with `selectCardCategory()`)

- `tournament` → references another entity (select with `selectTournament()`)


---

### Entity: GroupStanding

- **Query**: `Q.groupStandings()`
- **Filter prefix**: `with`
- **Filter suffix**: `ing`
- **Display name**: Group Standing
- **Category**: Thing — uses `with`, `Containing`, `whichAre`

| Property | Type | Getter | Updater |
|----------|------|--------|---------|
| played |  | `getPlayed()` | `updatePlayed(value)` |

| won |  | `getWon()` | `updateWon(value)` |

| drawn |  | `getDrawn()` | `updateDrawn(value)` |

| lost |  | `getLost()` | `updateLost(value)` |

| goalsFor |  | `getGoalsFor()` | `updateGoalsFor(value)` |

| goalsAgainst |  | `getGoalsAgainst()` | `updateGoalsAgainst(value)` |

| goalDifference |  | `getGoalDifference()` | `updateGoalDifference(value)` |

| points |  | `getPoints()` | `updatePoints(value)` |

| standingRank |  | `getStandingRank()` | `updateStandingRank(value)` |

| tournamentTeam |  | `getTournamentTeam()` | `updateTournamentTeam(value)` |

| matchGroup |  | `getMatchGroup()` | `updateMatchGroup(value)` |

| tournament |  | `getTournament()` | `updateTournament(value)` |

| createTime |  | `getCreateTime()` | `updateCreateTime(value)` |

| updateTime |  | `getUpdateTime()` | `updateUpdateTime(value)` |


**Relations (outgoing):**
- `tournamentTeam` → references another entity (select with `selectTournamentTeam()`)

- `matchGroup` → references another entity (select with `selectMatchGroup()`)

- `tournament` → references another entity (select with `selectTournament()`)


---
