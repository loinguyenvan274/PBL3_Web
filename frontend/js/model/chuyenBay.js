class Flight {
    constructor(idFlight,plane, currentSeat,departureDate, departureTime,arrivalDate, estimatedArrivalTime, fromLocation, toLocation, createdAt) {
        this.idFlight = idFlight;
        this.plane = plane;
        this.currentSeat = currentSeat;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate; 
        this.estimatedArrivalTime = estimatedArrivalTime;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.createdAt = createdAt;
    }

    // Getters and setters
    getIdFlight() {
        return this.idFlight;
    }

    setIdFlight(idFlight) {
        this.idFlight = idFlight;
    }

    getPlane() {
        return this.plane;
    }

    setPlane(plane) {
        this.plane = plane;
    }

    getCurrentSeat() {
        return this.currentSeat;
    }

    setCurrentSeat(currentSeat) {
        this.currentSeat = currentSeat;
    }

    getDepartureDate() {
        return this.departureDate;
    }

    setDepartureDate(departureDate) {
        this.departureDate = departureDate;
    }

    getDepartureTime() {
        return this.departureTime;
    }

    setDepartureTime(departureTime) {
        this.departureTime = departureTime;
    }

    getArrivalDate() {
        return this.arrivalDate;
    }

    setArrivalDate(arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    getEstimatedArrivalTime() {
        return this.estimatedArrivalTime;
    }

    setEstimatedArrivalTime(estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
    }

    getFromLocation() {
        return this.fromLocation;
    }

    setFromLocation(fromLocation) {
        this.fromLocation = fromLocation;
    }

    getToLocation() {
        return this.toLocation;
    }

    setToLocation(toLocation) {
        this.toLocation = toLocation;
    }

    getCreatedAt() {
        return this.createdAt;
    }

    setCreatedAt(createdAt) {
        this.createdAt = createdAt;
    }
}

export default Flight;