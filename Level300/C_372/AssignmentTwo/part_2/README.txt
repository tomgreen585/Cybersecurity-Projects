PART 2: Capture and Break-Down TLS Handshake with Wireshark

Objective:
    Capture and analyse the TLS 1.2 and TLS 1.3 handshakes using Wireshark 
    and identify cryptographic details.

Requirements:
1. Capture Setup:
    - Set up a TLS connection to a website using any secure service (e.g. your browser) or your own
    implementation (e.g. from Project 1)
    - Use Wireshark to capture network traffic during the TLS handshakes

Deliverables:
1. Wiresharp capture files (.pcap or .pcapng)
2. A PDF report (500 words limit) with screenshots:
    - identifying each step of the TLS handshake for both versions, clearly identifying each piece
    of exchanged information
    - plus mentioning what each side does in between the steps. For this, you may need to consult
    with the TLS 1.2 and TLS 1.3 documentations: RFC 5246 - The Transport Layer Security (TLS) Protocol 
    Version 1.2 and RFC 8446 - The Transport Layer Security (TLS) Protocol Version 1.3.

Submission for PART 2 Work:
    - Captures from using TLSv1.2 and TLSv1.3 can be seen in their corresponding .pcapng in the directory
    obtained from wireshark. This was obtained from running serverTLS.java and clientTLS.java from part_1.
    - Report with screenshots from the capture can be seen in the report along with analysis of each step
    in 1.2 and 1.3. have mentioned what happens in each step. Report is in ../CYBR372AS2 directory.