package com.pedroabreudev.basicstatecodelab.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pedroabreudev.basicstatecodelab.ui.data.WellnessTask

@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit,
) {
    LazyColumn(modifier = modifier) {
        items(
            items = list,
            key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedChange = { checked ->
                    onCheckedTask(task, checked)
                },
                onClose = { onCloseTask(task) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WellnessTaskListPreview() {
    WellnessTaskList(
        modifier = Modifier,
        list = List(30) { taskItem ->
            WellnessTask(taskItem, "Task # $taskItem")
        },
        onCheckedTask = { _, _ -> },
        onCloseTask = {}
    )
}
