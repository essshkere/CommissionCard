fun main() {
    val transferDay = 100000 // сумма соврешенных переводов за день
    val transferMonth = 100000000 // сумма совершенных переводов за месяц
    val currentTransfer = 1000 // текущий перевод
    val card = "Visa" //Mastercard Visa Мир
    println(commissionCalc(card, currentTransfer, transferDay, transferMonth))
}

fun commissionCalc(card: String, currentTransfer: Int, transferDay: Int, transferMonth: Int): String {
    val monthLimitMactercard = 75000
    val monthlyTransfer = currentTransfer + transferDay + transferMonth
    val dayTransfer = currentTransfer + transferDay
    val commissionMastercard = 0.006
    val commissionMastercardFix = 0.006
    val commissionVisaMin = 35
    val commissionVisaPercent = 0.0075
    val monthLimit = 600_000
    val dayLimit = 150_000
    if (monthlyTransfer < monthLimit && dayTransfer < dayLimit) {
        val commission = when (card) {
            "Mastercard" -> if (monthlyTransfer < monthLimitMactercard) 0 else (currentTransfer * commissionMastercard + commissionMastercardFix).toInt()
            "Visa" -> if (currentTransfer * commissionVisaPercent < commissionVisaMin) commissionVisaMin else (currentTransfer * commissionVisaPercent).toInt()
            else -> {
                0 // Мир
            }
        }
        return "Ваша комиссия составит $commission руб.\n" +
                "Вы перевели за текущий день $dayTransfer руб.\n" +
                "Вы перевели за текущий месяц $monthlyTransfer руб.\n"

    } else
        return if (dayTransfer > dayLimit) "Перевод заблокирован, достигнут дневной лимит\n" + "Лимит: $dayLimit" else "Перевод заблокирован, достигнут месячный лимит\n" + "Лимит: $monthLimit"
}