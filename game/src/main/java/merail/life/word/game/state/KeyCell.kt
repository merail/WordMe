package merail.life.word.game.state

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import merail.life.word.domain.KeyCellModel

internal typealias KeyCellsList = SnapshotStateList<SnapshotStateList<KeyCell>>

internal data class KeyCell(
    val key: Key,
    val state: KeyCellState = KeyCellState.DEFAULT,
)

internal fun List<List<KeyCellModel>>.toUiModel() = KeyCellsList().apply {
    this@toUiModel.forEach { keyCellModel ->
        add(
            element = keyCellModel.map { entry ->
                KeyCell(
                    key = Key.getKeyFromValue(entry.value),
                    state = entry.state.toUiModel(),
                )
            }.toMutableStateList(),
        )
    }
}

internal fun KeyCellsList?.orEmpty() = this ?: mutableStateListOf()