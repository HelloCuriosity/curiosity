# Migrating to Curiosity 1.0.0

Curiosity 1.0.0 swaps Jetpack Compose Material 2
(`androidx.compose.material:material`) for Material 3
(`androidx.compose.material3:material3`). The `:curiosity`, `:navigation`, and
`:settings` artifacts now transitively expose Material 3 instead of Material 2.

This is a **breaking change**. Most consumers will need to touch their
`Theme`/`ColorScheme`/`Type` overrides and any code that read tokens from
`MaterialTheme` directly.

## Bump the dependency

```kotlin
dependencies {
    implementation("io.github.hellocuriosity:curiosity:1.0.0")
    implementation("io.github.hellocuriosity:navigation:1.0.0")
    implementation("io.github.hellocuriosity:settings:1.0.0")
    implementation("io.github.hellocuriosity:slack-feedback:1.0.0")
    testImplementation("io.github.hellocuriosity:test-utils:1.0.0")
}
```

If you also depend on `androidx.compose.material:material` directly, replace it
with `androidx.compose.material3:material3` and update your imports
(`androidx.compose.material.*` → `androidx.compose.material3.*`).

## Theme API

`Theme.toMaterialColors()` is renamed to `toMaterialColorScheme()`. If you call
`CuriosityTheme { ... }` you do not need to change anything — the helper still
wires everything up.

```kotlin
// 0.x
MaterialTheme(
    typography = theme.typography.toMaterialTypography(),
    colors = theme.colors.toMaterialColors(darkTheme),
) { ... }

// 1.0.0
MaterialTheme(
    typography = theme.typography.toMaterialTypography(),
    colorScheme = theme.colors.toMaterialColorScheme(darkTheme),
) { ... }
```

## `ColorScheme`

The `ColorScheme` data class has been redesigned around Material 3 tokens.
Defaults now match `androidx.compose.material3.lightColorScheme()` /
`darkColorScheme()`.

**Removed** (Material 2 only):
- `primaryVariant`, `primaryVariantDark`
- `secondaryVariant`, `secondaryVariantDark`

**Added** (Material 3):
- `primaryContainer` / `onPrimaryContainer` (+ `*Dark` twins)
- `secondaryContainer` / `onSecondaryContainer` (+ `*Dark`)
- `tertiary` / `onTertiary` / `tertiaryContainer` / `onTertiaryContainer` (+ `*Dark`)
- `errorContainer` / `onErrorContainer` (+ `*Dark`)
- `surfaceVariant` / `onSurfaceVariant` (+ `*Dark`)
- `outline`, `scrim` (+ `*Dark`)

**Migration:** if you used `primaryVariant` for an accent color, the closest
Material 3 equivalent is `primaryContainer`.

```kotlin
// 0.x
ColorScheme(
    primary = brandTeal,
    primaryVariant = brandRed,
    primaryDark = lightCyan,
    primaryVariantDark = brandRed,
)

// 1.0.0
ColorScheme(
    primary = brandTeal,
    primaryContainer = brandRed,
    primaryDark = lightCyan,
    primaryContainerDark = brandRed,
)
```

## `Type`

The `Type` data class no longer uses Material 2 type tokens. Replace each
field with its Material 3 counterpart:

| 0.x (Material 2) | 1.0.0 (Material 3) |
| --- | --- |
| `h1` | `displayLarge` |
| `h2` | `displayMedium` |
| `h3` | `displaySmall` |
| `h4` | `headlineLarge` |
| `h5` | `headlineMedium` |
| `h6` | `headlineSmall` |
| `subtitle1` | `titleMedium` |
| `subtitle2` | `titleSmall` |
| `body1` | `bodyLarge` |
| `body2` | `bodyMedium` |
| `button` | `labelLarge` |
| `caption` | `labelSmall` |
| `overline` | `labelMedium` |
| _(new)_ | `titleLarge` |
| _(new)_ | `bodySmall` |

The same mapping applies anywhere you read from `MaterialTheme.typography.*`
(e.g. `MaterialTheme.typography.h1` → `MaterialTheme.typography.displayLarge`).

