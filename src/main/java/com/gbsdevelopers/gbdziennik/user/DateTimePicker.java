package com.gbsdevelopers.gbdziennik.user;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * A DateTimePicker with configurable datetime format where both date and time can be changed
 * via the text field and the date can additionally be changed via the JavaFX default date picker.
 * Got from TornadoFX Controls.
 */
@SuppressWarnings("unused")
public class DateTimePicker extends DatePicker {

    /**
     * Date default format
     */
    public static final String DefaultFormat = "yyyy-MM-dd HH:mm";
    /**
     * DateTimeValue Property
     */
    private final ObjectProperty<LocalDateTime> dateTimeValue = new SimpleObjectProperty<>(LocalDateTime.now());
    /**
     * Formatter
     */
    private DateTimeFormatter formatter;
    /**
     * Format object
     */
    private final ObjectProperty<String> format = new SimpleObjectProperty<>() {
        public void set(String newValue) {
            super.set(newValue);
            formatter = DateTimeFormatter.ofPattern(newValue);
        }
    };

    /**
     * Class constructor
     */
    public DateTimePicker() {
        getStyleClass().add("datetime-picker");
        setFormat(DefaultFormat);
        setConverter(new InternalConverter());
        alignColumnCountWithFormat();

        // Synchronize changes to the underlying date value back to the dateTimeValue
        valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                dateTimeValue.set(null);
            } else {
                if (dateTimeValue.get() == null) {
                    dateTimeValue.set(LocalDateTime.of(newValue, LocalTime.now()));
                } else {
                    LocalTime time = dateTimeValue.get().toLocalTime();
                    dateTimeValue.set(LocalDateTime.of(newValue, time));
                }
            }
        });

        // Synchronize changes to dateTimeValue back to the underlying date value
        dateTimeValue.addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                LocalDate dateValue = newValue.toLocalDate();
                boolean forceUpdate = dateValue.equals(valueProperty().get());
                // Make sure the display is updated even when the date itself wasn't changed
                setValue(dateValue);
                if (forceUpdate) setConverter(new InternalConverter());
            } else {
                setValue(null);
            }

        });

        // Persist changes onblur
        getEditor().focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) simulateEnterPressed();
        });

    }

    /**
     * Column alignment
     */
    public void alignColumnCountWithFormat() {
        getEditor().setPrefColumnCount(getFormat().length());
    }

    /**
     * Simulating Enter press
     */
    private void simulateEnterPressed() {
        getEditor().commitValue();
    }

    /**
     * Getter for DateTimeValue
     *
     * @return value
     */
    public LocalDateTime getDateTimeValue() {
        return dateTimeValue.get();
    }

    /**
     * Setter for DateTimeValue
     *
     * @param value value
     */
    public void setDateTimeValue(LocalDateTime value) {
        this.dateTimeValue.set(value);
    }

    /**
     * Overrided method that returns date and time in necessary format
     *
     * @return value
     */
    @Override
    public String toString() {
        return this.getDateTimeValue().toString().replace("T", " ") + ":00";
    }

    /**
     * Getter for DateTimeValue Property
     *
     * @return value
     */
    public ObjectProperty<LocalDateTime> dateTimeValueProperty() {
        return dateTimeValue;
    }

    /**
     * Getter for Format
     *
     * @return value
     */
    public String getFormat() {
        return format.get();
    }

    /**
     * Setter for Format
     *
     * @param value value
     */
    public void setFormat(String value) {
        this.format.set(value);
        alignColumnCountWithFormat();
    }

    /**
     * Getter for Format Property
     *
     * @return
     */
    public ObjectProperty<String> formatProperty() {
        return format;
    }

    /**
     * Internal Converter class
     */
    class InternalConverter extends StringConverter<LocalDate> {
        /**
         * Converts LocalDate to String
         *
         * @param object LocalDate object
         * @return LocalDate in String
         */
        public String toString(LocalDate object) {
            LocalDateTime value = getDateTimeValue();
            return (value != null) ? value.format(formatter) : "";
        }

        /**
         * Converts String to LocalDate
         *
         * @param value LocalDate in String
         * @return LocalDate in object
         */
        public LocalDate fromString(String value) {
            if (value == null || value.isEmpty()) {
                dateTimeValue.set(null);
                return null;
            }

            dateTimeValue.set(LocalDateTime.parse(value, formatter));
            return dateTimeValue.get().toLocalDate();
        }
    }
}