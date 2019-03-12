package com.lambdastudy.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

public class Subscription {
	private BigDecimal monthlyFee;
	private LocalDateTime begin;
	private Optional<LocalDateTime> end;
	private Customer customer;

	public Subscription(BigDecimal monthlyFee, LocalDateTime begin, Customer customer) {
		this.monthlyFee = monthlyFee;
		this.begin = begin;
		this.end = Optional.empty();
		this.customer = customer;
	}

	public Subscription(BigDecimal monthlyFee, LocalDateTime begin, LocalDateTime end, Customer customer) {
		this.monthlyFee = monthlyFee;
		this.begin = begin;
		this.end = Optional.of(end);
		this.customer = customer;
	}

	public BigDecimal getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(BigDecimal monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	public LocalDateTime getBegin() {
		return begin;
	}

	public void setBegin(LocalDateTime begin) {
		this.begin = begin;
	}

	public Optional<LocalDateTime> getEnd() {
		return end;
	}

	public void setEnd(Optional<LocalDateTime> end) {
		this.end = end;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BigDecimal getTotalPaid() {
		return getMonthlyFee()
				.multiply(new BigDecimal(ChronoUnit.MONTHS.between(getBegin(), getEnd().orElse(LocalDateTime.now()))));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((begin == null) ? 0 : begin.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((monthlyFee == null) ? 0 : monthlyFee.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscription other = (Subscription) obj;
		if (begin == null) {
			if (other.begin != null)
				return false;
		} else if (!begin.equals(other.begin))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (monthlyFee == null) {
			if (other.monthlyFee != null)
				return false;
		} else if (!monthlyFee.equals(other.monthlyFee))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subscription [monthlyFee=" + monthlyFee + ", begin=" + begin + ", end=" + end + ", customer=" + customer
				+ "]";
	}

}