```kotlin
// 0.x
Type(
    h1 = TextStyle(fontFamily = MyFontFamily, fontSize = 96.sp),
    body1 = TextStyle(fontFamily = MyFontFamily, fontSize = 16.sp),
)

// 1.0.0
Type(
    displayLarge = TextStyle(fontFamily = MyFontFamily, fontSize = 96.sp),
    bodyLarge = TextStyle(fontFamily = MyFontFamily, fontSize = 16.sp),
)
```

## Built-in text components

The default `style` of each built-in text wrapper now points at a Material 3
token. If you relied on the visual default, this may render slightly differently
because Material 3 sizes/letter-spacing differ from Material 2.

| Component | 0.x default | 1.0.0 default |
| --- | --- | --- |
| `LabelLarge` | `typography.h4` | `typography.headlineLarge` |
| `LabelMedium` | `typography.h5` | `typography.headlineMedium` |
| `LabelSmall` | `typography.h6` | `typography.headlineSmall` |
| `LabelTiny` | `typography.caption` | `typography.labelSmall` |
| `ContentLarge` | `typography.body1` | `typography.bodyLarge` |
| `ContentMedium` | `typography.body2` | `typography.bodyMedium` |

Public APIs (`text`, `modifier`, `color`, `textAlign`, `style`, `overflow`,
`maxLines`) are unchanged — only the default `style` value moved.

## `MaterialTheme.colors` → `MaterialTheme.colorScheme`

Anywhere your code reads colors from the Compose theme directly:

```kotlin
// 0.x
MaterialTheme.colors.primary
MaterialTheme.colors.onSurface

// 1.0.0
MaterialTheme.colorScheme.primary
MaterialTheme.colorScheme.onSurface
```

## `ButtonDefaults.buttonColors`

Parameter names have been aligned with Material 3:

| 0.x | 1.0.0 |
| --- | --- |
| `backgroundColor` | `containerColor` |
| `disabledBackgroundColor` | `disabledContainerColor` |
| `contentColor` | `contentColor` (unchanged) |
| `disabledContentColor` | `disabledContentColor` (unchanged) |

```kotlin
// 0.x
ButtonDefaults.buttonColors(
    backgroundColor = Color.Blue,
    disabledBackgroundColor = Color.Gray,
)

// 1.0.0
ButtonDefaults.buttonColors(
    containerColor = Color.Blue,
    disabledContainerColor = Color.Gray,
)
```

## `BottomNavigation`

The `:navigation` `BottomNavigation` wrapper now wraps Material 3's
`NavigationBar`/`NavigationBarItem` instead of the removed
`androidx.compose.material.BottomNavigation`. The wrapper's public API is
preserved, including the `backgroundColor`, `contentColor`, `selectedContentColor`,
`alwaysShowLabel`, `shouldBeSelected`, and `elevation` parameters. You should
not need to change call sites.

The visual treatment will differ slightly (Material 3 defaults to
`tonalElevation` rather than a shadow, and the active item now has its own
pill-shaped indicator).

## Removed Material 2 APIs

If your code referenced any of the following directly, you'll need to replace
them:

- `androidx.compose.material.ContentAlpha` — use a literal alpha (`0.38f` for
  the old `ContentAlpha.disabled`).
- `androidx.compose.material.LocalContentAlpha` — no Material 3 equivalent;
  drop the alpha and use `LocalContentColor.current` directly.
- `androidx.compose.material.primarySurface` — use `MaterialTheme.colorScheme.primary`
  (or `surface`, depending on your intent).
- `androidx.compose.material.Divider` — replace with
  `androidx.compose.material3.HorizontalDivider`.

## Things that did not change

- `:curiosity` package names and component constructors (only the default
  `style` parameter for text components moved).
- `:navigation` `Scene` interface and `BottomNavigation`/`currentRoute`
  signatures.
- `:settings` `ItemAction`, `ItemDivider`, `ItemSection`, `ItemToggle`,
  `ItemDropDown`, `ItemInfo` public APIs.
- Test utilities in `:test-utils`.
- The `material-icons-extended` artifact — it still ships under
  `androidx.compose.material:material-icons-extended` and is compatible with
  Material 3.
